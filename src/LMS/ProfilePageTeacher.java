/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LMS;
import Project1.ConnectionProvider;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Bishal
 */
public class ProfilePageTeacher extends javax.swing.JFrame {

    /**
     * Creates new form ProfilePage
     */
    public static String teacherID;
    public ProfilePageTeacher() 
    {
        initComponents();
        getDetails();
        
    }
    public void updateProfile()
    {
        try
		{
                    Class.forName("java.sql.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/learningmanagementsystem","root","toor");
                    //Statement stmnt = conn.createStatement();
                    String qrry= "update teacher set userName=?, password1=?, teacherName=?, email=?, phone=? where userName=? and password1=?";
                    PreparedStatement pst= conn.prepareStatement(qrry);
                    pst.setString(1,fieldUserName.getText());
                    pst.setString(2,fieldPassword.getText());
                    pst.setString(3,fieldName.getText());
                    pst.setString(4,fieldEmail.getText());
                    pst.setString(5,fieldPhone.getText());
                    pst.setString(6,fieldUserName.getText());
                    pst.setString(7,fieldPassword.getText());
                    
                    pst.executeUpdate();

                    pst.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "Great, You have sucessfully updated yopur information!");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error in connecting with mySql" + ex);
		}
    }
    public void getDetails()
    {
        try
        {
            String name="";
            String email="";
            String phoneNumber="";
            String userName="";
            String password ="";
            //String uniqueID="";
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           // String qrry = "select * from logindetails where username=\"" + Registration.textUser + "\"and password=\"" + Registration.txtPassword + "\"";
           ResultSet rs;
           rs = st.executeQuery("select *from teacher where username=\"" + Registration.txtUser.getText() + "\" and password1=\"" + Registration.txtPassword.getText() +"\"");
            // ResultSet rs = st.executeQuery("select *from logindetails");
            while(rs.next())
            {
                userName+=rs.getString(1);
                password+=rs.getString(2);
                name+=rs.getString(3);
                email+=rs.getString(4);
                phoneNumber+=rs.getString(5);
                teacherID=rs.getString(6);
            }
            fieldName.setText(name);
            fieldEmail.setText(email);
            fieldPhone.setText(phoneNumber);
            fieldUserName.setText(userName);
            fieldPassword.setText(password);
            fieldUniqueID.setText(teacherID);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        fieldUserName = new javax.swing.JTextField();
        fieldPhone = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldName = new javax.swing.JTextField();
        fieldLanguage = new javax.swing.JTextField();
        fieldNotifications = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        lblUniqueID = new javax.swing.JLabel();
        fieldUniqueID = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(470, 140));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Basic Information");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Email Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Contact Information");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Gloabal Notifications");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 204, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("System Setting");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Languages");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 204, 204));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Privacy Settings");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Phone Number");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("User Name:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Password");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        fieldPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldPassword.setText("password");
        jPanel1.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 180, -1));

        fieldUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldUserName.setText("User Name");
        jPanel1.add(fieldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 170, -1));

        fieldPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldPhone.setText("Phone number");
        jPanel1.add(fieldPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 180, 30));

        fieldEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldEmail.setText("Email here");
        jPanel1.add(fieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 270, 30));

        fieldName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldName.setText("Name Here");
        jPanel1.add(fieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 240, 30));

        fieldLanguage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldLanguage.setText("English");
        jPanel1.add(fieldLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 190, -1));

        fieldNotifications.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldNotifications.setText("No New Notoifications");
        jPanel1.add(fieldNotifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 200, -1));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField7.setText("Open Settings");
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 200, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdate.setText("Update Information");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        lblUniqueID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUniqueID.setText("Unique ID:");
        jPanel1.add(lblUniqueID, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        fieldUniqueID.setEditable(false);
        fieldUniqueID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldUniqueID.setText("ID here");
        jPanel1.add(fieldUniqueID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 696, 460));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, 40));

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Image");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Student Information");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
       setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateProfile();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(ProfilePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilePageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilePageTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldLanguage;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldNotifications;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JTextField fieldUniqueID;
    private javax.swing.JTextField fieldUserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblUniqueID;
    // End of variables declaration//GEN-END:variables
}
