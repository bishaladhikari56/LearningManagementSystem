/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import static LMS.AddCourses.txtStudentID;
import static LMS.ProfilePage.name;
import static LMS.ProfilePage.studentID;
import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bishal
 */

public class IndividualCoursePageTeacher extends javax.swing.JFrame {

    /**
     * Creates new form IndividualCoursePageStudent
     */
    public static String teacherID;
    public static String courseID;
    public static String courseName=AutoGeneratedCourseButton.clickedButton;
    public static String teacherName;
    public IndividualCoursePageTeacher() {
        initComponents();
        lblCourseName.setText(AutoGeneratedCourseButtonTeacher.clickedButton);
        setCourseName();
        getDetails();
        lblInstructorID.setText(teacherID);
        courseID=lblCourseID.getText();
        //accessTeacherID();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void accessTeacherID()
    {
        try
        {
            
            //String name="";
            String uniqueID="";
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           ResultSet rs;
           rs = st.executeQuery("select courses.teacherID from courses where studentID=\"" + studentID + "\" and courseID=\"" +courseID +"\"");
            while(rs.next())
            {
                //name+=rs.getString(1);
                teacherID=rs.getString(1);
            }
            lblInstructorID.setText(teacherID);
            JOptionPane.showMessageDialog(null,courseID);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
     public void getDetails()
    {
        try
        {
            
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           ResultSet rs;
           rs = st.executeQuery("select *from teacher where username=\"" + Registration.txtUser.getText() + "\" and password1=\"" + Registration.txtPassword.getText() +"\"");
            
            while(rs.next())
            {
                teacherName=rs.getString(3);
                teacherID=rs.getString(6);
            }
            lblStudentName.setText(teacherName);
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void setCourseName()
    {
        if(lblCourseName.getText().equalsIgnoreCase("Java 1"))
        {
            lblCourseID.setText("CSC 121");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Java II"))
        {
            lblCourseID.setText("CSC 123");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Software Development"))
        {
            lblCourseID.setText("CSC 300");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Discrete Structure"))
        {
            lblCourseID.setText("CSC 281");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Compiler Construction"))
        {
            lblCourseID.setText("CSC 471");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Software Engineering"))
        {
            lblCourseID.setText("CSC 481");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Data Structure"))
        {
            lblCourseID.setText("CSC 311");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Computer Organization"))
        {
            lblCourseID.setText("CSC 331");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Operating System"))
        {
            lblCourseID.setText("CSC 341");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Analysis of Algorithm"))
        {
            lblCourseID.setText("CSC 401");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Data Base Management System"))
        {
            lblCourseID.setText("CSC 453");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Dynamic Web Programming"))
        {
            lblCourseID.setText("CSC 255");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Computer Graphics"))
        {
            lblCourseID.setText("CSC 461");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Senior Design"))
        {
            lblCourseID.setText("CSC 492");
        }
        else if(lblCourseName.getText().equalsIgnoreCase("Assembly Language"))
        {
            lblCourseID.setText("CSC 321");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblInstructorID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblStudentName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Contents");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 179, 244, 61));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Announcements");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 277, 244, 59));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("Groups");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 391, 244, 59));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText("Discussions");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 492, 244, 66));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Course Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        lblCourseName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCourseName.setText("GetCourseName");
        getContentPane().add(lblCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Course ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        lblCourseID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCourseID.setText("GetCourseID");
        getContentPane().add(lblCourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Instructor ID: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, -1, -1));

        lblInstructorID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInstructorID.setText("GetInstructorID");
        getContentPane().add(lblInstructorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Welcome  ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        lblStudentName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStudentName.setText("getStudentName");
        getContentPane().add(lblStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Individual Course page Teacher");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new courseContentPageTeacher().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //setVisible(false);
        new AnnouncementTeacher().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(IndividualCoursePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndividualCoursePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndividualCoursePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndividualCoursePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndividualCoursePageTeacher().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblCourseName;
    public static javax.swing.JLabel lblInstructorID;
    private javax.swing.JLabel lblStudentName;
    // End of variables declaration//GEN-END:variables
}
