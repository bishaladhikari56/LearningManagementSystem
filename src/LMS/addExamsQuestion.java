/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bishal
 */
public class addExamsQuestion extends javax.swing.JFrame {

    private  String courseID;
    private  String teacherID;
    public addExamsQuestion() {
        initComponents();
        lblExamsName.setText(ExamsPageTeacher.lblAssignmentName.getText());
        //addQuestions();
    }
    public void addQuestions()
    {
         try
        {
            courseID=IndividualCoursePageTeacher.lblCourseID.getText();
            teacherID=IndividualCoursePageTeacher.lblInstructorID.getText();
            Connection con = ConnectionProvider.getCon();
            
            JOptionPane.showMessageDialog(null,courseID+ ""+teacherID);
            String question=txtQuestion.getText();
            String option1=txtOption1.getText();
            String option2=txtOption2.getText();
            String option3=txtOption3.getText();
            String option4=txtOption4.getText();
            String answer=txtAnswer.getText();
            String questionNum=lblQuestionNum.getText();
            String assignmentName=lblExamsName.getText();
            String totalQuestions=ExamsPageTeacher.lblQuestionNum.getText();
            
            //String classroom=txtInstName.getText();
            
            PreparedStatement ps = con.prepareStatement("insert into exam (questionNum,courseID,teacherID,question,option1,option2,option3,option4,answer,examName,totalQuestions)values(?,?,?,?,?,?,?,?,?,?,?)");
            //ps.setString(1,teacherName);
            ps.setString(1,questionNum);
            ps.setString(2,courseID);
            ps.setString(4,question);
            ps.setString(5,option1);
            ps.setString(6,option2);
            ps.setString(7,option3);
            ps.setString(8,option4);
            ps.setString(9,answer);
            ps.setString(3,teacherID);
            ps.setString(10,assignmentName);
            ps.setString(11,totalQuestions);
            //ps.setString(5,classroom);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Sucessfully updated");
           
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblQuestionNum = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();
        txtOption3 = new javax.swing.JTextField();
        txtOption2 = new javax.swing.JTextField();
        txtOption1 = new javax.swing.JTextField();
        txtQuestion = new javax.swing.JTextField();
        txtOption4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblExamsName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Add New Question");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Question Num:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 75, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Question:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Option 1:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Option 2:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Option 3:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Option 4:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Answer:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("Save Question");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, -1, 40));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 550, -1, 40));

        lblQuestionNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblQuestionNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 75, 65, -1));

        txtAnswer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 1020, 35));

        txtOption3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtOption3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 1020, 35));

        txtOption2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtOption2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 1020, 35));

        txtOption1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOption1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtOption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 1020, 35));

        txtQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 1020, 35));

        txtOption4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtOption4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 1020, 35));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("View Questions");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, -1, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Exam Name:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        lblExamsName.setEditable(false);
        lblExamsName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblExamsName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblExamsNameActionPerformed(evt);
            }
        });
        getContentPane().add(lblExamsName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 190, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOption1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        addQuestions();
        txtQuestion.setText("");
        txtOption1.setText("");
        txtOption2.setText("");
        txtOption3.setText("");
        txtOption4.setText("");
        txtAnswer.setText("");
        lblQuestionNum.setText("");
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       
        txtQuestion.setText("");
        txtOption1.setText("");
        txtOption2.setText("");
        txtOption3.setText("");
        txtOption4.setText("");
        txtAnswer.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       // setVisible(false);
       new ViewExams().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblExamsNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblExamsNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblExamsNameActionPerformed

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
            java.util.logging.Logger.getLogger(addExamsQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addExamsQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addExamsQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addExamsQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addExamsQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lblExamsName;
    private javax.swing.JTextField lblQuestionNum;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextField txtQuestion;
    // End of variables declaration//GEN-END:variables
}