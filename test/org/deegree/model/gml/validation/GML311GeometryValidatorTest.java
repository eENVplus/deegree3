//$HeadURL$
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

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.deegree.commons.xml.stax.XMLStreamReaderWrapper;
import org.deegree.model.geometry.GeometryFactory;
import org.deegree.model.geometry.GeometryFactoryCreator;
import org.deegree.model.geometry.primitive.Curve;
import org.deegree.model.geometry.primitive.Point;
import org.deegree.model.geometry.primitive.Ring;
import org.deegree.model.geometry.primitive.surfacepatches.PolygonPatch;
import org.deegree.model.gml.GML311GeometryParserTest;
import org.junit.Test;

/**
 * 
 * @author <a href="mailto:schneider@lat-lon.de">Markus Schneider </a>
 * @author last edited by: $Author:$
 * 
 * @version $Revision:$, $Date:$
 */
public class GML311GeometryValidatorTest {

    private static GeometryFactory geomFac = GeometryFactoryCreator.getInstance().getGeometryFactory( "Standard" );

    private static final String BASE_DIR = "testdata/geometries/";

    @Test
    public void validateCurve()
                            throws XMLStreamException, FactoryConfigurationError, IOException, ClassCastException,
                            ClassNotFoundException, InstantiationException, IllegalAccessException {

        XMLStreamReaderWrapper xmlReader = getParser( "Curve.gml" );
        TestGMLValidationEventHandler eventHandler = new TestGMLValidationEventHandler();
        GML311GeometryValidator validator = new GML311GeometryValidator( xmlReader, eventHandler );
        validator.validateGeometries();
    }

    @Test
    public void validateInvalidCurve()
                            throws XMLStreamException, FactoryConfigurationError, IOException, ClassCastException,
                            ClassNotFoundException, InstantiationException, IllegalAccessException {

        XMLStreamReaderWrapper xmlReader = getParser( "invalid/Curve_discontinuity.gml" );
        TestGMLValidationEventHandler eventHandler = new TestGMLValidationEventHandler();
        GML311GeometryValidator validator = new GML311GeometryValidator( xmlReader, eventHandler );
        validator.validateGeometries();
    }

    @Test
    public void validateInvalidRing()
                            throws XMLStreamException, FactoryConfigurationError, IOException {

        XMLStreamReaderWrapper xmlReader = getParser( "invalid/Ring_not_closed.gml" );
        TestGMLValidationEventHandler eventHandler = new TestGMLValidationEventHandler();
        GML311GeometryValidator validator = new GML311GeometryValidator( xmlReader, eventHandler );
        validator.validateGeometries();
    }

    @Test
    public void validateInvalidPolygon1()
                            throws XMLStreamException, FactoryConfigurationError, IOException {
        XMLStreamReaderWrapper xmlReader = getParser( "invalid/Polygon_exterior_clockwise.gml" );
        TestGMLValidationEventHandler eventHandler = new TestGMLValidationEventHandler();
        GML311GeometryValidator validator = new GML311GeometryValidator( xmlReader, eventHandler );
        validator.validateGeometries();
    }
    
    @Test
    public void validateInvalidPolygon2()
                            throws XMLStreamException, FactoryConfigurationError, IOException {
        XMLStreamReaderWrapper xmlReader = getParser( "invalid/Polygon_noexterior.gml" );
        TestGMLValidationEventHandler eventHandler = new TestGMLValidationEventHandler();
        GML311GeometryValidator validator = new GML311GeometryValidator( xmlReader, eventHandler );
        validator.validateGeometries();
    }    

    @Test
    public void validateBestemmingsplan()
                            throws XMLStreamException, FactoryConfigurationError, IOException {
        XMLStreamReaderWrapper xmlReader = new XMLStreamReaderWrapper(
                                                                       new URL(
                                                                                "file:///home/schneider/wsl_fromogr.gml" ) );
        TestGMLValidationEventHandler eventHandler = new TestGMLValidationEventHandler();
        GML311GeometryValidator validator = new GML311GeometryValidator( xmlReader, eventHandler );
        validator.validateGeometries();
    }

    private XMLStreamReaderWrapper getParser( String fileName )
                            throws XMLStreamException, FactoryConfigurationError, IOException {
        XMLStreamReaderWrapper xmlReader = new XMLStreamReaderWrapper(
                                                                       GML311GeometryParserTest.class.getResource( BASE_DIR
                                                                                                                   + fileName ) );
        return xmlReader;
    }

}

class TestGMLValidationEventHandler implements GMLValidationEventHandler {

    @Override
    public boolean curveDiscontinuity( Curve curve, int segmentIdx, List<Object> affectedGeometryParticles,
                                       List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "A (possibly nested) curve/ring geometry has a discontinuity between segment " + segmentIdx + " and "
               + ( segmentIdx + 1 ) + ".";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean curvePointDuplication( Curve curve, Point point, List<Object> affectedGeometryParticles,
                                          List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "A (possibly nested) curve/ring geometry has a duplicated point: " + point + ".";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean curveSelfIntersection( Curve curve, Point location, List<Object> affectedGeometryParticles,
                                          List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "A (possibly nested) curve/ring geometry has a self-intersection at or near point: " + location + ".";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean exteriorRingCW( PolygonPatch patch, List<Object> affectedGeometryParticles,
                                   List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "The exterior ring of a (possibly nested) surface patch has a clockwise orientation.";
//        System.out.println( msg );
        return false;
    }

    @Override
    public void geometryParsingError( GMLElementIdentifier geometryElement, Exception e ) {
        e.printStackTrace();

    }

    @Override
    public boolean interiorRingCCW( PolygonPatch patch, List<Object> affectedGeometryParticles,
                                    List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "An interior ring of a (possibly nested) surface patch has a counter-clockwise orientation.";
//        System.out.println( msg );
        return false;
    }

    @Override
    public boolean interiorRingIntersectsExterior( PolygonPatch patch, int ringIdx,
                                                   List<Object> affectedGeometryParticles,
                                                   List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "An interior ring of a (possibly nested) surface patch intersects the exterior.";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean interiorRingOutsideExterior( PolygonPatch patch, int ringIdx,
                                                List<Object> affectedGeometryParticles,
                                                List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "An interior ring of a (possibly nested) surface patch is outside the exterior.";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean interiorRingTouchesExterior( PolygonPatch patch, int ringIdx,
                                                List<Object> affectedGeometryParticles,
                                                List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "An interior ring of a (possibly nested) surface patch touches the exterior.";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean interiorRingsIntersect( PolygonPatch patch, int ring1Idx, int ring2Idx,
                                           List<Object> affectedGeometryParticles,
                                           List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "An interior ring of a (possibly nested) surface patch intersects the exterior.";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean interiorRingsTouch( PolygonPatch patch, int ring1Idx, int ring2Idx,
                                       List<Object> affectedGeometryParticles,
                                       List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "Two interior rings of a (possibly nested) surface patch touch.";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean interiorRingsWithin( PolygonPatch patch, int ring1Idx, int ring2Idx,
                                        List<Object> affectedGeometryParticles,
                                        List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "Two interior rings of a (possibly nested) surface patch lie inside each other.";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean ringNotClosed( Ring ring, List<Object> affectedGeometryParticles,
                                  List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element '" + affectedElements.get( 0 ) + "'. ";
        msg += "A (possibly nested) ring is not closed, start point " + ring.getStartPoint()
               + " is not equal to end point " + ring.getEndPoint() + ".";
        System.out.println( msg );
        return false;
    }

    @Override
    public boolean ringSelfIntersection( Ring ring, Point location, List<Object> affectedGeometryParticles,
                                         List<GMLElementIdentifier> affectedElements ) {
        String msg = "Geometry error in element " + affectedElements.get( 0 ) + ": ";
        msg += "A (possibly nested) ring self-intersects at or near point: " + location + ".";
        System.out.println( msg );
        return false;
    }
}
