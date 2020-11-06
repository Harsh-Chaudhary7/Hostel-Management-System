package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Reception extends JFrame implements ActionListener {
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JLabel l1,l2;
    JTable t1;
    
    Reception() {
            
        super("RECEPTION");
               
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/FIFTH.jpg"));
        Image i2 = i1.getImage().getScaledInstance(510,430,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(200,40,510,430);
        add(l2);
        
        l1 = new JLabel("Reception");
        l1.setBounds(300,10,120,20);
        l1.setFont(new Font("courier", Font.ITALIC, 22));
        add(l1);
        
        b1 = new JButton("All Student Info");
        b1.setBounds(30,60,150,30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Manager Info");
        b2.setBounds(30,110,150,30);
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("All Employee Info");
        b3.setBounds(30,160,150,30);
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this); 
        add(b3);
        
        b4 = new JButton("Rooms");
        b4.setBounds(30,210,150,30);
        b4.setBackground(Color.white);
        b4.setForeground(Color.black);
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.addActionListener(this); 
        add(b4);
        
//        b5 = new JButton("Search Student");
//        b5.setBounds(30,260,150,30);
//        b5.setBackground(Color.white);
//        b5.setForeground(Color.black);
//        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        b5.addActionListener(this); 
//        add(b5);
//        
//        b6 = new JButton("Search Room");
//        b6.setBounds(30,310,150,30);
//        b6.setBackground(Color.white);
//        b6.setForeground(Color.black);
//        b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        b6.addActionListener(this); 
//        add(b6);
//        
//        b7 = new JButton("Search Employee");
//        b7.setBounds(30,360,150,30);
//        b7.setBackground(Color.white);
//        b7.setForeground(Color.black);
//        b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        b7.addActionListener(this); 
//        add(b7);
        
        b8 = new JButton("Back");
        b8.setBounds(30,410,150,30);
        b8.setBackground(Color.white);
        b8.setForeground(Color.black);
        b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b8.addActionListener(this); 
        add(b8);
        
        
        
        getContentPane().setBackground(Color.getHSBColor(200.10f, 90.20f, 90.35f));
  
        setBounds(330,180,750,500);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            new AllStudentInfo().setVisible(true);
            this.setVisible(false); 
            
        } 
         else if(ae.getSource() == b2) {
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b3) {
            
            new AllEmployeeInfo().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b4) {
            new Rooms().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b5) {
            
        } else if(ae.getSource() == b6) {
            
        } else if(ae.getSource() == b7) {
            
        } else if(ae.getSource() == b8) {
            new Dashboard().setVisible(true);
            setVisible(false);
        }
    }
    
    public static void main(String [] args) {
        
        new Reception().setVisible(true);
    }
}
