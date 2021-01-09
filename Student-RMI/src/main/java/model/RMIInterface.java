/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author thuc
 */
public interface RMIInterface extends Remote{
    public ArrayList<Student> searchStudent(String key) throws RemoteException;
    public boolean  editStudent(Student student) throws  RemoteException;
}
