package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class RoomShow extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1;
    RoomShow(){
        super("Room Availability");
        
        t1 = new JTable();
        t1.setBounds(5,70,520,250);
        add(t1);
        
        showTable();
        
        b1 = new JButton("BACK");
        b1.setBounds(200,320,100,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
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
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(230,120,520,400);
        setLayout(null);
        setVisible(true);        
    }
    public void showTable(){
        t1.setShowGrid(true);
        t1.setGridColor(Color.blue);
        try {
                  
                conn c = new conn();
                String str = "select * from AddRoom where Availability = 'available'";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "NO DATA FOUND");
            }
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
 public static void main(String[] args){
     new RoomShow();
 }   
    
}
