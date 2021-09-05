/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.student_database.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vbnfv
 */
public class lecturer_database {
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }
    public static void insert_lecturer(String fname,String lname,String email,String password) throws SQLException
     {
        try{
        Connection con=connect();
            try (PreparedStatement p = con.prepareStatement("insert into Lecturer(fname,lname,email,password) values(?,?,?,?)")) {
                p.setString(1, fname);
                p.setString(2, lname);
                p.setString(3, email);
                p.setString(4, password);
                p.execute();
            }
        }catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
     }
}
