package com.xmlwriter.example.model.req;

import java.io.Serializable;
import java.math.BigDecimal;

public class MdlPermintaanDtl implements Serializable {
	private BigDecimal idSrtDtl;
	private BigDecimal idSrtHdr;
	private String nikNasabah;
	private String nmNasabah;
	private String npwpNasabah;
	private String alamatNasabah;
	public BigDecimal getIdSrtDtl() {
		return idSrtDtl;
	}
	public void setIdSrtDtl(BigDecimal idSrtDtl) {
		this.idSrtDtl = idSrtDtl;
	}
	public BigDecimal getIdSrtHdr() {
		return idSrtHdr;
	}
	public void setIdSrtHdr(BigDecimal idSrtHdr) {
		this.idSrtHdr = idSrtHdr;
	}
	public String getNikNasabah() {
		return nikNasabah;
	}
	public void setNikNasabah(String nikNasabah) {
		this.nikNasabah = nikNasabah;
	}
	public String getNmNasabah() {
		return nmNasabah;
	}
	public void setNmNasabah(String nmNasabah) {
		this.nmNasabah = nmNasabah;
	}
	public String getNpwpNasabah() {
		return npwpNasabah;
	}
	public void setNpwpNasabah(String npwpNasabah) {
		this.npwpNasabah = npwpNasabah;
	}
	public String getAlamatNasabah() {
		return alamatNasabah;
	}
	public void setAlamatNasabah(String alamatNasabah) {
		this.alamatNasabah = alamatNasabah;
	}
	
}
