package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1, b2, b3;
    
    Rooms() {
        
            super("ROOMS INFO");
        
        t1 = new JTable();
        t1.setBounds(5,70,520,300);
        t1.setBackground(Color.getHSBColor(180, 100, 94));
        add(t1);
        
        showTable();
            
        b1 = new JButton("Room Search");
        b1.setBounds(420,450,150,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(100,450,120,30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Update");
        b3.setBounds(770, 450, 120, 30);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/NINTH.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(530,25,450,385);
        add(l1);
        
        JLabel l = new JLabel("ROOMS DETAIL");
        l.setBounds(170,-10,200,40);
        l.setFont(new Font("tahoma", Font.BOLD, 18));
        add(l);
        
        JLabel l2 = new JLabel("Room No.");
        l2.setBounds(40,45,70,15);
        add(l2);
        
        JLabel l3 = new JLabel("Availability");
        l3.setBounds(200,45,90,15);
        add(l3);
        
        JLabel l4 = new JLabel("Room Type");
        l4.setBounds(370,45,70,15);
        add(l4);
        
        getContentPane().setBackground(Color.getHSBColor(180, 100, 94));

        setBounds(230,120,1000,540);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void showTable(){
        t1.setShowGrid(true);
        t1.setGridColor(Color.blue);
        try {
                  
                conn c = new conn();
                String str = "select * from AddRoom";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            this.setVisible(false);
            new RoomShow().setVisible(true);
        } else if(ae.getSource() == b2) {
            new Reception().setVisible(true);
            setVisible(false);
        } else if(ae.getSource() == b3){
            new RoomUpdate().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Rooms();
    }
}
