//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.15 at 02:50:56 PM ICT 
//


package com.xmlwriter.example.model;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for responType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lembagaJasaKeuangan" type="{}ljkType"/>
 *         &lt;element name="suratJawaban" type="{}suratJawabanType"/>
 *         &lt;element name="responPermintaan" type="{}responPermintaanType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="respon")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responType", propOrder = {
    "lembagaJasaKeuangan",
    "suratJawaban",
    "responPermintaan"
})
public class ResponType {

    @XmlElement(required = true)
    protected LjkType lembagaJasaKeuangan;
    @XmlElement(required = true)
    protected SuratJawabanType suratJawaban;
    @XmlElement(required = true)
    protected ResponPermintaanType responPermintaan;

    /**
     * Gets the value of the lembagaJasaKeuangan property.
     * 
     * @return
     *     possible object is
     *     {@link LjkType }
     *     
     */
    public LjkType getLembagaJasaKeuangan() {
        return lembagaJasaKeuangan;
    }

    /**
     * Sets the value of the lembagaJasaKeuangan property.
     * 
     * @param value
     *     allowed object is
     *     {@link LjkType }
     *     
     */
    public void setLembagaJasaKeuangan(LjkType value) {
        this.lembagaJasaKeuangan = value;
    }

    /**
     * Gets the value of the suratJawaban property.
     * 
     * @return
     *     possible object is
     *     {@link SuratJawabanType }
     *     
     */
    public SuratJawabanType getSuratJawaban() {
        return suratJawaban;
    }

    /**
     * Sets the value of the suratJawaban property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuratJawabanType }
     *     
     */
    public void setSuratJawaban(SuratJawabanType value) {
        this.suratJawaban = value;
    }

    /**
     * Gets the value of the responPermintaan property.
     * 
     * @return
     *     possible object is
     *     {@link ResponPermintaanType }
     *     
     */
    public ResponPermintaanType getResponPermintaan() {
        return responPermintaan;
    }

    /**
     * Sets the value of the responPermintaan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponPermintaanType }
     *     
     */
    public void setResponPermintaan(ResponPermintaanType value) {
        this.responPermintaan = value;
    }

}
