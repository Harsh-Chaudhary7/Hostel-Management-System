package hostel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel l1 , l2, l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;
    ImageIcon i1, i2;
    String username, password;
    static String s;
    
    Login(){
        
        super("LOGIN");
        
        
//        l1 = new JLabel("LOGIN");
//        l1.setBounds(245, 5, 200, 30);
//        l1.setFont(new Font("serif", Font.BOLD, 20));
//        add(l1);
        
        l1 = new JLabel("Username");
        l1.setBounds(10,64,100,40);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(10,104,100,40);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(120, 70, 200, 30);
        add(t1);
        
        p1 = new JPasswordField();
        p1.setBounds(120, 110, 200, 30);
        add(p1);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        b1.setBounds(30,180,130,30);
        b1.setOpaque(true);
//        b1.setBorderPainted(false);
        b1.setFont(new Font("serif", Font.PLAIN, 18));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("CANCEL");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setBounds(161,180,130,30);
        b2.setOpaque(true);
        b2.setFont(new Font("serif", Font.PLAIN, 18));
        b2.addActionListener(this);
        add(b2);
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/Icons/Second.jpg"));
        l3 = new JLabel(i1);
        l3.setBounds(330,40,260,220);
        add(l3);       
        
        setLayout(null);
        setBounds(500,250,600,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
               if(ae.getSource()== b1){                  
                   username = (String)t1.getText();
                   s = username;
                   password = (String)p1.getText();
                   conn c = new conn();
     
                   String str = "select * from login where username = '"+username+"' and password = '"+password+"'";
                   try{                     
                       ResultSet rs = c.s.executeQuery(str);
                       if(rs.next()) {
                           new Dashboard().setVisible(true);
                           this.setVisible(false);
                       } 
                       else 
                       {
                           JOptionPane.showMessageDialog(null,"Invalid username or password");
                           this.setVisible(false);
                         }                   
                   }catch(Exception e) {
                       JOptionPane.showMessageDialog(null, e);
                    }
              
               }else if(ae.getSource()== b2){
                   System.exit(0);
                }
     }
    public String getS(){
   return this.s;
}
    
    public static void main(String[] args){
        new Login();
        
        
    }
}

