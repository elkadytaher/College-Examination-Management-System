/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;

/**
 *
 * @author pc
 */
public class update_test {
    public void updateFunction(String answerAnswer,JLabel jLabel2){
        try {
                    String query = "UPDATE Question SET Student_answer = ? WHERE question = ?";
                    prepared_statement = connection.prepareStatement(query);
                    prepared_statement.setString(1, answerAnswer);
                    prepared_statement.setString(2, jLabel2.getText());
                    prepared_statement.execute();
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }
    }
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }
    Connection connection;
    PreparedStatement prepared_statement, cs;
}
