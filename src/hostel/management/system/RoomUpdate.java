package hostel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoomUpdate extends JFrame implements ActionListener{
    
    JButton b1, b2;
    JComboBox c1;
    JLabel l, l1, l2;
    JTextField t1;
    
    RoomUpdate(){
        
            super("ROOM UPDATATION");
            
        l = new JLabel("ROOM UPDATE");
        l.setBounds(120,5,180,30);
        l.setFont(new Font("tahoma", Font.BOLD, 18));
        add(l);
        
        b1 = new JButton("Update");
        b1.setBounds(150,160,80,30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        l1 = new JLabel("ROOM NO.");
        l1.setFont(new Font("serif",Font.PLAIN,16));
        l1.setBounds(40,70,120,30);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(180,70,160,30);
        add(t1);

	l2 = new JLabel("STATUS");
        l2.setFont(new Font("serif",Font.PLAIN,16));
        l2.setBounds(40,110,120,30);
        add(l2);
        
        c1 = new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(180,110,160,30);
        c1.setBackground(Color.white);
        add(c1);		
        
        b2 = new JButton("x");
        b2.setBounds(385,0,15,15);
        b2.addActionListener(this);
        add(b2);
        
        setLayout(null);
        setBounds(490,320,400,220);
        setVisible(true);
        
    }
public void actionPerformed(ActionEvent ae){
    
    if(ae.getSource() == b1){
        try{
            String available = (String)c1.getSelectedItem();
            String RoomNo = (String)t1.getText();
            conn c = new conn();
            String str = "update addroom set availability = '"+available+"' where room_no  = '"+RoomNo+"'";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Update Sucessful");
        }catch (Exception e){
            e.printStackTrace();
        }
        this.setVisible(false);
        new Rooms().setVisible(true);
    } else if(ae.getSource() == b2){
            this.setVisible(false);
            new Rooms().setVisible(true);
    }
}

public static void main(String[] args){
    new RoomUpdate();
}
}