/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import static LMS.ContentPageStudentCourse.lblCourseID;
import static LMS.ContentPageStudentCourse.lblStudentID;
import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bishal
 */
public class StartAssignment1Page extends javax.swing.JFrame {

    /**
     * Creates new form StartAssignment1Page
     */
    public StartAssignment1Page() {
        initComponents();
        getDetails();
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
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("these are the instructions for exam. You need to submit on time\nand other stuff");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 830, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("StudentId");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("courseID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, -1));

        lblCourseID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCourseID.setText("getCourseID");
        jPanel1.add(lblCourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Start Assignment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setText("Instructions For exam");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        lblStudentID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStudentID.setText("getStudentID");
        jPanel1.add(lblStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            // JOptionPane.showMessageDialog(null, uniqueID);
            lblCourseID.setText(name);
            lblStudentID.setText(uniqueID);
            setVisible(false);
            new Assignment1Student(uniqueID).setVisible(true);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(StartAssignment1Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartAssignment1Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartAssignment1Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartAssignment1Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartAssignment1Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblStudentID;
    // End of variables declaration//GEN-END:variables
}
