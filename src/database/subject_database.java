/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Frames.Panels.Assign_studentsPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vbnfv
 */
public class subject_database {

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_subject(String id, String s1, String s2, String s3, String s4, String s5, String s6,String s7) throws SQLException {
        try {
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into subject (student_id,s1,s2,s3,s4,s5,s6,s7) values(?,?,?,?,?,?,?,?)");
            p.setInt(1, Integer.parseInt(id));
            p.setString(2, s1);
            p.setString(3, s2);
            p.setString(4, s3);
            p.setString(5, s4);
            p.setString(6, s5);
            p.setString(7, s6);
            p.setString(8, s7);
            p.execute();
            p.close();
        } catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static boolean id_subjectExisting() throws SQLException {
        Assign_studentsPanel d=new Assign_studentsPanel();
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select id  from subject");
        ResultSet r = p.executeQuery(); 
        while (r.next()) {
            if(r.getString("id").equals(d.getTextFild())){
                return true;
            }
        }
        return false;   
    }
    
}
