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
 * <p>Java class for dExaminationSheetExamenTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dExaminationSheetExamenTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id_ExaminationSheetExamenType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExaminationSheetExamenTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dExaminationSheetExamenTypes", propOrder = {
    "idExaminationSheetExamenType",
    "examinationSheetExamenTypeName"
})
public class DExaminationSheetExamenTypes {

    @XmlElement(name = "Id_ExaminationSheetExamenType")
    protected int idExaminationSheetExamenType;
    @XmlElement(name = "ExaminationSheetExamenTypeName")
    protected String examinationSheetExamenTypeName;

    /**
     * Gets the value of the idExaminationSheetExamenType property.
     * 
     */
    public int getIdExaminationSheetExamenType() {
        return idExaminationSheetExamenType;
    }

    /**
     * Sets the value of the idExaminationSheetExamenType property.
     * 
     */
    public void setIdExaminationSheetExamenType(int value) {
        this.idExaminationSheetExamenType = value;
    }

    /**
     * Gets the value of the examinationSheetExamenTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExaminationSheetExamenTypeName() {
        return examinationSheetExamenTypeName;
    }

    /**
     * Sets the value of the examinationSheetExamenTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExaminationSheetExamenTypeName(String value) {
        this.examinationSheetExamenTypeName = value;
    }

}