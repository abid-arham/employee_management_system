
package employee.management.system;

import java.sql.*;

public class Conn {
    
    Connection connection;
    Statement statement;
    
    
    public Conn(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "p@$$w#rd");
            statement = connection.createStatement();
            
            
            
            
            
        }
        
        catch(Exception e){
            
            e.printStackTrace();
            
        }
        
    }
    
    
    
    
}
