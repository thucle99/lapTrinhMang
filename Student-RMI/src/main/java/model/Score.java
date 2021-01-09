/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Student;
import model.Student;
import model.Subject;
import model.Subject;

/**
 *
 * @author thuc
 */
public class Score {
    private Student student;
    private Subject subject ;
    private double cc;
    private double tbkt;
    private double  btl ;
    private double  cuoiky;

    public Score() {
    }

    public Score(Student student, Subject subject, double cc, double tbkt, double btl, double cuoiky) {
        this.student = student;
        this.subject = subject;
        this.cc = cc;
        this.tbkt = tbkt;
        this.btl = btl;
        this.cuoiky = cuoiky;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    public double getCuoiky() {
        return cuoiky;
    }

    public void setCuoiky(double cuoiky) {
        this.cuoiky = cuoiky;
    }
    
    
}
