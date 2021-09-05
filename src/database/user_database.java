/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vbnfv
 */
public class user_database {
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }
    public static void insert_user(String user,String password,String usertype) throws SQLException{
        try{
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("insert into users values(?,?,?)");
        p.setString(1, user);
        p.setString(2, password);
        p.setString(3, usertype);
        p.execute();}catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, "Error in Insert", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static ArrayList<users> get_user(){
        ArrayList<users> List=new ArrayList<>();
        try{
            Connection con=connect();
            PreparedStatement p=con.prepareStatement("select *  from users");
            ResultSet r=p.executeQuery();
            while(r.next()){
                List.add(new users(r.getString("user"),r.getString("password"),r.getString("userType")));
            }
            
        }catch (SQLException ee){
            System.out.println(ee.getMessage());
        }
        return List;
    }
    public static int check_user(String user,String password,String usertype)
    {
        ArrayList<users> arr=get_user();
        int x=0;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getUser_name().equals(user))
            {
                if(arr.get(i).getPassword().equals(password))
                { 
                   if(arr.get(i).getUsertype().equalsIgnoreCase(usertype))
                    { 
                        x=1;//username correct,password correct,usertype correct
                        break;
                    }
                   else
                   {
                       x=3;//username correct,password correct,usertype Wonge
                       break;
                   }
                }
                else
                {
                    x=2;//username correct,password Wonge
                    break;
                }
            
            }
            else
            {
                x=0;
            }
            
        }
        return x;
        
    }
}
