package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.sql.ResultSet;

public class Remove extends JFrame implements ActionListener{
    
    Choice choiceEMPid;
    
    JButton delete, back;
    
    
    Remove(){
        
        
        
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
//        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(label);
        
        
        choiceEMPid = new Choice();
        choiceEMPid.setBounds(200,50,150,30);
        add(choiceEMPid);
        
        
        try{
            
            Conn c = new Conn();
            ResultSet resultset = c.statement.executeQuery("select * from employee");
            while(resultset.next()){
                choiceEMPid.add(resultset.getString("eID"));
            }
            
            
            
        }
        catch(Exception b){
            
            b.printStackTrace();
            
        }
        
        
        JLabel labelname  = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        
        JLabel textname  = new JLabel();
        textname.setBounds(200,100,100,30);
        add(textname);
        
        
        JLabel labelphone  = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        
        JLabel textphone  = new JLabel();
        textphone.setBounds(200,150,100,30);
        add(textphone);
        
        
        JLabel labeladdress  = new JLabel("Address");
        labeladdress.setBounds(50,200,100,30);
        add(labeladdress);
        
        
        JLabel textaddress  = new JLabel();
        textaddress.setBounds(200,200,100,30);
        add(textaddress);
        
        
        try{
            Conn c = new Conn();
            ResultSet resultset = c.statement.executeQuery("select * from employee where eID = '"+choiceEMPid.getSelectedItem()+"'");
            while(resultset.next()){
                textname.setText(resultset.getString("name"));
                textphone.setText(resultset.getString("phone"));
                textaddress.setText(resultset.getString("address"));
            }
            
        }
        catch(Exception d){
            d.printStackTrace();
            
        }
        
        
        choiceEMPid.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                try{
                    
                    Conn c = new Conn();
            ResultSet resultset = c.statement.executeQuery("select * from employee where eID = '"+choiceEMPid.getSelectedItem()+"'");
            while(resultset.next()){
                textname.setText(resultset.getString("name"));
                textphone.setText(resultset.getString("phone"));
                textaddress.setText(resultset.getString("address"));
            }
                    
                }
                catch(Exception E){
                    E.printStackTrace();
                    
                }
            }
        });
        
        
        
        
        
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(200,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700, 80, 200, 200);
        add(image);
        
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img = new JLabel(i33);
        img.setBounds(0, 0, 1120, 630);
        add(img);
        
        setSize(1000, 400);
        setLayout(null);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        
    }
    
    public static void main(String args[]){
        
        new Remove();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == delete){
            try{
                
                Conn c = new Conn();
                String query = "delete from employee where eID = '"+choiceEMPid.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee data deleted");
                setVisible(false);
                
                
            }
            catch(Exception s){
                s.printStackTrace();
            }
        }
        
        else{
            setVisible(false);
        }
        
    }
    
}
