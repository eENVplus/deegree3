//$HeadURL: svn+ssh://mschneider@svn.wald.intevation.org/deegree/deegree3/commons/trunk/src/org/deegree/model/feature/Feature.java $
/*----------------    FILE HEADER  ------------------------------------------

 This file is part of deegree.
 Copyright (C) 2001-2009 by:
 EXSE, Department of Geography, University of Bonn
 http://www.giub.uni-bonn.de/deegree/
 lat/lon GmbH
 http://www.lat-lon.de

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 Contact:

 Andreas Poth  
 lat/lon GmbH 
 Aennchenstr. 19
 53115 Bonn
 Germany
 E-Mail: poth@lat-lon.de

 Prof. Dr. Klaus Greve
 Department of Geography
 University of Bonn
 Meckenheimer Allee 166
 53115 Bonn
 Germany
 E-Mail: greve@giub.uni-bonn.de


 ---------------------------------------------------------------------------*/
package org.deegree.model.gml.validation;

import static javax.xml.stream.XMLStreamConstants.END_DOCUMENT;
import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

import org.deegree.commons.xml.XMLAdapter;
import org.deegree.commons.xml.XMLParsingException;
import org.deegree.commons.xml.stax.XMLStreamReaderWrapper;
import org.deegree.model.geometry.GeometryFactoryCreator;
import org.deegree.model.geometry.primitive.Curve;
import org.deegree.model.geometry.primitive.Point;
import org.deegree.model.geometry.primitive.Ring;
import org.deegree.model.geometry.primitive.surfacepatches.PolygonPatch;
import org.deegree.model.geometry.validation.GeometryValidationEventHandler;
import org.deegree.model.geometry.validation.GeometryValidator;
import org.deegree.model.gml.GML311GeometryParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Takes an XML stream as input (which should provide a GML geometry, GML feature or feature collection document) and
 * validates all contained <code>gml:_Geometry</code> elements (at all levels of the document).
 * <p>
 * The validator's reaction on topological issues can be customized by providing a {@link GMLValidationEventHandler}
 * which is also suitable for generating validation reports.
 * </p>
 * 
 * @author <a href="mailto:schneider@lat-lon.de">Markus Schneider </a>
 * @author last edited by: $Author:$
 * 
 * @version $Revision:$, $Date:$
 */
public class GML311GeometryValidator extends XMLAdapter {

    private static final Logger LOG = LoggerFactory.getLogger( GML311GeometryValidator.class );

    private GML311GeometryParser geomParser;

    private XMLStreamReaderWrapper xmlStream;

    private GMLValidationEventHandler gmlErrorHandler;

    /**
     * @param xmlStream
     * @param gmlErrorHandler
     */
    public GML311GeometryValidator( XMLStreamReaderWrapper xmlStream, GMLValidationEventHandler gmlErrorHandler ) {
        this.xmlStream = xmlStream;
        geomParser = new GML311GeometryParser( GeometryFactoryCreator.getInstance().getGeometryFactory(), xmlStream );
        this.gmlErrorHandler = gmlErrorHandler;
    }

    /**
     * @throws XMLStreamException
     */
    public void validateGeometries()
                            throws XMLStreamException {

        while ( xmlStream.next() != END_DOCUMENT ) {
            if ( xmlStream.getEventType() == START_ELEMENT ) {
                QName elName = xmlStream.getName();
                if ( geomParser.isGeometry( elName ) ) {
                    validateGeometryElement();
                }
            }
        }
    }

    private void validateGeometryElement() {
        Location location = xmlStream.getLocation();
        LOG.debug( "Validating GML geometry element ('" + xmlStream.getLocalName() + "') at line: "
                   + location.getLineNumber() + ", column: " + location.getColumnNumber() + "." );

        GMLElementIdentifier identifier = new GMLElementIdentifier( xmlStream );
        ValidationEventRedirector eventRedirector = new ValidationEventRedirector( gmlErrorHandler, identifier );
        GeometryValidator geometryValidator = new GeometryValidator( eventRedirector );
        try {
            geometryValidator.validateGeometry( geomParser.parseGeometry( "EPSG:28992" ) );
        } catch ( XMLParsingException e ) {
            gmlErrorHandler.geometryParsingError( identifier, e );
        } catch ( XMLStreamException e ) {
            gmlErrorHandler.geometryParsingError( identifier, e );
        }
    }

    private class ValidationEventRedirector implements GeometryValidationEventHandler {

        private GMLValidationEventHandler gmlErrorHandler;

        private GMLElementIdentifier topLevelGeometryElement;

        public ValidationEventRedirector( GMLValidationEventHandler gmlErrorHandler,
                                          GMLElementIdentifier topLevelGeometryElement ) {
            this.gmlErrorHandler = gmlErrorHandler;
            this.topLevelGeometryElement = topLevelGeometryElement;
        }

        @Override
        public boolean curveDiscontinuity( Curve curve, int segmentIdx, List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.curveDiscontinuity( curve, segmentIdx, affectedGeometryParticles, getAffectedElements() );
            return false;
        }

        @Override
        public boolean curvePointDuplication( Curve curve, Point point, List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.curvePointDuplication( curve, point, affectedGeometryParticles, getAffectedElements() );
            return false;
        }

        @Override
        public boolean curveSelfIntersection( Curve curve, Point location, List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.curveSelfIntersection( curve, location, affectedGeometryParticles, getAffectedElements() );
            return false;
        }

        @Override
        public boolean exteriorRingCW( PolygonPatch patch, List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.exteriorRingCW( patch, affectedGeometryParticles, getAffectedElements() );
            return false;
        }

        @Override
        public boolean interiorRingCCW( PolygonPatch patch, List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.interiorRingCCW( patch, affectedGeometryParticles, getAffectedElements() );
            return false;
        }

        @Override
        public boolean interiorRingIntersectsExterior( PolygonPatch patch, int ringIdx,
                                                       List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.interiorRingIntersectsExterior( patch, ringIdx, affectedGeometryParticles,
                                                            getAffectedElements() );
            return false;
        }

        @Override
        public boolean interiorRingOutsideExterior( PolygonPatch patch, int ringIdx,
                                                    List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.interiorRingOutsideExterior( patch, ringIdx, affectedGeometryParticles,
                                                         getAffectedElements() );
            return false;
        }

        @Override
        public boolean interiorRingTouchesExterior( PolygonPatch patch, int ringIdx,
                                                    List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.interiorRingTouchesExterior( patch, ringIdx, affectedGeometryParticles,
                                                         getAffectedElements() );
            return false;
        }

        @Override
        public boolean interiorRingsIntersect( PolygonPatch patch, int ring1Idx, int ring2Idx,
                                               List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.interiorRingsIntersect( patch, ring1Idx, ring2Idx, affectedGeometryParticles,
                                                    getAffectedElements() );
            return false;
        }

        @Override
        public boolean interiorRingsTouch( PolygonPatch patch, int ring1Idx, int ring2Idx,
                                           List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.interiorRingsTouch( patch, ring1Idx, ring2Idx, affectedGeometryParticles,
                                                getAffectedElements() );
            return false;
        }

        @Override
        public boolean interiorRingsWithin( PolygonPatch patch, int ring1Idx, int ring2Idx,
                                            List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.interiorRingsWithin( patch, ring1Idx, ring2Idx, affectedGeometryParticles,
                                                 getAffectedElements() );
            return false;
        }

        @Override
        public boolean ringNotClosed( Ring ring, List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.ringNotClosed( ring, affectedGeometryParticles, getAffectedElements() );
            return false;
        }

        @Override
        public boolean ringSelfIntersection( Ring ring, Point location, List<Object> affectedGeometryParticles ) {
            gmlErrorHandler.ringSelfIntersection( ring, location, affectedGeometryParticles, getAffectedElements() );
            return false;
        }

        private List<GMLElementIdentifier> getAffectedElements() {
            return Collections.singletonList( topLevelGeometryElement );
        }
    }
}
