package com.robinson.softwaricaapp.model;


import java.util.ArrayList;
import java.util.List;

public class Dataset {

    private String stuname;
    private String stuaddress;
    private String stuage;
    private String stugender;
    static List<Dataset> Slist=new ArrayList<>();

    public static List<Dataset> getSlist() {
        return Slist;
    }

    public static void setSlist(List<Dataset> slist) {
        Slist = slist;
    }

    public String getStugender() {
        return stugender;
    }

    public   Dataset(String stuname, String stuaddress, String stuage, String stugender) {
        this.stuname = stuname;
        this.stuaddress = stuaddress;
        this.stuage = stuage;
        this.stugender = stugender;
    }

    public void setStugender(String stugender) {
        this.stugender = stugender;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuaddress() {
        return stuaddress;
    }

    public void setStuaddress(String stuaddress) {
        this.stuaddress = stuaddress;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }


}
