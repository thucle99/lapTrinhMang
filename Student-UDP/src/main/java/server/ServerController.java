/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

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

/**
 *
 * @author thuc
 */
public class ServerController {

    private StudentDao studentDao;
    private DatagramSocket server;
    private int port = 8000;
    private DatagramPacket recivePacket;
    ByteArrayInputStream bais;
    ByteArrayOutputStream baos;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ServerController() {
        openServer(port);
        studentDao = new StudentDao();
        System.out.println("Server is Running");
        listen();
    }

    public void openServer(int port) {
        try {
            server = new DatagramSocket(port);
        } catch (SocketException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object receive() {
        try {
            byte[] receiveData = new byte[10240];
            recivePacket = new DatagramPacket(receiveData, receiveData.length);
            server.receive(recivePacket);
            bais = new ByteArrayInputStream(receiveData);
            ois = new ObjectInputStream(bais);
            Object response = ois.readObject();
            return response;
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

            int clientPort = recivePacket.getPort();
            byte[] sendData = baos.toByteArray();

            InetAddress IPAddress = recivePacket.getAddress();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);
            server.send(sendPacket);
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listen() {
        while (true) {
            String message = (String) receive();
            System.out.println("message.." + message);
            switch (message) {
                case "search":
                    String key = (String) receive();
                    ArrayList<Student> students = studentDao.searchStudent(key);
                    send(students);
                    break;
                case "edit":
                    Student student = (Student) receive();
                    send(studentDao.editStudent(student));
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ServerController serverController = new ServerController();
    }
}
