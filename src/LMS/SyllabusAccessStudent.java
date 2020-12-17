/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import Project1.ConnectionProvider;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Bishal
 */
public class SyllabusAccessStudent extends javax.swing.JFrame {
    private String teacherID=IndividualCoursePageStudent.teacherID;
    private String courseID=IndividualCoursePageStudent.courseID;
    private String studentID=IndividualCoursePageStudent.studentID;
    String fileIMG = null;
    byte[] img = null;
    String fileTXT = null;
    byte[] txt = null;
    public SyllabusAccessStudent() {
        initComponents();
       accessSyllabusFromTable();
       lblCourseName.setText(courseID);
    }
  
        public void accessSyllabusFromTable()
        {
            try
            {
                //String studentId= studentIDAL.get(0);
                //int id=Integer.parseInt(studentId);
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select syllabus.TxtFile from syllabus where teacherID =\"" + teacherID+ "\" and courseID=\""+courseID+"\"");
                while(rs.next())
                {
                    fieldPowerPoints.setText(rs.getString(1));
                }
                //JOptionPane.showMessageDialog(null, studentId);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldPowerPoints = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Syllabus of:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        image.setText("i");
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 626, 17, -1));

        lblCourseName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCourseName.setText("GetCourseName");
        getContentPane().add(lblCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        fieldPowerPoints.setColumns(20);
        fieldPowerPoints.setRows(5);
        jScrollPane1.setViewportView(fieldPowerPoints);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 1070, 570));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

   
   private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, "Nothing");
    }                                                                                                                    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SyllabusAccessStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SyllabusAccessStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SyllabusAccessStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SyllabusAccessStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SyllabusAccessStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea fieldPowerPoints;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCourseName;
    // End of variables declaration//GEN-END:variables
}
