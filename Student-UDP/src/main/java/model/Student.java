/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Okami
 */
public class Student implements Serializable{
    private int id;
    private String ten;
    private String ngaySinh;
    private String khoa;
    private String queQuan;

    public Student() {
    }

    public Student(int id, String ten, String ngaySinh, String khoa, String queQuan) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.khoa = khoa;
        this.queQuan = queQuan;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public Object[] toObjects(){
        return new Object[]{id,ten,ngaySinh,khoa,queQuan};
    }
}
