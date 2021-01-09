/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import model.RMIInterface;
import model.Student;

/**
 *
 * @author thuc
 */
public class ServerController extends UnicastRemoteObject implements RMIInterface{

    private  String rmiServer = "rmiServer" ;
    private int port =8000 ;
    private Registry registry;
    private StudenDao studenDao ;
    
    public ServerController() throws RemoteException{
        studenDao = new StudenDao();
        registry =LocateRegistry.createRegistry(port);
        registry.rebind(rmiServer, this);
        System.out.println("Server is running");
    }
    
    @Override
    public ArrayList<Student> searchStudent(String key) throws RemoteException {
        return studenDao.searchStudent(key) ;
    }

    @Override
    public boolean editStudent(Student student) throws RemoteException {
        return studenDao.editStudent(student);
    }
    
    public static void main(String[] args) throws RemoteException {
        ServerController serverController = new ServerController();
    }
}
