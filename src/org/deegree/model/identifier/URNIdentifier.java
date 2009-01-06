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

package org.deegree.model.identifier;

import org.deegree.commons.utils.ArrayUtils;

/**
 * 
 * 
 * @author <a href="mailto:poth@lat-lon.de">Andreas Poth</a>
 * @author last edited by: $Author: poth $
 * 
 * @version. $Revision: 6251 $, $Date: 2007-03-19 16:59:28 +0100 (Mo, 19 Mrz 2007) $
 */
public class URNIdentifier extends StringIdentifier {

    private String[] parts;

    /**
     * @param urn
     */
    public URNIdentifier( String urn ) {
        super( urn );
        parts = ArrayUtils.toArray( urn, ":", false );
    }

    @Override
    public boolean equals( Object other ) {
        if ( other == null || !( other instanceof URNIdentifier ) ) {
            return false;
        }
        return value.equals( ( (URNIdentifier) other ).value );
    }

    /**
     * 
     * @return parts of encapsulated URN as String array
     */
    public String[] getParts() {
        return parts;
    }

    /**
     * 
     * @param index
     * @return part of a URN identified by passed index
     */
    public String getPart( int index ) {
        return parts[index];
    }

}
