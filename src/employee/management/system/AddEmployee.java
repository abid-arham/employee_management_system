
package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField tname, tfathername, taddress, tphone, tnid, tsalary;
    
    JLabel teID;
    
    JButton addButton, goBackButton;
    
    JComboBox designationBox;
    JDateChooser tdob;
    
    Random ran = new Random();
    
    int id = ran.nextInt(999999);
    
    
    
    AddEmployee(){
        
        getContentPane().setBackground(new Color(163,255,188));
        
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        
        
        add(heading);
        
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(name);
        
        
        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);
        
        
        
        
        JLabel fathername = new JLabel("Father's Name");
        fathername.setBounds(400,150,200,30);
        fathername.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(fathername);
        
        
        tfathername = new JTextField();
        tfathername.setBounds(600,150,150,30);
        tfathername.setBackground(new Color(177,252,197));
        add(tfathername);
        
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(dob);
        
        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);
        
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,200,30);
        salary.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(salary);
        
        
        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);
        
        
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(address);
        
        
        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);
        
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(phone);
        
        
        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);
        
        
        JLabel nid = new JLabel("NID");
        nid.setBounds(400,300,200,30);
        nid.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(nid);
        
        
        tnid = new JTextField();
        tnid.setBounds(600,300,150,30);
        tnid.setBackground(new Color(177,252,197));
        add(tnid);
        
        
        
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,300,200,30);
        designation.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(designation);
        
        String items[] = {"Manager", "Executive", "Head Foreman", "Foreman"};
        designationBox = new JComboBox(items);
        designationBox.setBackground(new Color(177,252,197));
        designationBox.setBounds(200,300,150,30);
        add(designationBox);
        
        
        
        JLabel eID = new JLabel("Employee ID");
        eID.setBounds(50,350,200,30);
        eID.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(eID);
        
        
        teID = new JLabel(""+id);
        teID.setBounds(200,350,200,30);
        teID.setFont(new Font("sans_serif", Font.BOLD, 20));
        teID.setForeground(Color.RED);
        
        add(teID);
        
         
        
        addButton = new JButton("Add");
        addButton.setBounds(350,400,200,30);
        addButton.addActionListener(this);
        add(addButton);
        
        
        goBackButton = new JButton("Back");
        goBackButton.setBounds(350,450,200,30);
        goBackButton.addActionListener(this);
        add(goBackButton);
        
        
        
        
        
        
        
        
        
          
        
        
        
        
        setSize(900,700);
        setLayout(null);
        setLocation(250,50);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    
    public static void main(String args[]){
        
        new AddEmployee();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addButton){
            String name = tname.getText();
            String fathername = tfathername.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String nid = tnid.getText(); 
            String designation = (String) designationBox.getSelectedItem();
            String eID = teID.getText();
            
            
            try{
                
                Conn c = new Conn();
                String query = "insert into employee values('"+name+"','"+fathername+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+nid+"','"+designation+"','"+eID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details added Successfully");
                setVisible(false);
              
                
                
            }
            
            
            catch(Exception g) {
                g.printStackTrace();
                
            }
            
            
            
        }
        
        else if(e.getSource() == goBackButton){
            
            setVisible(false);
            
                    
                    
                    }
        
        
        
    }
    
}
