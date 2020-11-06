/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FeeUpdate extends JFrame implements ActionListener{
    
    JLabel l, l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;
    static String s;
    
    FeeUpdate(){
        
            super("FEE UPDATE");
            
        l = new JLabel("FEE UPDATE");
        l.setBounds(180,-35,150,100);
        l.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(l);
        
        l1 = new JLabel("NAME");
        l1.setBounds(50,55,60,30);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(200, 55, 200, 30);
        add(t1);
        
        l2 = new JLabel("COLLEGE ID");
        l2.setBounds(50,115,100,30); 
        add(l2);
        
        t2 = new JTextField();
        t2.setBounds(200, 115, 200, 30);
        add(t2);
        
        l3 = new JLabel("TOTAL SUBMITION");
        l3.setBounds(50,175,150,30); 
        add(l3);
        
        t3 = new JTextField();
        t3.setBounds(200, 175, 200, 30);
        add(t3);
        
        b1 = new JButton("Update");
        b1.setBounds(200,230,70,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("x");
        b2.setBounds(485,0,15,15);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.GRAY);
        setBounds(480,350,500,300);
        setLayout(null);
        setVisible(true);
    
}

public void actionPerformed(ActionEvent ae){
    
    if(ae.getSource() == b1){
            String CollegeID = (String)t2.getText();
            String Fee = (String)t3.getText();
            conn c = new conn();
        try{
            String str = "Update addstudent set Fees = '"+Fee+"' where college_id = '"+CollegeID+"'";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Update Sucessful");
            this.setVisible(false);
            new AllStudentInfo().setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);            
        }   
    } else if(ae.getSource() == b2){
            this.setVisible(false);
            new AllStudentInfo().setVisible(true);
    }
    
}

public static void main(String[] args){
    new FeeUpdate();
}

}
