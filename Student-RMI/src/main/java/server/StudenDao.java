/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.mysql.cj.xdevapi.PreparableStatement;
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
public class StudenDao extends MainDao {

    public StudenDao() {
        super();
        Connection con = getConnection();
    }

    public ArrayList<Student> searchStudent(String key) {
        try {
            ArrayList<Student> result = new ArrayList<>();
            PreparedStatement pre = con.prepareStatement("select * from student where ten like ?");
            pre.setString(1, "%" + key + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getString("ten"),
                        rs.getString("ngaysinh"), rs.getString("khoa"), rs.getString("quequan"));
                result.add(student);
            }
            return result;

        } catch (SQLException ex) {
            Logger.getLogger(StudenDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }
    
    public boolean editStudent(Student student){
        try {
            PreparedStatement pre=con.prepareStatement("update student set"
                    + " ten=?,ngaysinh=?,khoa=?,quequan=? where id=?");
            pre.setString(1, student.getTen());
            pre.setString(2, student.getNgaysinh());
            pre.setString(3, student.getKhoa());
            pre.setString(4, student.getQuequan());
            pre.setInt(5, student.getId());
            
            pre.executeUpdate() ;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudenDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
    }
}
