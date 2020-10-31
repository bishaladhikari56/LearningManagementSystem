/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;
//import Project.ConnectionProvider;
import Project1.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Bishal
 */
public class Assignment1Student extends javax.swing.JFrame {

    /**
     * Creates new form quizExamStudent*/
      public String questionId ="1";
      public String answer;
      public int min=0;
      public int sec=0;
      public int marks=0;
      public String questionNum="1";
      
      public void answerCheck()
      {
          String studentAnswer="";
          if(jRadioButton1.isSelected())
          {
              studentAnswer=jRadioButton1.getText();
          }
          else if(jRadioButton2.isSelected())
          {
              studentAnswer=jRadioButton2.getText();
          }
          else if(jRadioButton3.isSelected())
          {
              studentAnswer=jRadioButton3.getText();
          }
          else
          {
              studentAnswer=jRadioButton4.getText();
          }
          if(studentAnswer.equalsIgnoreCase(answer))
          {
              marks=marks+1;
              String marks1=String.valueOf(marks);
              txtMarks.setText(marks1);
          }
          
          //question number change
         /* int questionId1 = Integer.parseInt(questionId);
          questionId1=questionId1 +1;
          questionId=String.valueOf(questionId1);
          txtQuestionNum.setText(questionId);*/
          
          //
          int questionNum1 = Integer.parseInt(questionNum);
          questionNum1=questionNum1 +1;
          questionNum=String.valueOf(questionNum1);
          txtQuestionNum.setText(questionNum);
          
          //clear jRadioButton
          jRadioButton1.setSelected(false);
          jRadioButton2.setSelected(false);
          jRadioButton3.setSelected(false);
          jRadioButton4.setSelected(false);
          //last question hide next button
          if(questionNum.equals("10"))
          {
              btnNext.setVisible(false);
          }
      }
      public void question()
      {
          try
        {
            Connection con = ConnectionProvider.getCon();
            Statement st= con.createStatement();
            
            ResultSet rs1 = st.executeQuery("select * from assignment1 where teacherID=104 and questionNum= '"+questionNum+"'");
            while(rs1.next())
            {
                //txtQuestionNum.setText(rs1.getString(1));
                txtQuestion.setText(rs1.getString(5));
                jRadioButton1.setText(rs1.getString(6));
                jRadioButton2.setText(rs1.getString(7));
                jRadioButton3.setText(rs1.getString(8));
                jRadioButton4.setText(rs1.getString(9));
                answer=rs1.getString(10);
                
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
      }
      public void submit()
      {
          String studentID =txtStudentID.getText();
          answerCheck();
          try
          {
              Connection con = ConnectionProvider.getCon();
              Statement st=con.createStatement();
              st.executeUpdate("update grades set Ass1Marks='"+marks+"' where studentID ='"+studentID+"' and courseID='CSC 121'");
              String marks1 =String.valueOf(marks);
              
              //JOptionPane.showMessageDialog(null,marks1);
              setVisible(false);
              new SucessfullySubmitedAssignment1Page(marks1).setVisible(true);
              
          }
          catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,e);
          }
      }
     
    public Assignment1Student() {
        initComponents();
    }
    Timer time;
    public Assignment1Student(String studentID) {
        initComponents();
        
        //For Date
        
        SimpleDateFormat dFormat= new SimpleDateFormat("dd-MM-yyyy");
        Date date=new Date();
        lblDate.setText(dFormat.format(date));
        
        //first question and student details
        try
        {
            Connection con = ConnectionProvider.getCon();
            Statement st= con.createStatement();
            txtStudentID.setText(studentID);
            ResultSet rs=st.executeQuery("select * from student1 where studentID='"+studentID+"'");
            while(rs.next())
            {
                txtName.setText(rs.getString(2));
            }
            ResultSet rs1 = st.executeQuery("select * from assignment1 where teacherID=104 and questionNum= '"+questionNum+"'");
            while(rs1.next())
            {
                //txtQuestionNum.setText(rs1.getString(1));
                txtQuestion.setText(rs1.getString(5));
                jRadioButton1.setText(rs1.getString(6));
                jRadioButton2.setText(rs1.getString(7));
                jRadioButton3.setText(rs1.getString(8));
                jRadioButton4.setText(rs1.getString(9));
                answer=rs1.getString(10);
                
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //Time program
        setLocationRelativeTo(this);
        time= new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
        {
            txtSec.setText(String.valueOf(sec));
            txtMin.setText(String.valueOf(min));
            
            if(sec ==60)
            {
                sec=0;
                min++;
                if(min==10)
                {
                    time.stop();
                    answerCheck();
                    submit();
                }
            }
            sec++;
        }
            
        });
        time.start();
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSec = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMin = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMarks = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtQuestion = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        txtQuestionNum = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Welcome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Date:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 58, -1, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblDate.setText("Today's Date");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Time Taken:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 97, -1, -1));

        txtSec.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtSec.setForeground(new java.awt.Color(255, 102, 102));
        txtSec.setText("00");
        jPanel1.add(txtSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 100, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Total Time:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("10 Min");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1118, 38, -1, -1));

        txtMin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtMin.setForeground(new java.awt.Color(255, 102, 102));
        txtMin.setText("00:");
        jPanel1.add(txtMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1118, 97, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txtName.setText("StudentName");
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Total Question");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setText("10");
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Your Marks:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        txtMarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMarks.setText("00");
        jPanel1.add(txtMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        txtStudentID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtStudentID.setText("getStudentID");
        jPanel1.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("StudentID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 170));

        txtQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtQuestion.setText("Question Demo?");
        getContentPane().add(txtQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, -1, 40));

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 640, -1, 40));

        txtQuestionNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtQuestionNum.setText("01");
        getContentPane().add(txtQuestionNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 30, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1360, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int a =JOptionPane.showConfirmDialog(null,"Do you really want to submit?","select",JOptionPane.YES_NO_OPTION);
        if(a ==0)
        {
            answerCheck();
            submit();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
         answerCheck();
         question();
    }//GEN-LAST:event_btnNextActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected())
        {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected())
        {
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if(jRadioButton3.isSelected())
        {
            jRadioButton2.setSelected(false);
            jRadioButton1.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if(jRadioButton4.isSelected())
        {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton1.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Assignment1Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignment1Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignment1Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignment1Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignment1Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel txtMarks;
    private javax.swing.JLabel txtMin;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtQuestion;
    private javax.swing.JLabel txtQuestionNum;
    private javax.swing.JLabel txtSec;
    private javax.swing.JLabel txtStudentID;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
