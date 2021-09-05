/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



/**
 *
 * @author vbnfv
 */
public class students {
    private int id;
    private String fname,lname,email,password;
    private int age;

    public students(int id, String fname, String lname, String email, String password, int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    public static Connection connect() throws SQLException{
//        return DriverManager.getConnection("jdbc:sqlite:uni.db");
//    }
//    public static ArrayList<students> get_student(){
//        ArrayList<students> List=new ArrayList<>();
//        try{
//            Connection con=connect();
//            PreparedStatement p=con.prepareStatement("select *  from student");
//            ResultSet r=p.executeQuery();
//            while(r.next()){
//                List.add(new students(r.getInt("id"),r.getString("fname"),r.getString("lname"),r.getString("email"),r.getString("password"),r.getInt("age")));
//            }
//            
//        }catch (SQLException ee){
//            System.out.println(ee.getMessage());
//        }
//        return List;
//    }
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
