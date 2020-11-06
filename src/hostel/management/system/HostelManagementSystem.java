package hostel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HostelManagementSystem extends JFrame implements ActionListener{
    
    HostelManagementSystem(){
        setBounds(100,150,1300,460);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/Icons/FIRST.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1300,440);
        add(l1);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/Icons/THIRD.png"));
        JLabel l3 = new JLabel(i2);
        l3.setBounds(0,0,300,102);
        l1.add(l3);
        
        JLabel l2 = new JLabel("Hostel Management System");
        l2.setBounds(690,-10,620,70);
        l2.setForeground(Color.RED);
//        l2.setBackground(Color.WHITE);
//        l2.setOpaque(true);
        l2.setFont(new Font("serif", Font.ITALIC, 46));
        l1.add(l2);
        
        setLayout(null);
        setVisible(true);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1100,380,140, 50);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setFont(new Font("serif", Font.BOLD, 30));
        b1.addActionListener(this);
        l1.add(b1);
        
        
        while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(600);
            }catch(Exception e){}
            l2.setVisible(true);
            try{
            
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
  
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new HostelManagementSystem();
   
    }

    
}
