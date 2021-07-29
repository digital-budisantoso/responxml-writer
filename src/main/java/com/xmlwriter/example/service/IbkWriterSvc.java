package com.xmlwriter.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmlwriter.example.dao.RekeningDao;
import com.xmlwriter.example.model.*;
import com.xmlwriter.example.model.req.DataSuratPmt;
import com.xmlwriter.example.model.req.MdlPermintaanDtl;
import com.xmlwriter.example.model.req.MdlPermintaanHdr;
import com.xmlwriter.example.utility.Formatter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usrdjp on 4/13/2021.
 */
public class IbkWriterSvc {
    public IbkWriterSvc(){

    }

    public List<DataSuratPmt> getDatareq(String pathFile) throws Exception{
        List<DataSuratPmt> respon = new ArrayList<DataSuratPmt>();
        ObjectMapper objectMapper = new ObjectMapper();
        respon = objectMapper.readValue(new File(pathFile),new TypeReference<List<DataSuratPmt>>(){});
        return respon;
    }

    public void marshal() throws JAXBException, IOException, Exception {
        JAXBContext context = JAXBContext.newInstance(ResponType.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Formatter formatter = new Formatter();
        RekeningDao rekDao = new RekeningDao();

        //membaca data permintaan dari file JSON
        List<DataSuratPmt> dataPmt = getDatareq("data-permintaan-775.json");

        System.out.println("Membaca data permintaan dari file JSON : Terdapat "+dataPmt.size()+" permintaan");

        for(DataSuratPmt pmt : dataPmt){
            Instant startWrite = Instant.now();

            MdlPermintaanHdr hdrPmt = pmt.getPmtHdr();
            System.out.println("Memproses jawaban untuk permintaan nomor : "+hdrPmt.getNoSurat());

            //membuat objek respon xml ibk
            System.out.println("1. Membuat Objek Respon");
            ResponType respon = new ResponType();

            //mengambil data ljk
            List<String[]> lsLjk = rekDao.getDtLjk();
            String[] dtLjk = lsLjk.size()>0 ? lsLjk.get(0): null;

            //membentuk objek LJK
            System.out.println("2. Mengisi identitas LJK pada objek respon");
            LjkType ljk = new LjkType();
            ljk.setNpwpLjk(dtLjk[0]);
            ljk.setNamaLjk(dtLjk[1]);

            //,mengambil data surat jawaban
            System.out.println("3. Mengisi data surat jawaban pada objek respon");
            List<String[]> lsSurat = rekDao.getDtSurat(hdrPmt.getNoSurat());
            String[] dtSurat = lsSurat.size()>0 ? lsSurat.get(0): null;

            //membuat objek surat jawaban
            SuratJawabanType suratJawaban = new SuratJawabanType();
            suratJawaban.setNoRespon(dtSurat[0]);
            XMLGregorianCalendar xmlGregCal = formatter.toXMLGregCal(dtSurat[1]);
            suratJawaban.setTglRespon(xmlGregCal);
            suratJawaban.setNoSuratPermintaan(hdrPmt.getNoSurat());
            suratJawaban.setStatusRespon(dtSurat[3]);
            suratJawaban.setNamaPj(dtSurat[4]);
            suratJawaban.setJabatanPj(dtSurat[5]);

            //membuat objek respon permintaan
            System.out.println("4. Membuat objek respon permintaan");
            ResponPermintaanType responPermintaan = new ResponPermintaanType();
            List<ResponDataType> lsResponData = new ArrayList();
            List<MdlPermintaanDtl> lsWp = pmt.getPmtDtls();
            System.out.println("4.1. Melakukan pencarian data rekening keuangan untuk "+lsWp.size()+" WP sesuai permintaan dari DJP");
            for(MdlPermintaanDtl wp : lsWp){
                System.out.println("Mencari data rekening keuangan untuk NIK "+wp.getNikNasabah()+" atau NPWP "+wp.getNpwpNasabah());
                ResponDataType responData = new ResponDataType();
                responData.setNik(wp.getNikNasabah());
                responData.setNpwp(wp.getNpwpNasabah());
                responData.setNamaWp(wp.getNmNasabah());

                //melakukan pencarian rekening keuangan WP
                List<String[]> lsRek = new ArrayList<>();
                if(wp.getNikNasabah() != null || !wp.getNikNasabah().equals("")){
                    //apabila pada data WP terdapat NIK
                    lsRek = rekDao.getDtInforekByNik(wp.getNikNasabah());
                    //apabila tidak ditemukan dengan key NIK maka dicari dengan key NPWP
                    if(lsRek.size() == 0){
                        lsRek = rekDao.getDtInforekByNpwp(wp.getNpwpNasabah());
                        if(lsRek.size() > 0){
                            System.out.println("Ditemukan "+lsRek.size()+" rekening keuangan atas NPWP "+wp.getNpwpNasabah());
                        }
                    }else{
                        System.out.println("Ditemukan "+lsRek.size()+" rekening keuangan atas NIK "+wp.getNikNasabah());
                    }
                }else{
                    lsRek = rekDao.getDtInforekByNpwp(wp.getNpwpNasabah());
                    if(lsRek.size() > 0){
                        System.out.println("Ditemukan "+lsRek.size()+" rekening keuangan atas NPWP "+wp.getNpwpNasabah());
                    }
                }

                String stsNasabah = lsRek.size() > 0 ? "1" : "0";

                responData.setStatusNasabah(stsNasabah);

                //apabila WP merupakan nasabah dari LJK
                if(stsNasabah.equals("1")){
                    DataKeuanganType dataKeuangan = new DataKeuanganType();
                    List<DataRekeningType> lsDataRek = new ArrayList<DataRekeningType>();
                    System.out.println("4.2. Membentuk data rekening");
                    for(String[] rek : lsRek){
                        System.out.println("Membentuk data rekening dan mutasinya atas no rekening : "+rek[5]);
                        DataRekeningType dataRekening = new DataRekeningType();

                        InfoRekeningType infoRekening = new InfoRekeningType();
                        infoRekening.setCif(rek[1]);
                        infoRekening.setMataUang(CurrType.valueOf(rek[2]));
                        infoRekening.setStatusRekening(rek[3]);
                        infoRekening.setNamaRekening(rek[4]);
                        infoRekening.setNoRekening(rek[5]);
                        infoRekening.setSaldoAkhir(new BigDecimal(rek[6]));
                        infoRekening.setSaldoAwal(new BigDecimal(rek[7]));
                        infoRekening.setTglAkhir(formatter.toXMLGregCal(rek[8]));
                        infoRekening.setTglAwal(formatter.toXMLGregCal(rek[9]));
                        infoRekening.setTglBukaRek(formatter.toXMLGregCal(rek[10]));

                        List<MutasiRekeningType> lsMutasiRek = new ArrayList<MutasiRekeningType>();

                        //mengambil data mutasi dari sumber data dengan parameter nomor rekening
                        List<String[]> lsMutasi = rekDao.getDtMutasirek(rek[5]);
                        for(String[] mutasi : lsMutasi){
                            MutasiRekeningType mutasiRekening = new MutasiRekeningType();
                            mutasiRekening.setNoRekening(mutasi[0]);
                            mutasiRekening.setBerita(mutasi[1]);
                            mutasiRekening.setKdBankLawan(mutasi[2]);
                            mutasiRekening.setKdJnsTrans(mutasi[3]);
                            mutasiRekening.setKodeDebitCredit(mutasi[4]);
                            mutasiRekening.setNilaiTransaksi(new BigDecimal(mutasi[5]));
                            mutasiRekening.setNoRekeningLawan(mutasi[6]);
                            mutasiRekening.setTglTransaksi(formatter.toXMLGregCal(mutasi[7]));

                            lsMutasiRek.add(mutasiRekening);
                        }

                        dataRekening.setInfoRekening(infoRekening);
                        dataRekening.getMutasiRekening().addAll(lsMutasiRek);

                        lsDataRek.add(dataRekening);

                    }
                    dataKeuangan.getDataRekening().addAll(lsDataRek);

                    responData.setDataKeuangan(dataKeuangan);

                }else{
                    System.out.println("Tidak ditemukan rekening keuangan atas NIK "+wp.getNikNasabah()+" atau NPWP "+wp.getNpwpNasabah());
                }

                lsResponData.add(responData);
            }



            responPermintaan.getResponData().addAll(lsResponData);

            respon.setLembagaJasaKeuangan(ljk);
            respon.setSuratJawaban(suratJawaban);
            respon.setResponPermintaan(responPermintaan);

            System.out.println("4.3. Marshaling objek respon ke dalam format xml");
            mar.marshal(respon,new File("./responibk"+dtSurat[0]+".xml"));

            Instant finishWrite = Instant.now();
            long timeWriteElapsed = Duration.between(startWrite, finishWrite).toMillis()/1000;
            System.out.println("File responibk"+dtSurat[0]+".xml berhasil dibentuk dalam "+timeWriteElapsed+" detik");

            Instant startValidate = Instant.now();

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resource = classLoader.getResource("respon-ibk-v1_1_0.xsd");

            System.out.println("5. Memulai validasi atas file responibk"+dtSurat[0]+".xml");
            IbkFullValidator validator = new IbkFullValidator();
            validator.validate(resource.getPath(), "./responibk"+dtSurat[0]+".xml");
            Instant finishValidate = Instant.now();
            long timeValidateElapsed = Duration.between(startValidate, finishValidate).toMillis()/1000;
            System.out.println("File responibk"+dtSurat[0]+".xml berhasil divalidasi dalam "+timeValidateElapsed+" detik");
        }
    }
}
