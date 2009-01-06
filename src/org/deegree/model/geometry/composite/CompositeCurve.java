//$HeadURL$
/*----------------    FILE HEADER  ------------------------------------------
 This file is part of deegree.
 Copyright (C) 2001-2009 by:
 Department of Geography, University of Bonn
 http://www.giub.uni-bonn.de/deegree/
 lat/lon GmbH
 http://www.lat-lon.de

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.
 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 Lesser General Public License for more details.
 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 Contact:

 Andreas Poth
 lat/lon GmbH
 Aennchenstr. 19
 53177 Bonn
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
package org.deegree.model.geometry.composite;

import org.deegree.model.geometry.Geometry;
import org.deegree.model.geometry.primitive.Curve;

/**
 * <code>CompositeCurve</code> is a geometry type with the same geometric properties as the (primitive) {@link Curve}
 * type. It is defined by a sequence of member curves such that the each curve in the sequence ends at the start point
 * of the subsequent curve in the list.
 * 
 * @author <a href="mailto:poth@lat-lon.de">Andreas Poth</a>
 * @author last edited by: $Author$
 * 
 * @version. $Revision$, $Date$
 */
public interface CompositeCurve extends Curve, CompositeGeometry<Curve> {

    /**
     * Must return {@link Geometry.GeometryType#COMPOSITE_PRIMITIVE}.
     * 
     * @return {@link Geometry.GeometryType#COMPOSITE_PRIMITIVE}
     */
    @Override
    public GeometryType getGeometryType();

    /**
     * Must always return {@link Curve.CurveType#CompositeCurve}.
     * 
     * @return {@link Curve.CurveType#CompositeCurve}
     */
    @Override
    public CurveType getCurveType();
}