/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Frames.Panels.Lecturer_AddPanel;
import Frames.Panels.Lecturer_ListPanel;
import Frames.Panels.Lecturer_UpdatePanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author vbnfv
 */
public class Admin_LecturerFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form Admin_LecturerFrame
     */
    Lecturer_AddPanel p1;
    Lecturer_ListPanel p2;
    Lecturer_UpdatePanel p3;
    GridBagLayout layout=new GridBagLayout();
    public Admin_LecturerFrame() {
        initComponents();
        p1=new Lecturer_AddPanel();
        p2=new Lecturer_ListPanel();
        p3=new Lecturer_UpdatePanel();
        DynamicPanalLecturer.setLayout(layout);
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        DynamicPanalLecturer.add(p1,c);
        DynamicPanalLecturer.add(p2,c);
        DynamicPanalLecturer.add(p3,c);
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DynamicPanalLecturer = new javax.swing.JPanel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(8, 51, 70));

        jButton1.setBackground(new java.awt.Color(4, 108, 149));
        jButton1.setForeground(new java.awt.Color(179, 224, 238));
        jButton1.setText("Add Lecturer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(4, 108, 149));
        jButton2.setForeground(new java.awt.Color(179, 224, 238));
        jButton2.setText("List Lecturer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton2KeyReleased(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(4, 108, 149));
        jButton3.setForeground(new java.awt.Color(179, 224, 238));
        jButton3.setText("Update Lecturer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton1)
                .addGap(100, 100, 100)
                .addComponent(jButton2)
                .addGap(100, 100, 100)
                .addComponent(jButton3)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        DynamicPanalLecturer.setBackground(new java.awt.Color(72, 181, 214));

        javax.swing.GroupLayout DynamicPanalLecturerLayout = new javax.swing.GroupLayout(DynamicPanalLecturer);
        DynamicPanalLecturer.setLayout(DynamicPanalLecturerLayout);
        DynamicPanalLecturerLayout.setHorizontalGroup(
            DynamicPanalLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
        );
        DynamicPanalLecturerLayout.setVerticalGroup(
            DynamicPanalLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        getContentPane().add(DynamicPanalLecturer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        p2.setVisible(true);
        p1.setVisible(false);
        p3.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        p3.setVisible(true);
        p1.setVisible(false);
        p2.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here: 
       
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicPanalLecturer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
