package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class FeeStructure extends JFrame implements ActionListener{
    
    JButton b1;
    JTable t1;
    JLabel l,l1,l2,l3,l4,l5,l6,l7;
    
    FeeStructure(){
            
           super("FEE");
           
        t1 = new JTable();
        t1.setBounds(30,50,790,100);
        add(t1);
        
        showTable();
           
        JLabel l = new JLabel("STRUCTURE");
        l.setFont(new Font("serif",Font.PLAIN,22));
        l.setBounds(350,5,180,30);
        add(l);
        
        l1 = new JLabel("S.NO");
        l1.setBounds(55,30,40,20);
        add(l1);
        
        l2 = new JLabel("BED_TYPE");
        l2.setBounds(155,30,80,20);
        add(l2);
        
        l3 = new JLabel("MESS_FEES");
        l3.setBounds(260,30,80,20);
        add(l3);
        
        l4 = new JLabel("ROOM_RENT");
        l4.setBounds(380,30,80,20);
        add(l4);
        
        l5 = new JLabel("MAINTENANCE");
        l5.setBounds(485,30,100,20);
        add(l5);
        
        l6 = new JLabel("TOTAL_FEES");
        l6.setBounds(620,30,80,20);
        add(l6);
        
        l7 = new JLabel("REG._FEES");
        l7.setBounds(720,30,80,20);
        add(l7);
        
        b1 = new JButton("BACK");
        b1.setBounds(370,160,100,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        

        
        JLabel l2 = new JLabel("STATUS");
        l2.setFont(new Font("serif",Font.PLAIN,1));
        l2.setBounds(100,200,120,30);
        add(l2);
          
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setBounds(280,120,850,220);
        setLayout(null);
    }
    
public void showTable(){
        t1.setShowGrid(true);
        t1.setGridColor(Color.blue);
        try {
                  
                conn c = new conn();
                String str = "select * from Fee";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }
    
public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
            new Dashboard().setVisible(true);
        }
}
  
public static void main(String[] args){
    new FeeStructure();
}
    
}
