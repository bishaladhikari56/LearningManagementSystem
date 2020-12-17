/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import javax.swing.*;

/**
 *
 * @author Bishal
 */
public class TeacherHomePage extends javax.swing.JFrame {

    /**
     * Creates new form CanvasHomePage
     */
    public TeacherHomePage() {
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

        jPanel1 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblCanvas = new javax.swing.JLabel();
        btnprofile = new javax.swing.JButton();
        btnCourses = new javax.swing.JButton();
        btnGrades = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        btnAddCourses = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setBackground(new java.awt.Color(153, 153, 255));
        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblWelcome.setText("Welcome to Blackboard Homepage");
        jPanel1.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 11, -1, -1));

        lblCanvas.setBackground(new java.awt.Color(153, 153, 255));
        lblCanvas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCanvas.setText("Teacher's Page");
        jPanel1.add(lblCanvas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 40));

        btnprofile.setBackground(new java.awt.Color(153, 153, 255));
        btnprofile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnprofile.setText("Profile");
        btnprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprofileActionPerformed(evt);
            }
        });
        jPanel1.add(btnprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 86, 200, 60));

        btnCourses.setBackground(new java.awt.Color(153, 153, 255));
        btnCourses.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCourses.setText("Courses");
        btnCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoursesActionPerformed(evt);
            }
        });
        jPanel1.add(btnCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 200, 60));

        btnGrades.setBackground(new java.awt.Color(153, 153, 255));
        btnGrades.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGrades.setText("Grades");
        btnGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradesActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrades, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 210, 60));

        btnMessage.setBackground(new java.awt.Color(153, 153, 255));
        btnMessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMessage.setText("Calander");
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });
        jPanel1.add(btnMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 210, 70));

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Message");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 210, 60));

        btnSignOut.setBackground(new java.awt.Color(153, 153, 255));
        btnSignOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/logout.png"))); // NOI18N
        btnSignOut.setText("Sign Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 210, -1));

        btnAddCourses.setBackground(new java.awt.Color(153, 153, 255));
        btnAddCourses.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAddCourses.setText("Add Courses");
        btnAddCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCoursesActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 210, 60));

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprofileActionPerformed
        // TODO add your handling code here:

        new ProfilePageTeacher().setVisible(true);
    }//GEN-LAST:event_btnprofileActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Log Out", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new Registration().setVisible(true);
        }
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCoursesActionPerformed
        new AddCoursesTeacher().setVisible(true);
    }//GEN-LAST:event_btnAddCoursesActionPerformed

    private void btnCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoursesActionPerformed
       new AutoGeneratedCourseButtonTeacher();
    }//GEN-LAST:event_btnCoursesActionPerformed

    private void btnGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGradesActionPerformed
        
        new AddGradesPage().setVisible(true);
    }//GEN-LAST:event_btnGradesActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new EmailSendingApplication().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
        new CalanderPage().setVisible(true);
    }//GEN-LAST:event_btnMessageActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new TeacherHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourses;
    private javax.swing.JButton btnCourses;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGrades;
    private javax.swing.JButton btnMessage;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnprofile;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCanvas;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
