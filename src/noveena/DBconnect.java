/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package noveena;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sachindra
 */
public class DBconnect {
    public static Connection connect(){
        Connection con=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/noveena", "root", "");
            if (con!=null) {
                System.out.println("Connected");
                
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        return con;
    }
    
}
