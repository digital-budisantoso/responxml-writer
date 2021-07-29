package com.xmlwriter.example.dao;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usrdjp on 4/14/2021.
 */
public class RekeningDao {
    public RekeningDao(){

    }

    public List<String[]> getDtLjk(){
        List<String[]> res = new ArrayList<String[]>();
        try{
            CSVReader reader = new CSVReader(new FileReader("./dt_ljk.csv"));
            res = reader.readAll();
        }catch(Exception e){
            System.out.println(e);
        }

        return res;
    }

    public List<String[]> getDtWp(){
        List<String[]> res = new ArrayList<String[]>();
        try{
            CSVReader reader = new CSVReader(new FileReader("./dt_wp.csv"));
            res = reader.readAll();
        }catch(Exception e){
            System.out.println(e);
        }

        return res;
    }

    public List<String[]> getDtSurat(String noSurat){
        List<String[]> res = new ArrayList<String[]>();
        List<String[]> respon = new ArrayList<String[]>();
        try{
            CSVReader reader = new CSVReader(new FileReader("./dt_surat.csv"));
            res = reader.readAll();
            for(String[] surat : res){
                if(surat[2].equals(noSurat)){
                    respon.add(surat);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return respon;
    }

    public List<String[]> getDtInforekByNik(String nik){
        List<String[]> res = new ArrayList<String[]>();
        try{
            CSVReader reader = new CSVReader(new FileReader("./dt_inforek.csv"));
            List<String[]> lsrek = reader.readAll();
            for(String[] rek : lsrek){
                if(rek[10].equals(nik)){
                    res.add(rek);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return res;
    }


    public List<String[]> getDtInforekByNpwp(String npwp){
        List<String[]> res = new ArrayList<String[]>();
        try{
            CSVReader reader = new CSVReader(new FileReader("./dt_inforek.csv"));
            List<String[]> lsrek = reader.readAll();
            for(String[] rek : lsrek){
                if(rek[0].equals(npwp)){
                    res.add(rek);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return res;
    }

    public List<String[]> getDtMutasirek(String norek){
        List<String[]> res = new ArrayList<String[]>();
        try{
            CSVReader reader = new CSVReader(new FileReader("./dt_mutasirek.csv"));
            List<String[]> lsmutasi = reader.readAll();
            for(String[] mutasi : lsmutasi){
                if(mutasi[0].equals(norek)){
                    res.add(mutasi);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return res;
    }
}
