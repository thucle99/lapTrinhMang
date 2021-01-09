/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import sun.management.HotspotInternal;

/**
 *
 * @author thuc
 */
public class ClientController {

    private Socket client;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private int port = 8000;
    private String host = "localhost";

    public ClientController() {
        try {
            client = new Socket(host, port);
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Student> searchStudent(String key) {
        try {
            oos.writeObject("search");
            oos.writeObject(key);
            oos.flush();
            ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
            return students;
        } catch (IOException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean editStudent(Student student) {
        try {
            oos.writeObject("edit");
            oos.writeObject(student);
            oos.flush();
            boolean checkEdit=(boolean) ois.readObject() ;
            return checkEdit ;
        } catch (IOException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
}
