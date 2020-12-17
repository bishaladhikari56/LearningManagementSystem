/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bishal
 */
public class StartExamPage extends javax.swing.JFrame {
    private String studentID=IndividualCoursePageStudent.studentID;
    private String courseID=IndividualCoursePageStudent.courseID;
    private String teacherID=IndividualCoursePageStudent.teacherID;
    private String assignmentName=AutoGeneratedExamButtonStudent.clickedButton;
    private boolean taken=false;
    private ArrayList<String> assignmentAL= new ArrayList<String>();
    /**
     * Creates new form StartAssignment1Page
     */
    
    public StartExamPage() {
        initComponents();
        getDetails();
        lblExamName.setText(AutoGeneratedExamButtonStudent.clickedButton);
    }
    
    public void getDetails()
    {
        try
        {
            String name="";
            String uniqueID="";
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           // String qrry = "select * from logindetails where username=\"" + Registration.textUser + "\"and password=\"" + Registration.txtPassword + "\"";
           ResultSet rs;
           rs = st.executeQuery("select *from student1 where username=\"" + Registration.txtUser.getText() + "\" and password1=\"" + Registration.txtPassword.getText() +"\"");
            // ResultSet rs = st.executeQuery("select *from logindetails");
            while(rs.next())
            {
                
                name+=rs.getString(3);
                uniqueID+=rs.getString(6);
            }
            lblCourseID.setText(name);
            lblStudentID.setText(uniqueID);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblExamName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("These are the instructions for exam. You need to submit on time\nand other stuff.");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 830, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("StudentId");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("courseID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        lblCourseID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCourseID.setText("getCourseID");
        jPanel1.add(lblCourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, -1, -1));

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnStart.setText("Start Exam");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setText("Instructions For");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        lblStudentID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStudentID.setText("getStudentID");
        jPanel1.add(lblStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        lblExamName.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblExamName.setText("getExamName");
        jPanel1.add(lblExamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1360, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try
        {
            String name="";
            String uniqueID="";

            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            // String qrry = "select * from logindetails where username=\"" + Registration.textUser + "\"and password=\"" + Registration.txtPassword + "\"";
            ResultSet rs;
            rs = st.executeQuery("select *from student1 where username=\"" + Registration.txtUser.getText() + "\" and password1=\"" + Registration.txtPassword.getText() +"\"");
            // ResultSet rs = st.executeQuery("select *from logindetails");
            while(rs.next())
            {
                name+=rs.getString(3);
                uniqueID+=rs.getString(6);
            }
            //JOptionPane.showMessageDialog(null, uniqueID);
            lblCourseID.setText(name);
            lblStudentID.setText(uniqueID);
            checkTakenAssignment();
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnStartActionPerformed

     public void checkTakenAssignment()
    {
        try
        {
            String assnName;
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           // String qrry = "select * from logindetails where username=\"" + Registration.textUser + "\"and password=\"" + Registration.txtPassword + "\"";
           ResultSet rs;
           rs = st.executeQuery("select * from grades1 where studentID=\"" + studentID + "\" and courseID=\"" + courseID +"\" and teacherID=\"" + teacherID +"\" and assignmentName=\"" + assignmentName +"\" ");
            // ResultSet rs = st.executeQuery("select *from logindetails");
            while(rs.next())
            {
                assnName=rs.getString(6);
                assignmentAL.add(assnName);
            }
            if(assignmentAL.size()==0)
            {
               setVisible(false);
                new ExamStudent(studentID).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You have already Taken this Exam!!" );
                setVisible(false);
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in "+ex );
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
            java.util.logging.Logger.getLogger(StartExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartExamPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblExamName;
    private javax.swing.JLabel lblStudentID;
    // End of variables declaration//GEN-END:variables
}