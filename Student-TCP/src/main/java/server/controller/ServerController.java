/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author thuc
 */
public class ServerController {

    private ServerSocket server;
    private int port = 8000;
    private StudentDao studentDao;
    private Socket clientSocket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public ServerController() {
        openServer(port);
        studentDao = new StudentDao();
        listenning();
    }

    private void openServer(int portNumber) {
        try {
            server = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenning() {
        try {
            Socket clientSocket = server.accept();
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            while (true) {
                String messgage = (String) ois.readObject();
                switch (messgage) {
                    case "search":
                        String revieced = (String) ois.readObject();
                        ArrayList<Student> students = studentDao.searchStudent(revieced);
                        oos.writeObject(students);
                        oos.flush();
                        break;
                    case "edit":
                        Student student = (Student) ois.readObject();
                        boolean checkEdit = studentDao.editStudent(student);
                        oos.writeObject(checkEdit);
                        oos.flush();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ServerController serverController = new ServerController();
    }
}
