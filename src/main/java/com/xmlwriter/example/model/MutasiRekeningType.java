//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.06 at 10:07:24 AM ICT 
//


package com.xmlwriter.example.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for mutasiRekeningType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mutasiRekeningType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="noRekening" type="{}noRekeningType"/>
 *         &lt;element name="noRekeningLawan" type="{}noRekeningType"/>
 *         &lt;element name="kdJnsTrans">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="01"/>
 *               &lt;enumeration value="02"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="kdBankLawan" type="{}kdBankType" minOccurs="0"/>
 *         &lt;element name="namaRekeningLawan" type="{}namaType" minOccurs="0"/>
 *         &lt;element name="tglTransaksi" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="kodeDebitCredit">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="dr"/>
 *               &lt;enumeration value="cr"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nilaiTransaksi" type="{}nilaiType"/>
 *         &lt;element name="berita" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mutasiRekeningType", propOrder = {
    "noRekening",
    "noRekeningLawan",
    "kdJnsTrans",
    "kdBankLawan",
    "namaRekeningLawan",
    "tglTransaksi",
    "kodeDebitCredit",
    "nilaiTransaksi",
    "berita"
})
public class MutasiRekeningType {

    @XmlElement(required = true)
    protected String noRekening;
    @XmlElement(required = true)
    protected String noRekeningLawan;
    @XmlElement(required = true)
    protected String kdJnsTrans;
    protected String kdBankLawan;
    protected String namaRekeningLawan;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar tglTransaksi;
    @XmlElement(required = true)
    protected String kodeDebitCredit;
    @XmlElement(required = true)
    protected BigDecimal nilaiTransaksi;
    @XmlElement(required = true)
    protected String berita;

    /**
     * Gets the value of the noRekening property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoRekening() {
        return noRekening;
    }

    /**
     * Sets the value of the noRekening property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoRekening(String value) {
        this.noRekening = value;
    }

    /**
     * Gets the value of the noRekeningLawan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoRekeningLawan() {
        return noRekeningLawan;
    }

    /**
     * Sets the value of the noRekeningLawan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoRekeningLawan(String value) {
        this.noRekeningLawan = value;
    }

    /**
     * Gets the value of the kdJnsTrans property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKdJnsTrans() {
        return kdJnsTrans;
    }

    /**
     * Sets the value of the kdJnsTrans property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKdJnsTrans(String value) {
        this.kdJnsTrans = value;
    }

    /**
     * Gets the value of the kdBankLawan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKdBankLawan() {
        return kdBankLawan;
    }

    /**
     * Sets the value of the kdBankLawan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKdBankLawan(String value) {
        this.kdBankLawan = value;
    }

    /**
     * Gets the value of the namaRekeningLawan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamaRekeningLawan() {
        return namaRekeningLawan;
    }

    /**
     * Sets the value of the namaRekeningLawan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamaRekeningLawan(String value) {
        this.namaRekeningLawan = value;
    }

    /**
     * Gets the value of the tglTransaksi property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTglTransaksi() {
        return tglTransaksi;
    }

    /**
     * Sets the value of the tglTransaksi property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTglTransaksi(XMLGregorianCalendar value) {
        this.tglTransaksi = value;
    }

    /**
     * Gets the value of the kodeDebitCredit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodeDebitCredit() {
        return kodeDebitCredit;
    }

    /**
     * Sets the value of the kodeDebitCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodeDebitCredit(String value) {
        this.kodeDebitCredit = value;
    }

    /**
     * Gets the value of the nilaiTransaksi property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNilaiTransaksi() {
        return nilaiTransaksi;
    }

    /**
     * Sets the value of the nilaiTransaksi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNilaiTransaksi(BigDecimal value) {
        this.nilaiTransaksi = value;
    }

    /**
     * Gets the value of the berita property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBerita() {
        return berita;
    }

    /**
     * Sets the value of the berita property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBerita(String value) {
        this.berita = value;
    }

}
