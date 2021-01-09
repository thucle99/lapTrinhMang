/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import server.ServerController;
import server.StudentDao;

/**
 *
 * @author thuc
 */
public class ClientController {

    private DatagramSocket client;
    private int clientPort = 8080;
    private int serverPort = 8000;
    private String host = "localhost";
    private DatagramPacket recivePacket;
    ByteArrayInputStream bais;
    ByteArrayOutputStream baos;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ClientController() {
        try {
            client = new DatagramSocket(clientPort);
        } catch (SocketException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object receive() {
        try {
            byte[] receiveData = new byte[10240];
            recivePacket = new DatagramPacket(receiveData, receiveData.length);
            client.receive(recivePacket);

            bais = new ByteArrayInputStream(receiveData);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void send(Object result) {
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(result);
            oos.flush();

            byte[] sendData = baos.toByteArray();
            InetAddress IPServer = InetAddress.getByName(host) ;
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPServer, serverPort);
            client.send(sendPacket);
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Student> searchStudent(String key) {
        send("search");
        send(key);
        ArrayList<Student> students = (ArrayList<Student>) receive();
        return students;
    }

    public boolean editStudent(Student student) {
        System.out.println("student.."+student.getQueQuan());
        send("edit");
        send(student);
        boolean result = (boolean) receive();
        return result;
    }
}
