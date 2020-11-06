package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class StudentShow extends JFrame implements ActionListener{
    
    JTable t1;
    SearchStudent st = new SearchStudent();
    JButton b1;
    
    StudentShow(){
    
        super("Student Data");
        
        t1 = new JTable();
        t1.setBounds(0,25,1000,80);
        add(t1);
        
        showTable();
        
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(20,5,60,10);
        add(l1);
        
        JLabel l2 = new JLabel("AGE");
        l2.setBounds(110,5,60,10);
        add(l2);
        
        JLabel l3 = new JLabel("DOB");
        l3.setBounds(200,5,60,10);
        add(l3);
        
        JLabel l4 = new JLabel("GENDER");
        l4.setBounds(325,5,60,10);
        add(l4);
        
        JLabel l5 = new JLabel("CONTACT NO.");
        l5.setBounds(425,5,100,10);
        add(l5);
        
        JLabel l6 = new JLabel("EMAIL");
        l6.setBounds(560,5,90,10);
        add(l6);
        
        JLabel l7 = new JLabel("COLLEGE ID");
        l7.setBounds(660,5,100,10);
        add(l7);
        
        JLabel l8 = new JLabel("ROOM");
        l8.setBounds(810,5,100,10);
        add(l8);
        
        JLabel l9 = new JLabel("FEES");
        l9.setBounds(915,5,90,10);
        add(l9);
        
        b1 = new JButton("Close");
        b1.setBounds(450,180,100,30);
        b1.addActionListener(this);
        add(b1);
        
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(290,280,1000,230);
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
                String str = "select * from AddStudent where College_id = '"+s1+"'";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "NO DATA FOUND");
            }
        
    }   
    

public static void main(String[] args){
    
    new StudentShow();

}

}
