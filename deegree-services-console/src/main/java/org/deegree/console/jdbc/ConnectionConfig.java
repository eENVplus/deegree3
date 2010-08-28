//$HeadURL: svn+ssh://mschneider@svn.wald.intevation.org/deegree/base/trunk/resources/eclipse/files_template.xml $
/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2010 by:
 - Department of Geography, University of Bonn -
 and
 - lat/lon GmbH -

 This library is free software; you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation; either version 2.1 of the License, or (at your option)
 any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 details.
 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation, Inc.,
 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 Contact information:

 lat/lon GmbH
 Aennchenstr. 19, 53177 Bonn
 Germany
 http://lat-lon.de/

 Department of Geography, University of Bonn
 Prof. Dr. Klaus Greve
 Postfach 1147, 53001 Bonn
 Germany
 http://www.geographie.uni-bonn.de/deegree/

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/
package org.deegree.console.jdbc;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;

import lombok.Getter;

import org.deegree.commons.config.DeegreeWorkspace;
import org.deegree.console.XMLConfig;
import org.deegree.services.controller.OGCFrontController;

/**
 * TODO add class documentation here
 * 
 * @author <a href="mailto:schneider@lat-lon.de">Markus Schneider</a>
 * @author last edited by: $Author: markus $
 * 
 * @version $Revision: $, $Date: $
 */
@ManagedBean
@RequestScoped
public class ConnectionConfig extends XMLConfig {

    private static final long serialVersionUID = 5777982897759843271L;

    private static URL CONFIG_TEMPLATE = ConnectionsConfig.class.getResource( "template.xml" );

    private static URL SCHEMA_URL = ConnectionsConfig.class.getResource( "/META-INF/schemas/jdbc/0.5.0/jdbc.xsd" );

    @Getter
    private String status = "BLA";

    public ConnectionConfig() {
        super( getBaseDir(), SCHEMA_URL, CONFIG_TEMPLATE );
    }

    public ConnectionConfig( String id ) {
        this();
        setId( id );
    }

    public void create()
                            throws IOException {
        ConnectionsConfig.addConnection( this );
        super.create();
    }

    public void delete() {
        System.out.println( "Delete called..." );
        super.delete();
        ConnectionsConfig.removeConnection( this );
    }

    protected static File getBaseDir() {
        DeegreeWorkspace ws = OGCFrontController.getServiceWorkspace();
        return new File( ws.getLocation(), "jdbc" );
    }
}
