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

package org.deegree.model.geometry.linearization;

import java.util.ArrayList;
import java.util.List;

import org.deegree.model.geometry.GeometryFactory;
import org.deegree.model.geometry.primitive.Polygon;
import org.deegree.model.geometry.primitive.Ring;
import org.deegree.model.geometry.primitive.Surface;
import org.deegree.model.geometry.primitive.surfacepatches.PolygonPatch;
import org.deegree.model.geometry.primitive.surfacepatches.SurfacePatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.LinearRing;

/**
 * Provides methods for the linearization of planar surfaces, i.e. {@link PolygonPatch}es and {@link Polygon}s.
 * 
 * @author <a href="mailto:schneider@lat-lon.de">Markus Schneider</a>
 * @author last edited by: $Author: elmasri$
 * 
 * @version $Revision: $, $Date: 9 May 2008 13:09:29$
 */
public class SurfaceLinearizer {

    private GeometryFactory geomFac;

    private CurveLinearizer curveLinearizer;

    /**
     * @param geomFac
     */
    public SurfaceLinearizer( GeometryFactory geomFac ) {
        this.geomFac = geomFac;
        this.curveLinearizer = new CurveLinearizer( geomFac );
    }

    /**
     * Returns a linearized version of the given {@link Surface} geometry, i.e. the patches only use linear interpolated
     * curves as boundaries.
     * <p>
     * NOTE: This method respects the semantic difference between {@link Surface} and {@link Polygon} geometries: if the
     * input is a {@link Polygon}, a polygon geometry will be returned.
     * 
     * @param surface
     * @param crit
     * @return linearized version of the input curve
     */
    public Surface linearize( Surface surface, LinearizationCriterion crit ) {
        Surface linearizedSurface = null;
        switch ( surface.getSurfaceType() ) {
        case Polygon: {
            Polygon polygon = (Polygon) surface;
            Ring exteriorRing = polygon.getExteriorRing();
            Ring linearizedExteriorRing = null;
            if ( linearizedExteriorRing != null ) {
                linearizedExteriorRing = (Ring) curveLinearizer.linearize( exteriorRing, crit );
            }
            List<Ring> interiorRings = polygon.getInteriorRings();
            List<Ring> linearizedInteriorRings = new ArrayList<Ring>( interiorRings.size() );
            for ( Ring interiorRing : interiorRings ) {
                linearizedInteriorRings.add( (Ring) curveLinearizer.linearize( interiorRing, crit ) );
            }
            linearizedSurface = geomFac.createPolygon( null, null, linearizedExteriorRing, interiorRings );
            break;
        }
        default: {
            List<SurfacePatch> patches = surface.getPatches();
            List<PolygonPatch> linearizedPatches = new ArrayList<PolygonPatch>( patches.size() );
            for ( SurfacePatch patch : surface.getPatches() ) {
                if ( !( patch instanceof PolygonPatch ) ) {
                    String msg = "Linearization of non planar surface patches is not implemented";
                    throw new IllegalArgumentException( msg );
                }
                linearizedPatches.add( linearize( (PolygonPatch) patch, crit ) );
            }
            linearizedSurface = geomFac.createPolyhedralSurface( surface.getId(), surface.getCoordinateSystem(),
                                                                 linearizedPatches );
        }
        }
        return linearizedSurface;
    }

    /**
     * Returns a linearized version (i.e. a {@link PolygonPatch} that only uses {@link LinearRing}s as boundaries) of
     * the given {@link PolygonPatch}.
     * 
     * @param patch
     * @param crit
     *            determines the interpolation quality / number of interpolation points
     * @return {@link PolygonPatch} that only uses {@link LinearRing}s as boundaries
     */
    public PolygonPatch linearize( PolygonPatch patch, LinearizationCriterion crit ) {

        Ring exteriorRing = patch.getExteriorRing();
        Ring linearizedExteriorRing = null;
        if ( exteriorRing != null ) {
            linearizedExteriorRing = (Ring) curveLinearizer.linearize( exteriorRing, crit );
        }

        List<Ring> interiorRings = patch.getInteriorRings();
        List<Ring> linearizedInteriorRings = new ArrayList<Ring>( interiorRings.size() );
        for ( Ring interiorRing : interiorRings ) {
            linearizedInteriorRings.add( (Ring) curveLinearizer.linearize( interiorRing, crit ) );
        }
        return geomFac.createPolygonPatch( linearizedExteriorRing, interiorRings );
    }
}
