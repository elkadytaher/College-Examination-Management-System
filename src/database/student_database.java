/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

//import static database.user_database.connect;
import domain.students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vbnfv
 */
public class student_database {
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }
     public static void insert_student(String fname,String lname,String email,String password,String age) throws SQLException
     {
        try{
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("insert into student(fname,lname,email,password,age) values(?,?,?,?,?)");
        p.setString(1, fname);
        p.setString(2, lname);
        p.setString(3, email);
        p.setString(4, password);
        p.setInt(5,Integer.parseInt(age));
        p.execute();
        p.close();
        }catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
     }
     public static ArrayList<students> get_student(){
        ArrayList<students> List=new ArrayList<>();
        try{
            Connection con=connect();
            PreparedStatement p=con.prepareStatement("select *  from student");
            ResultSet r=p.executeQuery();
            while(r.next()){
                List.add(new students(r.getInt("id"),r.getString("fname"),r.getString("lname"),r.getString("email"),r.getString("password"),r.getInt("age")));
            }
           p.close();
           r.close();
        }catch (SQLException ee){
            System.out.println(ee.getMessage());
        }
        return List;
    }
     
     
//     ArrayList<students> arre=student_database.get_student();
//     private int getStudentIndex(int id) {
//        for (int i = 0; i < arre.size(); i++) {
//            if (arre.get(i).getId() == id) {
//                return i;
//            }
//        }
//        return -1;
//    }
//     public String searchStudent(int id) {
//        int index = getStudentIndex(id);
//        if (index != -1) {
//            return "\nFound ...!" + arre.get(index).toString();
//        } else {
//            return "\nNot Found ...!";
//        }
//    }
   
}

