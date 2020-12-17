/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import static LMS.PrintStudentList.jTable1;
import static LMS.Registration.txtUniqueID;
import Project1.ConnectionProvider;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bishal
 */
public class AddGradesPage extends javax.swing.JFrame {

    /**
     * Creates new form AddGradesPage
     */
    public static ArrayList<String> teacherCourseIDAL= new ArrayList<String>();
    private ArrayList<String> studentCourseIDAL= new ArrayList<String>();
   // private ArrayList<String> teacherIDAL= new ArrayList<String>();
    private ArrayList<String> studentIDAL= new ArrayList<String>();
    public AddGradesPage() {
        initComponents();
        getUniqueIDTeacher();
        ShowGrades();
        //getUniqueIDTeacher();
    }
    public void clear()
    {
        txtStudentID.setText("");
        txtCourseID.setSelectedItem("");
        //txtTeacherID.setText(null);
        txtGrade.setText("");
    }
    public void update()
    {
        setVisible(false);
        new AddGradesPage().setVisible(true);
    }
    public void addGrades()
    {
        boolean registeredCourse=false;
        boolean registeredCourseSTD=false;
        String courseID1=txtCourseID.getSelectedItem().toString();
        //Paste code from add portion here later
         try
            {
                if(!txtCourseID.getSelectedItem().toString().equals("None"))
                {
                    if(txtStudentID.getText().length()!=0 && txtGrade.getText().length()!=0)
                    {
                        try
                        {
                            Connection con = ConnectionProvider.getCon();
                            Statement st= con.createStatement();
                            String courseID;

                            String teacherID=txtTeacherID.getText();

                            ResultSet rs = st.executeQuery("select courses.courseID from courses where teacherID='"+teacherID+"'");
                            while(rs.next())
                            {
                                courseID=rs.getString(1);
                                teacherCourseIDAL.add(courseID);
                            }
                            
                            for(int i=0; i <teacherCourseIDAL.size();i++)
                            {
                                //JOptionPane.showMessageDialog(null,teacherCourseIDAL.get(i));
                                if(teacherCourseIDAL.get(i).equals(courseID1))
                                {
                                   registeredCourse=true;
                                   break;
                                  
                                }
                            }
                            //JOptionPane.showMessageDialog(null,registeredCourse);
                            if(registeredCourse==true)
                            {
                                 try
                                {
                                    Connection con2 = ConnectionProvider.getCon();
                                    Statement st1= con.createStatement();
                                    //String courseID;

                                    String studentID=txtStudentID.getText();

                                    ResultSet rs2 = st.executeQuery("select courses.courseID from courses where studentID='"+studentID+"'");
                                    while(rs2.next())
                                    {
                                        courseID=rs2.getString(1);
                                        studentCourseIDAL.add(courseID);
                                    }
                                    for(int i=0; i <studentCourseIDAL.size();i++)
                                    {
                                        //JOptionPane.showMessageDialog(null,teacherCourseIDAL.get(i));
                                        if(studentCourseIDAL.get(i).equals(courseID1))
                                        {
                                           registeredCourseSTD=true;
                                           break;

                                        }
                                    }
                                    if(registeredCourseSTD==true)
                                    {
                                        Connection con1=ConnectionProvider.getCon();
                                        String studentId=txtStudentID.getText();
                                        String CourseId=txtCourseID.getSelectedItem().toString();
                                        String Grades=txtGrade.getText();
                                        String Comments=txtTeacherID.getText();
                                        PreparedStatement ps =con1.prepareStatement("insert into grades (studentID,courseID,grades,teacherID) values(?,?,?,?)");
                                        ps.setString(1,studentId);
                                        ps.setString(2,CourseId);
                                        ps.setString(3,Grades);
                                        ps.setString(4,Comments);
                                        ps.executeUpdate();
                                        JOptionPane.showMessageDialog(null,"Sucessfully updated");

                                        ShowGrades();
                                        clear();
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null,"This student with "+txtStudentID.getText()+" is not registered to the course "+courseID1);

                                    }

                                    }
                                catch (Exception e)
                                {
                                    JOptionPane.showMessageDialog(null, "Error: " + e);
                                }
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"You are not registered to the course "+courseID1);
                            }
                            
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Error: " + e);
                        }
                        
                    }
                    else
                    {
                         JOptionPane.showMessageDialog(null,"Please fill in all Fields");

                    }    
                }
                else
                {
                     JOptionPane.showMessageDialog(null,"Please select a course to add");
                }

            }
       catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }
    public void ShowGrades()
    {
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        try
        {
            getUniqueIDTeacher();
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from grades where teacherID=\"" + txtTeacherID.getText() + "\"");
            while(rs.next())
            {
                dtm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(3)});
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
     public void getUniqueIDTeacher()
    {
        String teacherID="";
        try
        {
            Class.forName("java.sql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/learningmanagementsystem", "root", "toor");
            Statement stmnt = conn.createStatement();
            String sql;
            sql = "Select teacher.teacherID from teacher where username=\"" + Registration.txtUser.getText() + "\" and password1=\"" + Registration.txtPassword.getText() +"\"";
            ResultSet rs= stmnt.executeQuery(sql);
            rs.next();

           teacherID =(rs.getString(1));
            txtTeacherID.setText(teacherID);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void checkTeacherCourse(String courseID1)
    {
        try
        {
            Connection con = ConnectionProvider.getCon();
            Statement st= con.createStatement();
            String courseID;
           
            String teacherID=txtTeacherID.getText();
            
            ResultSet rs = st.executeQuery("select courses.courseID from courses where teacherID='"+teacherID+"'");
            while(rs.next())
            {
                courseID=rs.getString(1);
                teacherCourseIDAL.add(courseID);
            }
            for(int i=0; i <teacherCourseIDAL.size();i++)
            {
                if(teacherCourseIDAL.get(i).equalsIgnoreCase(courseID1))
                {
                   //Call Add method here
                    
                   checkStudentCourse(txtCourseID.getSelectedItem().toString());
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You are not registered to the course "+courseID1);
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
     public void checkStudentCourse(String courseID1)
    {
        try
        {
            Connection con = ConnectionProvider.getCon();
            Statement st= con.createStatement();
            String courseID;
           
            String studentID=txtStudentID.getText();
            
            ResultSet rs = st.executeQuery("select courses.courseID from courses where studentID='"+studentID+"'");
            while(rs.next())
            {
                courseID=rs.getString(1);
                studentCourseIDAL.add(courseID);
            }
            for(int i=0; i <studentCourseIDAL.size();i++)
            {
                if(studentCourseIDAL.get(i).equalsIgnoreCase(courseID1))
                {
                   //Call Add method here
                    addGrades();
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You are not registered to the course "+courseID1);
                }
            }
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

        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        txtGrade = new javax.swing.JTextField();
        txtTeacherID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCourseID = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(480, 150));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Student ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 115, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Course ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 176, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Grades:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 240, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Add/Delete Student's Grades");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 412, -1, 37));

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, 40));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Teacher ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 322, 90, -1));

        txtStudentID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 160, -1));

        txtGrade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 237, 160, -1));

        txtTeacherID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtTeacherID, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 319, 160, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Course ID", "Grades", "Teacher ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 440, 287));

        txtCourseID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCourseID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "CSC 121", "CSC 123", "CSC 300", "CSC 281", "CSC 471", "CSC 481", "CSC 311", "CSC 331", "CSC 341", "CSC 401", "CSC 453", "CSC 205", "CSC 461", "CSC 492", "CSC 321" }));
        getContentPane().add(txtCourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 160, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        //checkTeacherCourse(cID);
        addGrades();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = jTable1.getSelectedRow();
        String studentID = jTable1.getValueAt(row, 0).toString();
        String courseID = jTable1.getValueAt(row, 1).toString();
        String sql ="DELETE FROM grades where studentID = ? and courseID= ?";
        try
        {
            if(jTable1.getSelectedRowCount()== 0)
            {
                JOptionPane.showMessageDialog(null,"Please select any table you want to delete");
            }
            else if(jTable1.getSelectedRowCount()==1)
            {
                
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,studentID);
                ps.setString(2,courseID);
                int a = JOptionPane.showConfirmDialog(null,"Do you really want to Delete Grade","Select",JOptionPane.YES_NO_OPTION);
                if(a ==0)
                {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Deleted Sucessfully");
                    ShowGrades();
                }    
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please select only one row to delete");
                
            }
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
           try
       {
           
           Connection con=ConnectionProvider.getCon();
           String studentId=txtStudentID.getText();
           String CourseId=txtCourseID.getSelectedItem().toString();
           String Grades=txtGrade.getText();
           String teacherID=txtTeacherID.getText();
           PreparedStatement ps =con.prepareStatement("update grades (studentID,courseID,grades,teacherID) values(?,?,?,?)");
           ps.setString(1,studentId);
           ps.setString(2,CourseId);
           ps.setString(3,Grades);
           ps.setString(4,teacherID);
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Sucessfully updated");
           //clear();
           ShowGrades();
           //update();
           clear();
           
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(AddGradesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGradesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGradesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGradesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGradesPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtCourseID;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtTeacherID;
    // End of variables declaration//GEN-END:variables
}
