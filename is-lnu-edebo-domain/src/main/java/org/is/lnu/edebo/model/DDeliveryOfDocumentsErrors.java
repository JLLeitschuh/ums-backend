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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dDeliveryOfDocumentsErrors complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dDeliveryOfDocumentsErrors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id_DeliveryOfDocuments" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DataCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DataErrorCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dDeliveryOfDocumentsErrors", propOrder = {
    "idDeliveryOfDocuments",
    "dataCount",
    "dataErrorCount"
})
public class DDeliveryOfDocumentsErrors {

    @XmlElement(name = "Id_DeliveryOfDocuments")
    protected int idDeliveryOfDocuments;
    @XmlElement(name = "DataCount")
    protected int dataCount;
    @XmlElement(name = "DataErrorCount")
    protected int dataErrorCount;

    /**
     * Gets the value of the idDeliveryOfDocuments property.
     * 
     */
    public int getIdDeliveryOfDocuments() {
        return idDeliveryOfDocuments;
    }

    /**
     * Sets the value of the idDeliveryOfDocuments property.
     * 
     */
    public void setIdDeliveryOfDocuments(int value) {
        this.idDeliveryOfDocuments = value;
    }

    /**
     * Gets the value of the dataCount property.
     * 
     */
    public int getDataCount() {
        return dataCount;
    }

    /**
     * Sets the value of the dataCount property.
     * 
     */
    public void setDataCount(int value) {
        this.dataCount = value;
    }

    /**
     * Gets the value of the dataErrorCount property.
     * 
     */
    public int getDataErrorCount() {
        return dataErrorCount;
    }

    /**
     * Sets the value of the dataErrorCount property.
     * 
     */
    public void setDataErrorCount(int value) {
        this.dataErrorCount = value;
    }

}