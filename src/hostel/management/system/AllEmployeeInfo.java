package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
        
public class AllEmployeeInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2,b3;
    
    AllEmployeeInfo() {
        
            super("EMPLOYEE INFO");
            
        t1 = new JTable();
        t1.setBounds(0,65,1300,300);
        t1.setBackground(Color.getHSBColor(180, 100, 94));
        add(t1);
        
        showTable();
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(230,440,120,30);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Search Employee");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(550,440,150,30);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Add Employee");
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(870,440,150,30);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this);
        add(b3);
        
        
        JLabel l = new JLabel("EMPLOYEE  DETAILS");
        l.setBounds(540,-10,200,40);
        l.setFont(new Font("tahoma", Font.BOLD, 18));
        add(l);
        
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(80,45,60,10);
        add(l1);
        
        JLabel l2 = new JLabel("AGE");
        l2.setBounds(210,45,60,10);
        add(l2);
        
        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(370,45,60,10);
        add(l3);
        
        JLabel l4 = new JLabel("JOB");
        l4.setBounds(560,37,60,24);
        add(l4);
        
        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(700,45,55,10);
        add(l5);
        
        JLabel l6 = new JLabel("CONTACT NO.");
        l6.setBounds(850,45,95,10);
        add(l6);
        
        JLabel l7 = new JLabel("AADHAR NO.");
        l7.setBounds(1010,45,90,10);
        add(l7);
        
        JLabel l8 = new JLabel("EMAIL");
        l8.setBounds(1180,45,60,10);
        add(l8);
        
        getContentPane().setBackground(Color.getHSBColor(180, 100, 94));
        
        setBounds(100,120,1300,540);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == b1) {
            this.setVisible(false);
            new Reception().setVisible(true);
        } else if(ae.getSource() == b2) {
            this.setVisible(false);
            new SearchEmployee().setVisible(true);
        } else if(ae.getSource() == b3){
            this.setVisible(false);
            new AddEmployee().setVisible(true);
        }
    }
    
    public void showTable(){
    t1.setShowGrid(true);
    t1.setGridColor(Color.blue);
        try {
             
                conn c = new conn();
                String str = "select * from AddEmployee";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }   
    
    public static void main(String[] args) {
        
        new AllEmployeeInfo();
    } 
    
}
