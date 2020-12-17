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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bishal
 */
public class courseGrades extends javax.swing.JFrame {

    /**
     * Creates new form courseGrades
     */
    public courseGrades() {
        initComponents();
        //getDetails();
        accessGrades();
       // addAllGrades();
    }
    private String uniqueID=IndividualCoursePageStudent.studentID;
    private String teacherID=IndividualCoursePageStudent.teacherID;
    private String courseID=IndividualCoursePageStudent.courseID;
    
    public void accessGrades()
    {
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        try
        {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from grades1 where studentID=\""+uniqueID +"\" and courseID=\""+courseID +"\" and teacherID=\""+teacherID +"\" ");
            while(rs.next())
            {
                dtm.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
           // JOptionPane.showMessageDialog(null,uniqueID);
           // JOptionPane.showMessageDialog(null,teacherID);
            //JOptionPane.showMessageDialog(null,courseID);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Here"+e);
        }
    }
    public void getDetails()
    {
        try
        {
            String name="";
            
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           // String qrry = "select * from logindetails where username=\"" + Registration.textUser + "\"and password=\"" + Registration.txtPassword + "\"";
           ResultSet rs;
           rs = st.executeQuery("select *from student1 where username=\"" + Registration.txtUser.getText() + "\" and password1=\"" + Registration.txtPassword.getText() +"\"");
            while(rs.next())
            {
                name+=rs.getString(3);
                uniqueID+=rs.getString(6);
            }
             
           // txtName.setText(name);
            //txtStudentID.setText(uniqueID);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "H"+ex);
        }
    }
    public void addAllGrades()
    {
        try
        {
            double percentage=0;
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           ResultSet rs;
           rs = st.executeQuery("select percentage from grades1 where studentID=\"" + uniqueID + "\" and teacherID=\"" + teacherID + "\" and courseID=\"" + courseID +"\"");
            int count=0;
            while(rs.next())
            {
                percentage+=Double.valueOf(rs.getString(1));
                
                count=count+1;
            }
            double totalPercent=percentage/count;
            convertGrades(totalPercent);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void checkGradesTable()
    {
        
    }
    public void convertGrades(double per)
    {
        String letterGrade;
        if(per>=90 && per <=100)
        {
            letterGrade="A";
        }
        else if(per>=80 && per<90)
        {
            letterGrade="B";
        }
        else if(per>=70 && per <80)
        {
            letterGrade="C";
        }
        else if(per>=60 && per <70)
        {
            letterGrade="D";
        }
        else
            letterGrade="F";
        double percent=Math.round(per);
        ArrayList<String> perAL= new ArrayList<String>();
         try
        {
            String percen;
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
           ResultSet rs;
           rs = st.executeQuery("select percentage from grades where studentID=\"" + uniqueID + "\" and teacherID=\"" + teacherID + "\" and courseID=\"" + courseID +"\"");
            int count=0;
            while(rs.next())
            {
                percen=(rs.getString(1));
                
                perAL.add(percen);
            }
            if(perAL.size()==0)
            {
                //insertinto table
                 lblPercentage.setText(String.valueOf(percent));
                 lblGrade.setText(letterGrade);
                try
                {
                    Connection con1 = ConnectionProvider.getCon();
                    //JOptionPane.showMessageDialog(null,letterGrade );
                     PreparedStatement ps=con1.prepareStatement("insert into grades values(?,?,?,?,?)");
                     //JOptionPane.showMessageDialog(null,String.valueOf(per) );
                     ps.setString(1,uniqueID);
                     ps.setString(2,courseID);
                     ps.setString(3,teacherID);
                     ps.setString(4,String.valueOf(lblPercentage.getText()));
                     ps.setString(5,lblGrade.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Sucessfully inserted the marks to grades table");
                   

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            else
            {
                //update into table
                lblPercentage.setText(String.valueOf(percent));
                lblGrade.setText(letterGrade);
                try
                {
                    Connection con2 = ConnectionProvider.getCon();
                    String querry="update grades set percentage='"+String.valueOf(lblPercentage.getText())+"', grade='"+lblGrade.getText()+"'"
                            + " where studentID ='"+uniqueID+"' and courseID='"+courseID+"' and teacherID='"+teacherID+"'";
                    PreparedStatement st1=con2.prepareStatement(querry);
                    //st.executeUpdate("update grades set percentage='"+String.valueOf(lblPercentage.getText())+"' and grade='"+lblGrade.getText()+"'"
                    //        + " where studentID ='"+uniqueID+"' and courseID='"+courseID+"' and teacherID='"+teacherID+"'");
                    //String marks1 =String.valueOf(marks);
                    st1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Sucessfully updated the marks to grades table");
                    //JOptionPane.showMessageDialog(null,String.valueOf(lblPercentage.getText()));
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
              
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
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

        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCalculate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblGrade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblPercentage = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(480, 150));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/Close all jframe.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 0, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "studentID", "courseID", "teacherID", "assignmentName", "Percentage"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 70, 642, 276));

        btnCalculate.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnCalculate.setText("Calculate Final  Grade");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 364, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Final Letter Grade:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 479, -1, -1));

        lblGrade.setEditable(false);
        lblGrade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(lblGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 476, 108, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Final Percentage:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 425, -1, -1));

        lblPercentage.setEditable(false);
        lblPercentage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(lblPercentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 422, 108, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:
        addAllGrades();
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
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
            java.util.logging.Logger.getLogger(courseGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(courseGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(courseGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(courseGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new courseGrades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField lblGrade;
    private javax.swing.JTextField lblPercentage;
    // End of variables declaration//GEN-END:variables
}
