/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.AbstractAction;
import javax.swing.*;

/**
 *
 * @author Bishal
 */
public class practiceCourseHomepage 
{
    public static void main(String[]args)
    {
        JFrame frame = new JFrame("Grid Layout");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLocation(120,120);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1, 5,10));
        JLabel label1 = new JLabel("Hello");
        JLabel label2 = new JLabel("Hello2");
        JLabel label3 = new JLabel("Hello3");
        JLabel label4 = new JLabel("Hello4");
        JLabel label5 = new JLabel("Hello5");
        JLabel label6 = new JLabel("Hello6");
        JLabel label7 = new JLabel("Hello7");
        JButton label8 = new JButton("helo Go");
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        frame.add(panel);
       
        
         JFrame frame1 = new JFrame("Example");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");
        JButton cancelButton = new JButton("Cancel");
        JButton setButton = new JButton("Set");

        panel.add(button1);
        panel.add(Box.createVerticalGlue());
        panel.add(button2);

        frame.add(panel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(cancelButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
       buttonPane.add(setButton);

                
    }
    
    
}