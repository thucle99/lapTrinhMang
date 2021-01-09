/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RMIInterface;
import model.Student;

/**
 *
 * @author thuc
 */
public class ClientController {
    private String rmiServer = "rmiServer";
    private Registry registry;
    private RMIInterface rMIInterface;
    private String host="localhost";
    private int port=8000;
    
    public ClientController(){
        try {
            registry= LocateRegistry.getRegistry(host,port);
            rMIInterface = (RMIInterface) registry.lookup(rmiServer) ;
        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NotBoundException e){
            e.printStackTrace();
        }
    }
    
   public ArrayList<Student> searchStudent(String key)  {
        try {
            return rMIInterface.searchStudent(key) ;
        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
   public boolean editStudent(Student student) {
        try {
            return rMIInterface.editStudent(student);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
