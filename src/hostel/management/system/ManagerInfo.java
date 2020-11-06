package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
        
public class ManagerInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
    
    ManagerInfo() {
        
            super("MANAGER INFO");
        
        t1 = new JTable();
        t1.setBounds(0,25,1300,80);
        t1.setBackground(Color.getHSBColor(180, 100, 94));
        add(t1);
        showTable();
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(600,180,100,30);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(80,5,60,10);
        add(l1);
        
        JLabel l2 = new JLabel("AGE");
        l2.setBounds(210,5,60,10);
        add(l2);
        
        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(370,5,60,10);
        add(l3);
        
        JLabel l4 = new JLabel("JOB");
        l4.setBounds(560,-3,60,20);
        add(l4);
        
        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(700,5,60,10);
        add(l5);
        
        JLabel l6 = new JLabel("CONTACT NO.");
        l6.setBounds(850,5,110,10);
        add(l6);
        
        JLabel l7 = new JLabel("AADHAR NO.");
        l7.setBounds(1010,5,90,10);
        add(l7);
        
        JLabel l8 = new JLabel("EMAIL");
        l8.setBounds(1180,5,60,10);
        add(l8);
        
        getContentPane().setBackground(Color.getHSBColor(180,100,94));
        setLayout(null);
        setBounds(100,280,1300,230);
        setVisible(true);
   
        
    }
    
    public void showTable(){
    t1.setShowGrid(true);
    t1.setGridColor(Color.blue);
        try {
                  
                conn c = new conn();
                String str = "select * from AddEmployee where job = 'Manager'";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "NO DATA FOUND");
            }
        
    }   
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == b1) {
             setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        
        new ManagerInfo();
    } 
    
}


