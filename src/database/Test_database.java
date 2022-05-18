/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static Lecturer_Frames.Test.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author pc
 */
public class Test_database {

    public Test_database() {

    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public void ShowQuestion(JLabel Label1, JLabel jLabel2, JRadioButton Select_1, JRadioButton Select_2, JRadioButton Select_3, JRadioButton Select_4) {
        try {
            connection = connect();
            String query = "select * from Question";
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Label1.setText(resultSet.getString("id"));
                jLabel2.setText(resultSet.getString("question"));
                Select_1.setText(resultSet.getString(3));
                Select_2.setText(resultSet.getString(4));
                Select_3.setText(resultSet.getString(5));
                Select_4.setText(resultSet.getString(6));
                correctAnswer = resultSet.getString(7);

                // for one row only
                break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void NullAllGivenAnswers() {
        // here we have to call this method
        try {
            String query = "UPDATE Question SET Student_answer = ?";
            prepared_statement = connection.prepareStatement(query);
            prepared_statement.setString(1, null);
            prepared_statement.execute();
            prepared_statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error 56", JOptionPane.ERROR_MESSAGE);

        }

    }

    Connection connection;//con
    PreparedStatement prepared_statement, cs;//pst
    ResultSet resultSet;//rs
    String correctAnswer = null;
    String answer = null;
    Statement statement;
    int answercheck = 0;
    int marks = 0;
    public void updateFunction(String answerAnswer,JLabel jLabel2){
        try {
                    String query = "UPDATE Question SET Student_answer = ? WHERE question = ?";
                    prepared_statement = connection.prepareStatement(query);
                    prepared_statement.setString(1, answerAnswer);
                    prepared_statement.setString(2, jLabel2.getText());
                    prepared_statement.execute();
                    prepared_statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error 78", JOptionPane.ERROR_MESSAGE);
                }
    }
    public void LoadQuestion2(JLabel Label_1, JLabel jLabel_2, JRadioButton Select_1, JRadioButton Select_2, JRadioButton Select_3, JRadioButton Select_4) {
        String query = "select * from Question";
        Statement stat = null;
        try {
            stat = connection.createStatement();
            resultSet = stat.executeQuery(query);
            while (resultSet.next()) {
                Label_1.setText(resultSet.getString(1));
                jLabel_2.setText(resultSet.getString(2));
                Select_1.setText(resultSet.getString(3));
                Select_2.setText(resultSet.getString(4));
                Select_3.setText(resultSet.getString(5));
                Select_4.setText(resultSet.getString(6));
                correctAnswer = resultSet.getString(7);
                break;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error 90", JOptionPane.ERROR_MESSAGE);
        }

    }
}
