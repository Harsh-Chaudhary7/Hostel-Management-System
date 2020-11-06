package hostel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m, m1, m2, m3, m4;
    JMenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7, mi8;
    ImageIcon i1, i2;
    JButton b1;
    JLabel l1, l2;
    JTextField t1;
    Login u = new Login();
    
    Dashboard(){
        
          mb = new JMenuBar();
          add(mb);
          mb.setBounds(0, 0, 1440, 55);
       
          m= new JMenu("Hostel Management");
          m.setForeground(Color.red);
          m.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m);
          
          m1 = new JMenu("Student Portal");
          m1.setForeground(Color.red);
          m1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m1);
          
          m2 = new JMenu("Room Management");
          m2.setForeground(Color.RED);
          m2.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m2);
          
          m3 = new JMenu("Staff Management");
          m3.setForeground(Color.red);
          m3.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m3);
          
          m4 = new JMenu("Hostel Fees");
          m4.setForeground(Color.red);
          m4.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mb.add(m4);
          
          mi1 = new JMenuItem("Reception");
          mi1.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi1.addActionListener(this);
          m.add(mi1);
          
          mi1 = new JMenuItem("Add Student");
          mi1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi1.addActionListener(this);
          m1.add(mi1);
          
          mi2 = new JMenuItem("Delete Student");
          mi2.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi2.addActionListener(this);
          m1.add(mi2);
          
          mi3 = new JMenuItem("Add Room");
          mi3.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi3.addActionListener(this);
          m2.add(mi3);
          
          mi4 = new JMenuItem("Update Room");
          mi4.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi4.addActionListener(this);
          m2.add(mi4);
          
          mi5 = new JMenuItem("Add Staff");
          mi5.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi5.addActionListener(this);
          m3.add(mi5);
          
          mi6 = new JMenuItem("Delete Staff");
          mi6.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi6.addActionListener(this);
          m3.add(mi6);
          
          mi7 = new JMenuItem("Show Structure");
          mi7.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi7.addActionListener(this);
          m4.add(mi7);
          
          mi8 = new JMenuItem("Update Fees");
          mi8.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi8.addActionListener(this);
          m4.add(mi8);
          
          
          mb.add(Box.createHorizontalGlue());
          b1 = new JButton("Logout");
          b1.addActionListener(this);
          mb.add(b1);
          
          i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/FOURTH.jpg"));
          l1 = new JLabel(i1);
          l1.setBounds(0,0,1200,675);
          add(l1);
          
          String s2 = u.getS();
          l2 = new JLabel("WELCOME! "+s2);
          l2.setBounds(970,40,620,100);
          l2.setForeground(Color.getHSBColor(25.8f, 17.9f, 20.6f));
          l2.setFont(new Font("Tahoma",Font.BOLD,46));
          l1.add(l2);
          
      
          
        
        setBounds(100,100,1440,900);
        setVisible(true);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            int a = JOptionPane.showConfirmDialog(null, "Do you wish to Logout! ","Select",JOptionPane.YES_NO_OPTION);
            if(a==0){
                setVisible(false);
                new Login().setVisible(true);
            }
        }
            
        if(ae.getActionCommand().equals("Reception")) {
                new Reception().setVisible(true);
          } else if(ae.getActionCommand().equals("Add Staff")) {
                new AddEmployee().setVisible(true);
          } else if(ae.getActionCommand().equals("Add Student")) {
                new AddStudent().setVisible(true);
          } else if(ae.getActionCommand().equals("Add Room")) {
                new AddRoom().setVisible(true);
          } else if(ae.getActionCommand().equals("Delete Student")){
                new DeleteStudent().setVisible(true);
          } else if(ae.getActionCommand().equals("Delete Staff")){
                new DeleteEmployee().setVisible(true);
          } else if(ae.getActionCommand().equals("Update Room")){
                new RoomUpdate().setVisible(true);
          } else if(ae.getActionCommand().equals("Show Structure")){
                new FeeStructure().setVisible(true);
          } else if(ae.getActionCommand().equals("Update Fees")){
                new FeeUpdate().setVisible(true);
          }
    }

public static void main(String[] args){
    new Dashboard();
}
}