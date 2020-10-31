/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Bishal
 */
public class layoutrPractice 
{
    
    public static void main(String[]args)
    {
        JFrame frame = new JFrame("Courses Homepage");
        frame.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        frame.setLayout(new FlowLayout());
        frame.setSize(500,400);
        panel.setLayout(new FlowLayout());
        
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(int i=0; i < 10; i++)
        {
            buttons.add(new JButton("Button :: " +i));
        }
        
        frame.add(panel);
        
        frame.setVisible(true);
        //frame.setUndecorated(false);
        
    }
    public void actionPerformed(ActionEvent e)
    {
       // if(e.getSource()==buttons.get(0));
    }
    
}
