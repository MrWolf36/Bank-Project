/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kerem
 */
public class DBConnection {
    Connection c=null;
    String url="jdbc:mariadb://localhost:3325/bank?user=root&password=Kerem2015";
    
    public DBConnection(){}
    
    public Connection connDB(){
        try {
            this.c=DriverManager.getConnection(url);
            return c;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return c;
    }
    
}
