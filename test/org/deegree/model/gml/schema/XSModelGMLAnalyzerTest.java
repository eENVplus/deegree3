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
package org.deegree.model.gml.schema;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;

import junit.framework.Assert;

import org.apache.xerces.xs.XSElementDeclaration;
import org.junit.Test;

/**
 * TODO add documentation here
 * 
 * @author <a href="mailto:schneider@lat-lon.de">Markus Schneider </a>
 * @author last edited by: $Author:$
 * 
 * @version $Revision:$, $Date:$
 */
public class XSModelGMLAnalyzerTest {

    @Test
    public void testPhilosopher()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer(
                                                              this.getClass().getResource( "Philosopher.xsd" ).toString(),
                                                              GMLVersion.VERSION_31 );
        List<XSElementDeclaration> featureElementDecls = analyzer.getFeatureElementDeclarations(
                                                                                                 "http://www.deegree.org/app",
                                                                                                 true );
        for ( XSElementDeclaration featureElementDecl : featureElementDecls ) {
            System.out.println( "- Feature type: " + featureElementDecl.getName() );
        }
        List<XSElementDeclaration> featureCollectionElementDecls = analyzer.getFeatureCollectionElementDeclarations(
                                                                                                                     null,
                                                                                                                     true );
        for ( XSElementDeclaration featureCollectionElementDecl : featureCollectionElementDecls ) {
            System.out.println( "- Feature collection type: " + featureCollectionElementDecl.getName() );
        }
        List<XSElementDeclaration> geometryElementDecls = analyzer.getGeometryElementDeclarations( null, true );
        for ( XSElementDeclaration geometryElementDecl : geometryElementDecls ) {
            System.out.println( "- Geometry type: " + geometryElementDecl.getName() );
        }
    }

    @Test
    public void testGML311AggregateElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutionts = getConcreteSubstitutions( "_GeometricAggregate", analyzer );
        for ( String string : substitutionts ) {
            System.out.println (string);
        }
        System.out.println (substitutionts.size());
    }    

    @Test
    public void testGML311PrimitiveElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutionts = getConcreteSubstitutions( "_GeometricPrimitive", analyzer );
        for ( String string : substitutionts ) {
            System.out.println (string);
        }
        System.out.println (substitutionts.size());
    }

    @Test
    public void testGML311ImplicitGeometryElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutionts = getConcreteSubstitutions( "_ImplicitGeometry", analyzer );
        for ( String string : substitutionts ) {
            System.out.println (string);
        }
        System.out.println (substitutionts.size());
    }    

    @Test
    public void testGML311GeometryElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutionts = getConcreteSubstitutions( "_Curve", analyzer );
        for ( String string : substitutionts ) {
            System.out.println (string);
        }
        System.out.println (substitutionts.size());
    }       
    
    @Test
    public void testGML311CurveElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutionts = getConcreteSubstitutions( "_Curve", analyzer );
        Assert.assertEquals( 4, substitutionts.size() );
        Assert.assertTrue( substitutionts.contains( "CompositeCurve" ) );
        Assert.assertTrue( substitutionts.contains( "Curve" ) );
        Assert.assertTrue( substitutionts.contains( "LineString" ) );
        Assert.assertTrue( substitutionts.contains( "OrientableCurve" ) );
    }

    @Test
    public void testGML311RingElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutionts = getConcreteSubstitutions( "_Ring", analyzer );
        Assert.assertEquals( 2, substitutionts.size() );
        Assert.assertTrue( substitutionts.contains( "LinearRing" ) );
        Assert.assertTrue( substitutionts.contains( "Ring" ) );
    }

    @Test
    public void testGML311SurfaceElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutions = getConcreteSubstitutions( "_Surface", analyzer );
        Assert.assertEquals( 7, substitutions.size() );
        Assert.assertTrue( substitutions.contains( "CompositeSurface" ) );
        Assert.assertTrue( substitutions.contains( "OrientableSurface" ) );        
        Assert.assertTrue( substitutions.contains( "Polygon" ) );
        Assert.assertTrue( substitutions.contains( "PolyhedralSurface" ) );
        Assert.assertTrue( substitutions.contains( "Surface" ) );
        Assert.assertTrue( substitutions.contains( "Tin" ) );
        Assert.assertTrue( substitutions.contains( "TriangulatedSurface" ) );
    }    

    @Test
    public void testGML311SolidElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        Set<String> substitutions = getConcreteSubstitutions( "_Solid", analyzer );
        Assert.assertEquals( 2, substitutions.size() );
        Assert.assertTrue( substitutions.contains( "CompositeSolid" ) );
        Assert.assertTrue( substitutions.contains( "Solid" ) );        
    }      
    
    @Test
    public void testGML311CurveSegments()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        List<XSElementDeclaration> elementDecls = analyzer.getSubstitutions( new QName( "http://www.opengis.net/gml",
                                                                                        "_CurveSegment" ),
                                                                             "http://www.opengis.net/gml", true );
        for ( XSElementDeclaration elementDecl : elementDecls ) {
            System.out.println( elementDecl.getName() );
        }
    }
    
    @Test
    public void testGML311SurfacePatches()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_31 );
        List<XSElementDeclaration> elementDecls = analyzer.getSubstitutions( new QName( "http://www.opengis.net/gml",
                                                                                        "_SurfacePatch" ),
                                                                             "http://www.opengis.net/gml", true );
        for ( XSElementDeclaration elementDecl : elementDecls ) {
            System.out.println( elementDecl.getName() );
        }
    }

    @Test
    public void testGML321CurveSegments()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.2.1/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_32 );
        List<XSElementDeclaration> elementDecls = analyzer.getSubstitutions(
                                                                             new QName(
                                                                                        "http://www.opengis.net/gml/3.2",
                                                                                        "AbstractCurveSegment" ),
                                                                             "http://www.opengis.net/gml/3.2", true );
        for ( XSElementDeclaration elementDecl : elementDecls ) {
            System.out.println( elementDecl.getName() );
        }
    }

    @Test
    public void testGML321SurfacePatches()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.2.1/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_32 );
        List<XSElementDeclaration> elementDecls = analyzer.getSubstitutions( new QName( "http://www.opengis.net/gml/3.2",
                                                                                        "AbstractSurfacePatch" ),
                                                                             "http://www.opengis.net/gml/3.2", true );
        for ( XSElementDeclaration elementDecl : elementDecls ) {
            System.out.println( elementDecl.getName() );
        }
    }    
    
    @Test
    public void testGML321GeometryElements()
                            throws ClassCastException, ClassNotFoundException, InstantiationException,
                            IllegalAccessException {

        String schemaURL = "http://schemas.opengis.net/gml/3.2.1/gml.xsd";
        XSModelGMLAnalyzer analyzer = new XSModelGMLAnalyzer( schemaURL, GMLVersion.VERSION_32 );
        List<XSElementDeclaration> elementDecls = analyzer.getSubstitutions(
                                                                             new QName(
                                                                                        "http://www.opengis.net/gml/3.2",
                                                                                        "AbstractGeometry" ),
                                                                             "http://www.opengis.net/gml/3.2", true );
        for ( XSElementDeclaration elementDecl : elementDecls ) {
            System.out.println( elementDecl.getName() );
        }
        System.out.println( elementDecls.size() );
    }    

    private Set<String> getConcreteSubstitutions( String localName, XSModelGMLAnalyzer analyzer ) {
        List<XSElementDeclaration> elementDecls = analyzer.getSubstitutions( new QName( "http://www.opengis.net/gml",
                                                                                        localName ),
                                                                             "http://www.opengis.net/gml", false );
        HashSet<String> localNames = new HashSet<String>();
        for ( XSElementDeclaration elementDecl : elementDecls ) {
            localNames.add( elementDecl.getName() );
        }
        return localNames;
    }
}
