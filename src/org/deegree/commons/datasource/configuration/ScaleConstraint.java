//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.04.09 at 05:36:42 PM MESZ 
//


package org.deegree.commons.datasource.configuration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.deegree.commons.configuration.ScaleDenominatorsType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deegree.org/datasource}AbstractConstraintType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.deegree.org/commons}ScaleDenominators"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "scaleDenominators"
})
public class ScaleConstraint
    extends AbstractConstraintType
{

    @XmlElement(name = "ScaleDenominators", namespace = "http://www.deegree.org/commons", required = true)
    protected ScaleDenominatorsType scaleDenominators;

    /**
     * Gets the value of the scaleDenominators property.
     * 
     * @return
     *     possible object is
     *     {@link ScaleDenominatorsType }
     *     
     */
    public ScaleDenominatorsType getScaleDenominators() {
        return scaleDenominators;
    }

    /**
     * Sets the value of the scaleDenominators property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScaleDenominatorsType }
     *     
     */
    public void setScaleDenominators(ScaleDenominatorsType value) {
        this.scaleDenominators = value;
    }

}
