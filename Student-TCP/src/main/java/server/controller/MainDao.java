/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thuc
 */
public class MainDao {
    Connection con;
    String jdbcURL="jdbc:mysql://localhost:3306/student?useSSL=false" ;
    String userName="root";
    String passWord ="123456" ;
    
    public MainDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            con=DriverManager.getConnection(jdbcURL,userName,passWord) ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainDao.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return con ;
    } 
}
