package employee.management.system;



import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;


public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfathername, taddress, tphone, tsalary;
    
    JLabel teID;
    
    JButton updateButton, goBackButton;
    
    String number;
    
    UpdateEmployee(String number){
        
        
        this.number = number;
        
        getContentPane().setBackground(new Color(163,255,188));
        
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        
        
        add(heading);
        
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(name);
        
        
        JLabel tname = new JLabel();
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
        
        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tname.setBackground(new Color(177,252,197));
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
        
        
        JLabel tnid = new JLabel();
        tnid.setBounds(600,300,150,30);
        tnid.setBackground(new Color(177,252,197));
        add(tnid);
        
        
        
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,300,200,30);
        designation.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(designation);
        
        
        JLabel tdesignation = new JLabel();
        tdesignation.setBounds(200,300,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);
        

        
        
        
        JLabel eID = new JLabel("Employee ID");
        eID.setBounds(50,350,200,30);
        eID.setFont(new Font("sans_serif", Font.BOLD, 20));
        add(eID);
        
        
        teID = new JLabel();
        teID.setBounds(200,350,200,30);
        teID.setFont(new Font("sans_serif", Font.BOLD, 20));
        teID.setForeground(Color.RED);
        
        add(teID);
        
        
        try{
            
            Conn c = new Conn();
            String query = "select * from employee where eID = '"+number+"'";
            ResultSet resultset = c.statement.executeQuery(query);
            while(resultset.next()){
                tname.setText(resultset.getString("name"));
                tfathername.setText(resultset.getString("fathername"));
                tdob.setText(resultset.getString("dob"));
                taddress.setText(resultset.getString("address"));
                tsalary.setText(resultset.getString("salary"));
                tphone.setText(resultset.getString("phone"));
                tnid.setText(resultset.getString("nid"));
                teID.setText(resultset.getString("eID"));
                tdesignation.setText(resultset.getString("designation"));
                
            }
            
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
         
        
        updateButton = new JButton("Update");
        updateButton.setBounds(350,400,200,30);
        updateButton.addActionListener(this);
        add(updateButton);
        
        
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
        
        new UpdateEmployee("");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateButton){
            String fathername = tfathername.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            
            
            try{
                Conn c = new Conn();
                String query = "update employee set fathername = '"+fathername+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"' where eID = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully!");
                setVisible(false);
                new Main_class();
                
            }
            catch(Exception j){
                j.printStackTrace();
            }
            
            
        }
        
        else{
            
            setVisible(false);
            new viewEmployee();
            
        }
        
    }
    
}
