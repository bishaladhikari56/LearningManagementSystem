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
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
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
public class PowerPointsUploadTeacher22 extends javax.swing.JFrame {

    /**
     * Creates new form SyallabusUploadTeacher
     */
   // private String uniqueID=IndividualCoursePageTeacher.teacherID;
    private String teacherID=IndividualCoursePageTeacher.teacherID;
    private String courseID=IndividualCoursePageTeacher.courseID;
    private String assignmentname;
    private String txtFile;
    private static DataInputStream dis;
   
    public PowerPointsUploadTeacher22() {
        initComponents();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnChooseFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldSyllabus = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        lblFileName1 = new javax.swing.JLabel();
        lblFileName = new javax.swing.JTextField();
        btnOpen = new javax.swing.JButton();
        viewPPts = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PowerPoints of");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 21, -1, -1));

        btnChooseFile.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnChooseFile.setText("Choose File");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnChooseFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 68, -1, -1));

        fieldSyllabus.setColumns(20);
        fieldSyllabus.setRows(5);
        jScrollPane2.setViewportView(fieldSyllabus);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 120, 970, 380));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("Save File");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, -1, -1));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 530, -1, -1));

        image.setText("i");
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 626, 17, -1));

        lblFileName1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblFileName1.setText("File Name:");
        getContentPane().add(lblFileName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, -1, -1));
        getContentPane().add(lblFileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 250, 40));

        btnOpen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnOpen.setText("OpenFile");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, -1));

        viewPPts.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewPPts.setText("View All PowerPoints");
        viewPPts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPPtsActionPerformed(evt);
            }
        });
        getContentPane().add(viewPPts, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("java.sql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/learningmanagementsystem", "root", "toor");
            String qrry = "insert into powerpoints(assignmentName, courseID, teacherID, Image, TxtFile)VALUES(?,?,?,?,?)";
            
            //InputStream inputStream= new FileInputStream(new File(txtFile));
            PreparedStatement pst = conn.prepareStatement(qrry);
            pst.setString(1, lblFileName.getText());
            pst.setString(2, courseID);
            pst.setString(3, teacherID);
            pst.setString(4, null);
            pst.setString(5, txtFile);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success");

            /*
            Statement stmnt = conn.createStatement();        
            ResultSet rs = stmnt.executeQuery(qrry);
            stmnt.executeUpdate(qrry);
            stmnt.close();
            conn.close();
             */
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        //txtCourseID.setText("");
      //  txtTeacherID.setText("");
        lblFileName1.setText("");
        image.setIcon(null);
        fieldSyllabus.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        txtFile = f.getAbsolutePath();
        //String s = new String(fileTXT);
        //showTxt.setText(s);
        lblFileName.setText(f.getName());
       //fieldSyllabus.setText(fileTXT);
        
    }//GEN-LAST:event_btnChooseFileActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        // TODO add your handling code here:
        try
        {
            //String studentId= studentIDAL.get(0);
            //int id=Integer.parseInt(studentId);
            String file="";
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            
         //   SELECT txtfile FROM learningmanagementsystem.powerpoints;
            ResultSet rs = st.executeQuery("select powerpoints.txtfile from powerpoints where teacherID =\"" + teacherID+ "\" and courseID=\""+courseID+"\""
                    + " and assignmentName =\"" + lblFileName.getText()+ "\"");
            while(rs.next())
            {
                file=rs.getString(1);
            }
            //JOptionPane.showMessageDialog(null, studentId);
          //  InputStream inputStream= new FileInputStream(new File(file));
          //File file1= new File("file");
              Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file +"");
              //file1.close();
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
   
    }//GEN-LAST:event_btnOpenActionPerformed

    private void viewPPtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPPtsActionPerformed
        // TODO add your handling code here:
      setVisible(false);
       new  AutoGeneratedLectureNotesTeacher();
    }//GEN-LAST:event_viewPPtsActionPerformed
                       

    private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, "Nothing");
    }                                                                                                                    

            
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PowerPointsUploadTeacher22().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextArea fieldSyllabus;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblFileName;
    private javax.swing.JLabel lblFileName1;
    private javax.swing.JButton viewPPts;
    // End of variables declaration//GEN-END:variables
}