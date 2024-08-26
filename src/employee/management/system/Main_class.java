
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class Main_class extends JFrame implements ActionListener{
    
    JButton add, view, remove;
    
    Main_class(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel im = new JLabel(i3);
        im.setBounds(0,0,1120,630);
        add(im);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        im.add(heading);
        
        
        add = new JButton("Add");
        add.setBounds(335,270,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        im.add(add);
        
        view = new JButton("View");
        view.setBounds(500,270,150,40);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        im.add(view);
        
        remove = new JButton("Remove");
        remove.setBounds(425,350,150,40);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        im.add(remove);
        
        
        
        setSize(1120, 630);
        setLayout(null);
        setLocation(150, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String agrs[]){
        
        new Main_class();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            new AddEmployee();
            
        }
        
        else if(e.getSource() == view){
            new viewEmployee();
        }
        
        else if(e.getSource() == remove){
            new Remove();
        }
        
    }
}
