/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;
import static LMS.AddGradesPage.teacherCourseIDAL;
import java.sql.*;
import Project1.ConnectionProvider;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bishal
 */
public class AddCourses extends javax.swing.JFrame {

    /**
     * Creates new form Courses
     */
    public static String studentID;
    private ArrayList<String> studentCourseIDAL= new ArrayList<String>();
    private ArrayList<String> teacherIDAL= new ArrayList<String>();
    private ArrayList<String> registeredTeacherAL= new ArrayList<String>();
    private boolean registeredTeacherID=false;
    private boolean registeredTeacher=false;
    public AddCourses() {
        
        initComponents();
        accesStudentInfo();
        setCourseName();
        
        //setCourseName();
        //txtCourseNum.setSelectedItem(null);
       // setCourseName();
    }
    public void checkTeacherID()
    {
        
        try
        {
            Connection con = ConnectionProvider.getCon();
            Statement st= con.createStatement();
            String teacherID1;
           
            String teacherID=txtTeacherID.getText();
            
            ResultSet rs = st.executeQuery("select courses.teacherID from courses" );
            while(rs.next())
            {
                teacherID1=rs.getString(1);
                teacherCourseIDAL.add(teacherID1);
            }
            for(int i=0; i <teacherCourseIDAL.size();i++)
            {
                if(teacherCourseIDAL.get(i).equalsIgnoreCase(teacherID))
                {
                   registeredTeacherID=true;
                   break;      
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    public void checkRegisteredTeacher()
    {
        
        try
        {
            Connection con = ConnectionProvider.getCon();
            Statement st= con.createStatement();
            String teacherID1;
           
            String teacherID=txtTeacherID.getText();
            String courseID=txtCourseNum.getSelectedItem().toString();
            
            ResultSet rs = st.executeQuery("select courses.teacherID from courses where teacherID=\""+teacherID+"\" and courseID=\""+courseID+"\"" );
            //String qrry = "select * from student1 where username=\"" + textUser + "\"and password1=\"" + txtPassword + "\"";
            while(rs.next())
            {
                teacherID1=rs.getString(1);
                registeredTeacherAL.add(teacherID1);
            }
            for(int i=0; i <registeredTeacherAL.size();i++)
            {
                if(registeredTeacherAL.get(i).equalsIgnoreCase(teacherID))
                {
                   registeredTeacher=true;
                   break;      
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
     public void checkStudentCourse()
    {
        String courseID1=txtCourseNum.getSelectedItem().toString();
        boolean registeredCourse=false;
        if(txtTeacherID.getText().length()!=0 && txtCourseNum.getSelectedItem().toString()!="None")
        {
            try
            {
                Connection con = ConnectionProvider.getCon();
                Statement st= con.createStatement();
                String courseID2;

                studentID=txtStudentID.getText();

                ResultSet rs = st.executeQuery("select courses.courseID from courses where studentID='"+studentID+"'");
                while(rs.next())
                {
                    courseID2=rs.getString(1);
                    studentCourseIDAL.add(courseID2);
                }
                for(int i=0; i <studentCourseIDAL.size();i++)
                {
                    //JOptionPane.showMessageDialog(null, studentCourseIDAL.get(i));
                    if(studentCourseIDAL.get(i).equals(courseID1))
                    {
                       registeredCourse=true;
                       break;    
                    }

                }
                if(registeredCourse==false)
                {
                    checkTeacherID();
                    if(registeredTeacherID==true)
                    {
                        checkRegisteredTeacher();
                        if(registeredTeacher==true)
                        {
                            try
                            {
                                Connection con1 = ConnectionProvider.getCon();
                                String name=txtName.getText();
                                studentID =txtStudentID.getText();
                                String courseName=txtCourseName.getText();
                                String courseID=txtCourseNum.getSelectedItem().toString();

                                String instID=txtTeacherID.getText();
                                //String classroom=txtInstName.getText();

                                PreparedStatement ps = con.prepareStatement("insert into courses (courseID,courseName,teacherID,studentID)values(?,?,?,?)");
                                //ps.setString(1,name);
                                 ps.setString(4,studentID);
                                ps.setString(1,courseID);
                                ps.setString(2,courseName);
                                ps.setString(3,instID);
                                //ps.setString(5,classroom);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null,"Sucessfully updated");
                                setVisible(false);
                                new ShowCourses().setVisible(true);
                            }
                            catch (Exception e)
                            {
                                JOptionPane.showMessageDialog(null, "Error: " + e);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,txtTeacherID.getText()+"is not registered for this course.");
                        }    
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,txtTeacherID.getText()+"is not a registered teacher of this university.");
                    }
                     
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You are already registered to the course "+courseID1);
                }

            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please fill all the details");
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

        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        lblCourseNum = new javax.swing.JLabel();
        lblInstName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        txtTeacherID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDrop = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        txtCourseNum = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(480, 150));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Adding course to the blackboard system");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblName.setText("Student Name");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, -1));

        lblCourseName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCourseName.setText("Course Name");
        getContentPane().add(lblCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        lblCourseNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCourseNum.setText("Course ID");
        getContentPane().add(lblCourseNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        lblInstName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInstName.setText("Instructor ID");
        getContentPane().add(lblInstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 310, -1));

        txtCourseName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 310, -1));

        txtTeacherID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtTeacherID, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 310, -1));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setText("Add Course");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, 40));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, -1, 40));

        btnDrop.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDrop.setText("Drop Course");
        btnDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropActionPerformed(evt);
            }
        });
        getContentPane().add(btnDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Show courses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, -1, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Student id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 100, -1));

        txtStudentID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 310, 30));

        txtCourseNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCourseNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "CSC 121", "CSC 123", "CSC 300", "CSC 281", "CSC 471", "CSC 481", "CSC 311", "CSC 331", "CSC 341", "CSC 401", "CSC 453", "CSC 255", "CSC 461", "CSC 492", "CSC 321" }));
        txtCourseNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseNumActionPerformed(evt);
            }
        });
        getContentPane().add(txtCourseNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 310, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

       
        checkStudentCourse();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropActionPerformed
        
        setCourseName();
        String courseName= txtCourseName.getText();
        String teacherID= txtTeacherID.getText();
        if(courseName.length()!=0 && teacherID.length()!=0)
        {
            try
            {
                Connection con =ConnectionProvider.getCon();
                Statement st=con.createStatement();
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Log Out", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    st.executeUpdate("delete from courses where courseName='"+courseName+"' and teacherID='"+teacherID+"'");
                    JOptionPane.showMessageDialog(null,"Sucessfully deleted");
                    clear();     
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please fill all the detals to drop the course");
        }
        
    }//GEN-LAST:event_btnDropActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ShowCourses().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCourseNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseNumActionPerformed
        // TODO add your handling code here:
        setCourseName();
        
    }//GEN-LAST:event_txtCourseNumActionPerformed

    /**
     * @param args the command line arguments
     */
    public  void clear()
    {
        //txtName.setText("");
        txtCourseName.setText("");
        txtCourseNum.setSelectedItem("");
        txtTeacherID.setText("");
        
    }
    public void accesStudentInfo()
    {
        try
        {
            String name="";
            String uniqueID="";
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           ResultSet rs;
           rs = st.executeQuery("select student1.studentName, student1.studentID from student1 where username=\"" + Registration.txtUser.getText() + "\" and password1=\"" + Registration.txtPassword.getText() +"\"");
            while(rs.next())
            {
                name+=rs.getString(1);
                uniqueID+=rs.getString(2);
            }
            txtName.setText(name);
            txtStudentID.setText(uniqueID);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void setCourseName()
    {
        if(txtCourseNum.getSelectedItem().toString().equals("CSC 121"))
        {
            txtCourseName.setText("Java 1");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("None"))
        {
             txtCourseName.setText("");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 123"))
        {
             txtCourseName.setText("Java II");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 300"))
        {
             txtCourseName.setText("Software Development");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 281"))
        {
             txtCourseName.setText("Discrete Structure");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 471"))
        {
             txtCourseName.setText("Compiler Construction");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 481"))
        {
             txtCourseName.setText("Software Engineering");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 311"))
        {
             txtCourseName.setText("Data Structure");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 331"))
        {
             txtCourseName.setText("Computer Organization");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 341"))
        {
             txtCourseName.setText("Operating System");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 401"))
        {
             txtCourseName.setText("Analysis of Algorithm");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 453"))
        {
             txtCourseName.setText("Data Base Management System");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 255"))
        {
             txtCourseName.setText("Dynamic Web programming");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 461"))
        {
             txtCourseName.setText("Computer Graphics");
        }
        else if (txtCourseNum.getSelectedItem().toString().equals("CSC 492"))
        {
             txtCourseName.setText("Senior Design");
        }
         else if (txtCourseNum.getSelectedItem().toString().equals("CSC 321"))
        {
             txtCourseName.setText("Assembly Language");
        }
    }
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
            java.util.logging.Logger.getLogger(AddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCourses().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDrop;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblCourseNum;
    private javax.swing.JLabel lblInstName;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JComboBox<String> txtCourseNum;
    private javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtTeacherID;
    // End of variables declaration//GEN-END:variables
}
