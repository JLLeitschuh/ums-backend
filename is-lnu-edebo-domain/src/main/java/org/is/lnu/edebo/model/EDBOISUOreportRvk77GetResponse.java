//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.27 at 12:51:32 AM EET 
//


package org.is.lnu.edebo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EDBOISUOreport_rvk77GetResult" type="{http://edboservice.ua/}ArrayOfDEDBOISUOreport_rvk77" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "edboisuOreportRvk77GetResult"
})
@XmlRootElement(name = "EDBOISUOreport_rvk77GetResponse")
public class EDBOISUOreportRvk77GetResponse {

    @XmlElement(name = "EDBOISUOreport_rvk77GetResult")
    protected ArrayOfDEDBOISUOreportRvk77 edboisuOreportRvk77GetResult;

    /**
     * Gets the value of the edboisuOreportRvk77GetResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDEDBOISUOreportRvk77 }
     *     
     */
    public ArrayOfDEDBOISUOreportRvk77 getEDBOISUOreportRvk77GetResult() {
        return edboisuOreportRvk77GetResult;
    }

    /**
     * Sets the value of the edboisuOreportRvk77GetResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDEDBOISUOreportRvk77 }
     *     
     */
    public void setEDBOISUOreportRvk77GetResult(ArrayOfDEDBOISUOreportRvk77 value) {
        this.edboisuOreportRvk77GetResult = value;
    }

}