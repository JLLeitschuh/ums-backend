//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.27 at 12:51:32 AM EET 
//


package org.is.lnu.edebo.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDOrdersOfEnrollmentsAdditionalOrdersData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDOrdersOfEnrollmentsAdditionalOrdersData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dOrdersOfEnrollmentsAdditionalOrdersData" type="{http://edboservice.ua/}dOrdersOfEnrollmentsAdditionalOrdersData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDOrdersOfEnrollmentsAdditionalOrdersData", propOrder = {
    "dOrdersOfEnrollmentsAdditionalOrdersData"
})
public class ArrayOfDOrdersOfEnrollmentsAdditionalOrdersData {

    @XmlElement(nillable = true)
    protected List<DOrdersOfEnrollmentsAdditionalOrdersData> dOrdersOfEnrollmentsAdditionalOrdersData;

    /**
     * Gets the value of the dOrdersOfEnrollmentsAdditionalOrdersData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dOrdersOfEnrollmentsAdditionalOrdersData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDOrdersOfEnrollmentsAdditionalOrdersData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DOrdersOfEnrollmentsAdditionalOrdersData }
     * 
     * 
     */
    public List<DOrdersOfEnrollmentsAdditionalOrdersData> getDOrdersOfEnrollmentsAdditionalOrdersData() {
        if (dOrdersOfEnrollmentsAdditionalOrdersData == null) {
            dOrdersOfEnrollmentsAdditionalOrdersData = new ArrayList<DOrdersOfEnrollmentsAdditionalOrdersData>();
        }
        return this.dOrdersOfEnrollmentsAdditionalOrdersData;
    }

}