/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.swing.Action;
import javax.xml.crypto.Data;

/**
 *
 * @author thuc
 */
public class Student implements Serializable{
    private int id;
    private String ten;
    private String ngaysinh;
    private String khoa;
    private String quequan;

    public Student() {
    }

    public Student(int id, String ten, String ngaysinh, String khoa, String quequan) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.khoa = khoa;
        this.quequan = quequan;
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

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    
    public Object[] toObjects(){
        return new Object[]{id,ten,ngaysinh,khoa,quequan};
    }
    
}
