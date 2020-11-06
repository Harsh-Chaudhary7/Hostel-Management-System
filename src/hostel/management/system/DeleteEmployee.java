package hostel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteEmployee extends JFrame implements ActionListener{
    
    JLabel l, l1, l2;
    JTextField t1, t2;
    JButton b1, b2;
    static String s;
    
    DeleteEmployee(){
        
            super("EMPLOYEE DATA");
        
        l = new JLabel("Delete Data");
        l.setBounds(180,-35,150,100);
        l.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(l);
        
        l1 = new JLabel("NAME");
        l1.setBounds(50,55,60,30);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(200, 55, 200, 30);
        add(t1);
        
        l2 = new JLabel("AADHAR NO");
        l2.setBounds(50,95,100,30); 
        add(l2);
        
        t2 = new JTextField();
        t2.setBounds(200, 95, 200, 30);
        add(t2);
        
        b1 = new JButton("Delete");
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
        try{
            String Name = (String)t1.getText();
            String AadharNO = (String)t2.getText();
            conn c = new conn();
            String str = "delete from addEmployee where Aadhar_no  = '"+AadharNO+"'";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Delete Sucessful");
        }catch (Exception e){
            e.printStackTrace();
        }
        this.setVisible(false);
        new AllEmployeeInfo().setVisible(true);
    } else if(ae.getSource() == b2){
            this.setVisible(false);
            new AllEmployeeInfo().setVisible(true);
    }
}
    
public static void main(String[] args){
    new DeleteEmployee();
}   
}
