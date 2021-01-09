/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Okami
 */
public class Score implements Serializable{
    private Subject monHoc;
    private Student sinhVien;
    private double cc;
    private double tbkt;
    private double btl;
    private double thiCuoi;

    public Score() {
    }

    public Score(Subject monHoc, Student sinhVien, double cc, double tbkt, double btl, double thiCuoi) {
        this.monHoc = monHoc;
        this.sinhVien = sinhVien;
        this.cc = cc;
        this.tbkt = tbkt;
        this.btl = btl;
        this.thiCuoi = thiCuoi;
    }

    public Subject getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(Subject monHoc) {
        this.monHoc = monHoc;
    }

    public Student getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(Student sinhVien) {
        this.sinhVien = sinhVien;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public double getTbkt() {
        return tbkt;
    }

    public void setTbkt(double tbkt) {
        this.tbkt = tbkt;
    }

    public double getBtl() {
        return btl;
    }

    public void setBtl(double btl) {
        this.btl = btl;
    }

    public double getThiCuoi() {
        return thiCuoi;
    }

    public void setThiCuoi(double thiCuoi) {
        this.thiCuoi = thiCuoi;
    }
}
