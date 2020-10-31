/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

//import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Bishal
 */
public class ConnectionProvider 
{
    public static Connection getCon()
    {
        try
        {
            Class.forName("java.sql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learningmanagementsystem","root","toor");
			
            return conn;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot be connected to mySQL");
            return null;
        }
    }
    
}
