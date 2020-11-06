package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import javax.swing.table.*;

public class AllStudentInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2,b3;
    
    AllStudentInfo() {
        
            super("STUDENT INFO");
        
        t1 = new JTable();
        t1.setBounds(0,60,1300,300);
        t1.setBackground(Color.getHSBColor(180, 100, 94));
        add(t1);

        showTable();
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(230,440,120,30);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Search Student");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(550,440,150,30);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Add Student");
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(870,440,150,30);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this);
        add(b3);
        
        JLabel l = new JLabel("STUDENTS  DETAILS");
        l.setBounds(550,-10,200,40);
        l.setFont(new Font("tahoma", Font.BOLD, 18));
        add(l);
        
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(40,45,60,10);
        add(l1);
        
        JLabel l2 = new JLabel("AGE");
        l2.setBounds(150,45,60,10);
        add(l2);
        
        JLabel l3 = new JLabel("DOB");
        l3.setBounds(330,45,60,10);
        add(l3);
        
        JLabel l4 = new JLabel("GENDER");
        l4.setBounds(435,45,60,10);
        add(l4);
        
        JLabel l5 = new JLabel("CONTACT NO.");
        l5.setBounds(600,45,100,10);
        add(l5);
        
        JLabel l6 = new JLabel("EMAIL");
        l6.setBounds(760,45,90,10);
        add(l6);
        
        JLabel l7 = new JLabel("COLLEGE ID");
        l7.setBounds(890,45,100,10);
        add(l7);
        
        JLabel l8 = new JLabel("ROOM");
        l8.setBounds(1060,45,100,10);
        add(l8);
        
        JLabel l9 = new JLabel("FEES");
        l9.setBounds(1210,45,90,10);
        add(l9);
        
        getContentPane().setBackground(Color.getHSBColor(180, 100, 94));
        
        setBounds(100,120,1300,540);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == b1) {
            new Reception().setVisible(true); 
            this.setVisible(false);
        } else if(ae.getSource() == b2) {
            new SearchStudent().setVisible(true);
            setVisible(false);
        } else if(ae.getSource() == b3){
            new AddStudent().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public void showTable(){
        t1.setShowGrid(true);
        t1.setGridColor(Color.blue);
        try {
                  
                conn c = new conn();
                String str = "select * from AddStudent";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }
    
    public static void main(String[] args) {
        
        new AllStudentInfo();
    } 
    
}


