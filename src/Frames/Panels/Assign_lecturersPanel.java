/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import static database.student_database.connect;
import static java.lang.Integer.parseInt;
//import static database.subject_lecturer_database.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vbnfv
 */
public class Assign_lecturersPanel extends javax.swing.JPanel {

    /**
     * Creates new form Assign_lecturersPanel
     */
    public Assign_lecturersPanel() {
        initComponents();
    }

    protected static int searchAssign_lecture(String id) {
        int n = 0;

        Connection con;
        try {
            con = connect();
            String sql = "select lecturer_id  from subject_lecturer ";
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            boolean U = true;
            while (r.next() && U) {
                if (r.getString("lecturer_id").equals(id)) {
                    n = 0;
                    U = false;
                    //breack;
                } else {
                    n = 1;
                }
                p.close();
                r.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error8", JOptionPane.ERROR_MESSAGE);
        }

        return n;
    }

    protected void UpdateAssign_lecture() {
        try {
            String id = idTextField.getText();
            //String Name =NameTextField.getText();
            String Subject1 = (String) jComboBox1.getSelectedItem();
            String Subject2 = (String) jComboBox2.getSelectedItem();
            String Subject3 = (String) jComboBox3.getSelectedItem();
            Connection con = connect();
            String sql = "update subject_lecturer set s1='" + Subject1 + "',s2='" + Subject2 + "',s3='" + Subject3 + "' where lecturer_id='" + id + "' ";
            PreparedStatement p = con.prepareStatement(sql);
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem in UpdateAssign_lecture", "Error5", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void resetPanalDeta() {
        idTextField.setText("");
        NameTextField.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);

    }

    public int UnacceptableRepetition() {

        Object database[] = new Object[]{(String) jComboBox1.getSelectedItem(),
            (String) jComboBox2.getSelectedItem(),
            (String) jComboBox3.getSelectedItem()};
        int x = 1;
        for (int j = 0; j < database.length - 1; j++) {
            for (int i = j; i < database.length - 1; i++) {
                if (database[j].equals(database[i + 1])) {
                    x = 0;
                    break;
                }
            }
        }

        return x;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(116, 198, 157));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 28, 21));
        jLabel1.setText("Subject 1");

        jComboBox1.setBackground(new java.awt.Color(8, 28, 21));
        jComboBox1.setForeground(new java.awt.Color(216, 243, 220));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PL2", "DS", "DB1", "LD", "NULL" }));

        jComboBox2.setBackground(new java.awt.Color(8, 28, 21));
        jComboBox2.setForeground(new java.awt.Color(216, 243, 220));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PL2", "DS", "DB1", "LD", "NULL" }));

        jComboBox3.setBackground(new java.awt.Color(8, 28, 21));
        jComboBox3.setForeground(new java.awt.Color(216, 243, 220));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PL2", "DS", "DB1", "LD", "NULL" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(8, 28, 21));
        jLabel2.setText("Subject 2");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(8, 28, 21));
        jLabel3.setText("Subject 3");

        idTextField.setBackground(new java.awt.Color(27, 67, 50));
        idTextField.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        idTextField.setForeground(new java.awt.Color(216, 243, 220));

        jButton1.setBackground(new java.awt.Color(8, 28, 21));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(216, 243, 220));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(8, 28, 21));
        jLabel4.setText("Name");

        NameTextField.setEditable(false);
        NameTextField.setBackground(new java.awt.Color(27, 67, 50));
        NameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NameTextField.setForeground(new java.awt.Color(216, 243, 220));

        jButton2.setBackground(new java.awt.Color(8, 28, 21));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(216, 243, 220));
        jButton2.setText("Assigned");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NameTextField)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameTextField)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents
    /*public void SetComboBox(){
        try {
            // TODO add your handling code here:
            Connection con = connect();
            String sql = "select *  from subject_lecturer where lecturer_id=?";
            ResultSet r;
            try ( PreparedStatement p = con.prepareStatement(sql)) {
                p.setString(1, idTextField.getText());
                r = p.executeQuery();
                if (r.next()) {
                    if (r.toString().equals("PL2")) {
                        
                    }
                    jComboBox1.setSelectedIndex(parseInt(r.getString("s1")));
                    jComboBox2.setSelectedIndex(parseInt(r.getString("s2")));
                    jComboBox3.setSelectedIndex(parseInt(r.getString("s3")));  
                }
                p.close();
            }
            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error2", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Connection con = connect();
            String sql = "select *  from Lecturer where id=?";
            ResultSet r;
            try ( PreparedStatement p = con.prepareStatement(sql)) {
                p.setString(1, idTextField.getText());
                r = p.executeQuery();
                if (r.next()) {

                    NameTextField.setText(r.getString("fname"));
                    
                } //            else if(!searchTextField.getText().equals("")){
                //                
                //            }
                else {
                    JOptionPane.showMessageDialog(null, "ID not found in table", "Error", JOptionPane.ERROR_MESSAGE);
                }
                p.close();
            }
            r.close();
            //SetComboBox();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error2", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public int search_Assigned_lecturer() {
        int H = 0;
        try {
            // TODO add your handling code here:
            Connection con = connect();
            String sql = "select *  from subject_lecturer";
            ResultSet r;
            try ( PreparedStatement p = con.prepareStatement(sql)) {
                //p.setString(1, jTextField1.getText());
                r = p.executeQuery();
                while (r.next()) {
                    if (idTextField.getText().equals(r.getString("lecturer_id"))) {
                        H = 1;
                        break;
                    } else {
                        H = 0;
                    }

                }
//            else if(!searchTextField.getText().equals("")){
//                
//            }
            }

            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return H;
    }
        public void update_Assigned_lecturer(){
        try {
            // TODO add your handling code here:
            String lecturer_id=idTextField.getText();
            String s1=(String) jComboBox1.getSelectedItem();
            String s2=(String) jComboBox2.getSelectedItem();
            String s3=(String) jComboBox3.getSelectedItem(); 
            Connection con=connect();
            String sql="update subject_lecturer set s1='"+s1+"',s2='"+s2+"',s3='"+s3+"' where lecturer_id='"+lecturer_id+"' ";
            PreparedStatement p=con.prepareStatement(sql);
            p.execute();
            /*Lecturer_ListPanel o=new Lecturer_ListPanel();
            DefaultTableModel model=(DefaultTableModel)o.gettable().getModel();
            model.setRowCount(0);*/
            
                JOptionPane.showMessageDialog(null,"Update successfully");
            p.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (search_Assigned_lecturer() == 1) {
            if (UnacceptableRepetition() == 1) {
                update_Assigned_lecturer();
                resetPanalDeta();
            } else {
                JOptionPane.showMessageDialog(null, "The student cannot be assigned to the same course more than once", "Unacceptable repetition", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            switch (UnacceptableRepetition()) {
                case 0:
                    JOptionPane.showMessageDialog(null, "The Lecturer cannot be assigned to the same course more than once", "Unacceptable repetition", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                        try {
                            // TODO add your handling code here:
                            database.subject_lecturer_database.insert_subject(idTextField.getText(),
                                    (String) jComboBox1.getSelectedItem(),
                                    (String) jComboBox2.getSelectedItem(),
                                    (String) jComboBox3.getSelectedItem());
                            resetPanalDeta();
                            JOptionPane.showMessageDialog(null, "Update successfully");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error3", JOptionPane.ERROR_MESSAGE);
                        }break;

                default:
                    JOptionPane.showMessageDialog(null, " Error in Case 0or1 Line 213  ", "Unacceptable repetition", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
