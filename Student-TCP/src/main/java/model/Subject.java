/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thuc
 */
public class Subject {
    private int id;
    private String ten;
    private int sotc;
    private String mota;

    public Subject() {
    }

    public Subject(int id, String ten, int sotc, String mota) {
        this.id = id;
        this.ten = ten;
        this.sotc = sotc;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSotc() {
        return sotc;
    }

    public void setSotc(int sotc) {
        this.sotc = sotc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    
}
