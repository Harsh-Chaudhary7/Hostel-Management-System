package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchEmployee extends JFrame implements ActionListener{
    
    JLabel l, l1, l2;
    JTextField t1, t2;
    JButton b1, b2;
    static String s;
    SearchEmployee(){
        
        super("Search");
        
        l = new JLabel("Employee Search");
        l.setBounds(160,-35,200,100);
        l.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(l);
        
        l1 = new JLabel("NAME");
        l1.setBounds(50,55,60,30);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(200, 55, 200, 30);
        add(t1);
        
        l2 = new JLabel("AADHAR NO.");
        l2.setBounds(50,95,100,30); 
        add(l2);
        
        t2 = new JTextField();
        t2.setBounds(200, 95, 200, 30);
        add(t2);
        
        b1 = new JButton("Search");
        b1.setBounds(260,130,70,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("x");
        b2.setBounds(485,0,15,15);
        b2.addActionListener(this);
        add(b2);
        
                
        getContentPane().setBackground(Color.GRAY);
        setBounds(480,350,500,200);
        setLayout(null);
        setVisible(true);
                
    }
                
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1){
        String Name = t1.getText();
        String Aadhar_no = t2.getText();
        s = Aadhar_no;
        
        this.setVisible(false);
        new EmployeeShow().setVisible(true);
    }else if(ae.getSource() == b2){
        this.setVisible(false);
        new Reception().setVisible(true);
    }
}

public static void main (String[] args){
    
    new SearchEmployee();
}

    String gets() {
        return this.s;
    }

}