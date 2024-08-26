
package employee.management.system;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;



public class Login extends JFrame implements ActionListener{
    
    JButton backButton = new JButton("Back");
    
    JButton loginButton = new JButton("Log in");
    
    JTextField userText = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20);
    JFrame frame = new JFrame();
    
    Login(){
        
        JPanel panel = new JPanel();
        
        

        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");

        userLabel.setBounds(40,20,100,30);
        panel.add(userLabel);

        
        userText.setBounds(150,20,150,30);

        panel.add(userText);


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40,70,100,30);
        panel.add(passwordLabel);
        

        
        passwordField.setBounds(150,70,150,30);
        panel.add(passwordField);


        
        loginButton.setBounds(150,140,150,30);
        loginButton.addActionListener(this);
        
        panel.add(loginButton);
        
        
        
        backButton.setBounds(150,180,150,30);
        backButton.addActionListener(this);
        
        panel.add(backButton);
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,1);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img = new JLabel(i33);
        
        img.setBounds(350,10,600,400);
        
        panel.add(img);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        image.setBounds(0,0,600,300);
        
        
        panel.add(image);



        frame.setVisible(true);
        frame.setLocation(400,200);
    }
    
    
    public static void main(String args[]){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == loginButton){
            
            try{
                
                String username = userText.getText();
                
                String password = passwordField.getText();
                
                Conn conn = new Conn();
                
                String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
                
                ResultSet resultset = conn.statement.executeQuery(query);
                
                if (resultset.next()){
                    frame.setVisible(false);
                    new Main_class().requestFocus();
                }
                else if (e.getSource() == backButton) {
            System.exit(90);
        }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
                
            }
            catch(Exception E){
                E.printStackTrace();
                
            }
            
            
            
            
        }
        
        else if(e.getSource() == backButton){
            
            System.exit(0);
        }
        
    
        }
    
}
