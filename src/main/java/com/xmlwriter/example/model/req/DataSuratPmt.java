package com.xmlwriter.example.model.req;

import java.io.Serializable;
import java.util.List;


public class DataSuratPmt implements Serializable {
	private MdlPermintaanHdr pmtHdr;
	private List<MdlPermintaanDtl> pmtDtls;
	public MdlPermintaanHdr getPmtHdr() {
		return pmtHdr;
	}
	public void setPmtHdr(MdlPermintaanHdr pmtHdr) {
		this.pmtHdr = pmtHdr;
	}
	public List<MdlPermintaanDtl> getPmtDtls() {
		return pmtDtls;
	}
	public void setPmtDtls(List<MdlPermintaanDtl> pmtDtls) {
		this.pmtDtls = pmtDtls;
	}	
}
