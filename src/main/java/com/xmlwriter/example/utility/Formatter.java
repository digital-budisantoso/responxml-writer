package com.xmlwriter.example.utility;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by usrdjp on 4/13/2021.
 */
public class Formatter {
    public Formatter(){

    }

    public XMLGregorianCalendar toXMLGregCal(String tgl){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        XMLGregorianCalendar xmlGregCal = null;
        try {
            Date date = format.parse(tgl);

            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);

            xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        }catch(Exception e){
            System.out.println(e);
        }
        return xmlGregCal;
    }

    public XMLGregorianCalendar dateToXMLGregCal(Date tgl){
        XMLGregorianCalendar xmlGregCal = null;
        try {

            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(tgl);

            xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        }catch(Exception e){
            System.out.println(e);
        }
        return xmlGregCal;
    }
}
