/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bishal
 */
public class AnnouncementUpdateTeacher extends javax.swing.JFrame {

    /**
     * Creates new form AnnouncementStudent
     */
    public AnnouncementUpdateTeacher() {
        initComponents();
        lblName.setText(AutoGeneratedAnnouncementTeacher.clickedButton);
        lblCourseID.setText(IndividualCoursePageTeacher.courseID);
        accessAnnouncement();
    }
    public void accessAnnouncement()
    {
         try
        {
            //String studentId= studentIDAL.get(0);
            //int id=Integer.parseInt(studentId);
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select txtAnnouncement from anouncement where teacherID =\"" + IndividualCoursePageTeacher.teacherID+
                    "\" and announcementName='"+AutoGeneratedAnnouncementTeacher.clickedButton+"' and courseID=\""+IndividualCoursePageTeacher.courseID+"\"");
            while(rs.next())
            {
                fieldAnnouncement.setText(rs.getString(1));
            }
            //JOptionPane.showMessageDialog(null,IndividualCoursePageTeacher.teacherID );
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldAnnouncement = new javax.swing.JTextArea();
        lblName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Announcement Page");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 36, -1, 50));

        fieldAnnouncement.setColumns(20);
        fieldAnnouncement.setRows(5);
        jScrollPane1.setViewportView(fieldAnnouncement);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 880, 440));

        lblName.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblName.setText("announcementName");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setText("Course ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, -1, -1));

        lblCourseID.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblCourseID.setText("getCourseID");
        getContentPane().add(lblCourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnUpdate.setText("Update Announcement");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 620, -1, 40));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDelete.setText("Delete announcement");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, -1, 40));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try
        {
            //String studentId= studentIDAL.get(0);
            //int id=Integer.parseInt(studentId);
            Connection con = ConnectionProvider.getCon();
           
            String querry=("update anouncement set txtAnnouncement='"+fieldAnnouncement.getText()+"' where teacherID =\"" + IndividualCoursePageTeacher.teacherID+
                    "\" and announcementName='"+AutoGeneratedAnnouncementTeacher.clickedButton+"' and courseID=\""+IndividualCoursePageTeacher.courseID+"\"");
             PreparedStatement st = con.prepareStatement(querry);
           st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Announcement sucessfully updated");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try
        {
            //String studentId= studentIDAL.get(0);
            //int id=Integer.parseInt(studentId);
            Connection con = ConnectionProvider.getCon();
           
            String querry=("delete from anouncement where teacherID =\"" + IndividualCoursePageTeacher.teacherID+
                    "\" and announcementName='"+AutoGeneratedAnnouncementTeacher.clickedButton+"' and courseID=\""+IndividualCoursePageTeacher.courseID+"\"");
             PreparedStatement st = con.prepareStatement(querry);
           st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Announcement sucessfully updated");
            setVisible(false);
            new AnnouncementUpdateTeacher().setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(AnnouncementUpdateTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnnouncementUpdateTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnnouncementUpdateTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnnouncementUpdateTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnnouncementUpdateTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextArea fieldAnnouncement;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables
}
