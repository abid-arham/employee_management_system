
package employee.management.system;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class viewEmployee extends JFrame implements ActionListener{
    
    Choice choiceEMP;
    
    JTable table;
    
    JButton searchButton, update, print, back;
    
    
    viewEmployee(){
        
        
        getContentPane().setBackground(new Color(255,131, 122));
        
        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(20,20,200,20);
        
        
        add(search);
        
        choiceEMP = new Choice();
        choiceEMP.setBounds(220,20,200,20);
        add(choiceEMP);
        
        try{
            
            Conn c = new Conn();
            
            ResultSet resultset = c.statement.executeQuery("select * from employee");
            
            while(resultset.next()){
                choiceEMP.add(resultset.getString("eID"));
                
                
            }
            
        }
        catch(Exception t){
            t.printStackTrace();
        }
        
        table = new JTable();
        try{
            
            Conn c = new Conn();
            ResultSet resultset = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultset));
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(20,70,100,20);
        searchButton.addActionListener(this);
        add(searchButton);
        
        print = new JButton("Print");
        print.setBounds(150,70,100,20);
        print.addActionListener(this);
        add(print);
        
        
        update = new JButton("Update");
        update.setBounds(280,70,100,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(420,70,100,20);
        back.addActionListener(this);
        add(back);
        
        
        
        
        
        
        
        setSize(900, 700);
        setLayout(null);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        
        new viewEmployee();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == searchButton){
            String query = "select * from employee where eid = '"+choiceEMP.getSelectedItem()+"'";
            
            try{
                
                Conn c = new Conn();
                ResultSet resultset = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultset));
                
            }
            catch(Exception h){
                h.printStackTrace();
            }
        }
        
        else if(e.getSource() == print){
            try{
                
                table.print();
                
            }
            catch(Exception h){
                h.printStackTrace();
            }
            
        }
        
        else if(e.getSource() == update){
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        }
        
        else{
            setVisible(false);
            
        }
        
    }
    
}
