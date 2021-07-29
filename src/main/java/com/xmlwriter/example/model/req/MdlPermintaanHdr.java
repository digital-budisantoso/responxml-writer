package com.xmlwriter.example.model.req;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MdlPermintaanHdr implements Serializable {
	private BigDecimal idSrtHdr;
	private String noSurat;
	private Date tglSurat;
	private BigDecimal tahun;
	private String nipPejabat;
	private String namaPejabat;
	private String nmJabatan;
	private String kdUnitPengusul;
	private String nmUnitPengusul;
	private String periodeAwal;
	private String periodeAkhir;
	private String status;
	public BigDecimal getIdSrtHdr() {
		return idSrtHdr;
	}
	public void setIdSrtHdr(BigDecimal idSrtHdr) {
		this.idSrtHdr = idSrtHdr;
	}
	public String getNoSurat() {
		return noSurat;
	}
	public void setNoSurat(String noSurat) {
		this.noSurat = noSurat;
	}
	public Date getTglSurat() {
		return tglSurat;
	}
	public void setTglSurat(Date tglSurat) {
		this.tglSurat = tglSurat;
	}
	public BigDecimal getTahun() {
		return tahun;
	}
	public void setTahun(BigDecimal tahun) {
		this.tahun = tahun;
	}
	public String getNipPejabat() {
		return nipPejabat;
	}
	public void setNipPejabat(String nipPejabat) {
		this.nipPejabat = nipPejabat;
	}
	public String getNamaPejabat() {
		return namaPejabat;
	}
	public void setNamaPejabat(String namaPejabat) {
		this.namaPejabat = namaPejabat;
	}
	public String getNmJabatan() {
		return nmJabatan;
	}
	public void setNmJabatan(String nmJabatan) {
		this.nmJabatan = nmJabatan;
	}
	public String getKdUnitPengusul() {
		return kdUnitPengusul;
	}
	public void setKdUnitPengusul(String kdUnitPengusul) {
		this.kdUnitPengusul = kdUnitPengusul;
	}
	public String getNmUnitPengusul() {
		return nmUnitPengusul;
	}
	public void setNmUnitPengusul(String nmUnitPengusul) {
		this.nmUnitPengusul = nmUnitPengusul;
	}
	public String getPeriodeAwal() {
		return periodeAwal;
	}
	public void setPeriodeAwal(String periodeAwal) {
		this.periodeAwal = periodeAwal;
	}
	public String getPeriodeAkhir() {
		return periodeAkhir;
	}
	public void setPeriodeAkhir(String periodeAkhir) {
		this.periodeAkhir = periodeAkhir;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
