/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vbnfv
 */
public class subject_lecturer_database {
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_subject(String id, String s1, String s2, String s3) throws SQLException {
        try {
            Connection con = connect();
            try (PreparedStatement p = con.prepareStatement("insert into subject_lecturer (lecturer_id,s1,s2,s3) values(?,?,?,?)")) {
                p.setInt(1, Integer.parseInt(id));
                p.setString(2, s1);
                p.setString(3, s2);
                p.setString(4, s3);
                p.execute();
                p.close();
            }
        } catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage(), "Error8", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
