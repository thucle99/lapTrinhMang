/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author thuc
 */
public class StudentDao extends  MainDao{
    public StudentDao(){
        super();
        Connection con=getConnection();
    }
    
    public ArrayList<Student> searchStudent(String key){
        ArrayList<Student> students = new ArrayList<>() ;
        try {
            PreparedStatement pre= con.prepareStatement("select * from student where ten like ?") ;
            pre.setString(1, key);
            ResultSet rs = pre.executeQuery();
            
            while(rs.next()){
                Student student =new Student(rs.getInt("id"),rs.getString("ten"),
                    rs.getString("ngaysinh"),rs.getString("khoa"),rs.getString("quequan"));
                students.add(student) ;
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean editStudent(Student student){
        System.out.println("editStudent..."+student.getQueQuan());
        try {
            PreparedStatement pre=con.prepareStatement("update student set ten=?,ngaysinh=?, khoa=?,quequan=? where id=? ");
            pre.setString(1, student.getTen());
            pre.setString(2, student.getNgaySinh());
            pre.setString(3, student.getKhoa());
            pre.setString(4, student.getQueQuan());
            pre.setInt(5, student.getId());
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
