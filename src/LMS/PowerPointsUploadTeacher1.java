/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

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
public class PowerPointsUploadTeacher1 extends javax.swing.JFrame {

    /**
     * Creates new form SyallabusUploadTeacher
     */
   // private String uniqueID=IndividualCoursePageTeacher.teacherID;
    private String teacherID=IndividualCoursePageTeacher.teacherID;
    private String courseID=IndividualCoursePageTeacher.courseID;
    String fileIMG = null;
    byte[] img = null;
    String fileTXT = null;
    byte[] txt = null;
    public PowerPointsUploadTeacher1() {
        initComponents();
        show_upload();
    }
    
    
    public ArrayList<Upload> UploadList() {
        ArrayList<Upload> uploadList = new ArrayList<>();
        try {
            Class.forName("java.sql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/learningmanagementsystem", "root", "toor");
            String qrry = "select * from powerpoints where courseID='"+courseID+"' and teacherID='"+teacherID+"'";
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(qrry);
            /*stmnt.executeUpdate(qrry);
            stmnt.close();
            conn.close();
             */
            Upload upload;
            while (rs.next()) {
                upload = new Upload(rs.getInt("id"), rs.getString("courseID"), rs.getString("teacherID"), rs.getString("assignmentName"), rs.getBytes("Image"), rs.getBytes("TxtFile"));
                uploadList.add(upload);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return uploadList;
    }

    public void show_upload() {
        ArrayList<Upload> list = UploadList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            /*
            row[2] = list.get(i).getAssignmentName(); 
            row[0] = list.get(i).getCourseID();
            row[1] = list.get(i).getCourseName();
             */
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getCourseID();
            row[2] = list.get(i).getTeacherID();
            row[3] = list.get(i).getAssignmentName();
            model.addRow(row);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldSyllabus = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        lblFileName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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
        btnChooseFile.setText("Chose a text file for powerpoints");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnChooseFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 68, -1, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Course ID", "Teacher ID", "Upload Name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, 423, -1));

        fieldSyllabus.setColumns(20);
        fieldSyllabus.setRows(5);
        jScrollPane2.setViewportView(fieldSyllabus);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 135, 811, 569));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 531, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 531, -1, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 531, -1, -1));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 531, -1, -1));

        image.setText("i");
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 626, 17, -1));

        lblFileName.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblFileName.setText("FileName");
        getContentPane().add(lblFileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 74, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("getCourseName");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

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
            PreparedStatement pst = conn.prepareStatement(qrry);
            pst.setString(1, lblFileName.getText());
            pst.setString(2, courseID);
            pst.setString(3, teacherID);
            pst.setBytes(4, img);
            pst.setBytes(5, txt);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            show_upload();
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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("java.sql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/learningmanagementsystem", "root", "toor");
            int row = jTable1.getSelectedRow();
            String value = (jTable1.getModel().getValueAt(row, 0).toString());
            String qrry = "update powerpoints set assignmentName=?, courseID=?, teacherID=?, Image=?, TxtFile=? where id="+value;
            PreparedStatement pst = conn.prepareStatement(qrry);
            pst.setString(1, lblFileName.getText());
            pst.setString(2, courseID);
            pst.setString(3, teacherID);
            pst.setBytes(4, img);
            pst.setBytes(5, txt);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            show_upload();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("java.sql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/learningmanagementsystem", "root", "toor");
            int row = jTable1.getSelectedRow();
            String value = (jTable1.getModel().getValueAt(row, 0).toString());
            String qrry = "delete from powerpoints where id=" + value;
            PreparedStatement pst = conn.prepareStatement(qrry);
            //pst.setString(1, txtAssign.getText());
            pst.executeUpdate();
            //pst.execute();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            show_upload();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        //txtCourseID.setText("");
      //  txtTeacherID.setText("");
        lblFileName.setText("");
        image.setIcon(null);
        fieldSyllabus.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        fileTXT = f.getAbsolutePath();
        //String s = new String(fileTXT);
        //showTxt.setText(s);
        lblFileName.setText(f.getName());
       fieldSyllabus.setText(fileTXT);
        try {
            FileReader reader = new FileReader(fileTXT);
            BufferedReader br = new BufferedReader(reader);
            fieldSyllabus.read(br, null);
            File fTXT = new File(fileTXT);
            FileInputStream fis = new FileInputStream(fTXT);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            txt = bos.toByteArray();
            br.close();
            fieldSyllabus.requestFocus();
            //txt = bFile; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnChooseFileActionPerformed

     private void btnIMGActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        fileIMG = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileIMG).getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
        image.setIcon(imageIcon);
        try {
            File fIMG = new File(fileIMG);
            FileInputStream fis = new FileInputStream(fIMG);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            img = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }                                      

    private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, "Nothing");
    }                                                                                                                    

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                                   
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        //txtCourseID.setText(model.getValueAt(i, 1).toString());
        //txtTeacherID.setText(model.getValueAt(i, 2).toString());
        lblFileName.setText(model.getValueAt(i, 3).toString());

        byte[] Pic = (UploadList().get(i).getPic());
        
        if(Pic != null){
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(Pic).getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
            image.setIcon(imageIcon);
        }
        else{
            image.setIcon(null);
        }
        
        byte[] Txt = (UploadList().get(i).getTxt());
        if(Txt != null){
            String s = new String(Txt);
            fieldSyllabus.setText(s);
        }
        else{
            fieldSyllabus.setText("");
        }
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
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PowerPointsUploadTeacher1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PowerPointsUploadTeacher1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextArea fieldSyllabus;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFileName;
    // End of variables declaration//GEN-END:variables
}
