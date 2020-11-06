package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class EmployeeShow extends JFrame implements ActionListener{
    
    JTable t1;
    SearchEmployee st = new SearchEmployee();
    JButton b1;
    
    EmployeeShow(){
    
        super("Employee Data");
        
        t1 = new JTable();
        t1.setBounds(0,25,1300,80);
        add(t1);
        
        showTable();
        
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
        l5.setBounds(700,5,100,10);
        add(l5);
        
        JLabel l6 = new JLabel("CONTACT NO.");
        l6.setBounds(850,5,110,10);
        add(l6);
        
        JLabel l7 = new JLabel("AADHAR NO.");
        l7.setBounds(1010,5,100,10);
        add(l7);
        
        JLabel l8 = new JLabel("EMAIL");
        l8.setBounds(1180,5,100,10);
        add(l8);
        
        
        b1 = new JButton("Close");
        b1.setBounds(600,180,100,30);
        b1.addActionListener(this);
        add(b1);
        
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(100,280,1300,230);
    setVisible(true);
   
    
    }
    
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1){
        this.setVisible(false);
        //System.exit(0);
    }
}    
    
public void showTable(){
    t1.setShowGrid(true);
    t1.setGridColor(Color.blue);
    String s1 = st.gets();
        try {
             
                conn c = new conn();
                String str = "select * from AddEmployee where Aadhar_no = '"+s1+"'";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "NO DATA FOUND");                
            }
        
    }   
    

public static void main(String[] args){
    
    new EmployeeShow();

}

}
