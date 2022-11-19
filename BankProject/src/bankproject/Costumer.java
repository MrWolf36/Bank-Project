/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankproject;

import Helper.DBConnection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kerem
 */
public class Costumer extends User{
    DBConnection conn=new DBConnection();
    Connection con=conn.connDB();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pt = null; 
    
    
    
    private boolean key=false;
    
    public Costumer(int id,String name,String tcno,String sifre,String iban,int bakiye)  {
            super(id,name,tcno,sifre,iban,bakiye);
            this.key=key;
            
         
}
    public Costumer(){}

 public ArrayList userList() throws SQLException{
       ArrayList<User> list =new ArrayList<>();
       User obj;
       String query="SELECT*FROM user";
        try {
            st=con.createStatement(); 
            rs=st.executeQuery(query);
            
            
            while(rs.next()){
          obj=new User(rs.getInt("id"),rs.getString("name"),rs.getString("tcno"),rs.getString("sifre"),rs.getString("iban"),rs.getInt("bakiye"));
          list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Costumer.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list;
      }
      
   public boolean addCostumer(String name,String tcno,String sifre,String iban,int bakiye){
       String query="INSERT INTO user "+ "(name,tcno,sifre,iban,bakiye )" + "VALUES" + "(?,?,?,?,?)";
        setKey(false);
        try {
            st=con.createStatement();
             pt=con.prepareStatement(query);
             pt.setString(1,name);
             pt.setString(2, tcno);
             pt.setString(3,sifre);
             pt.setString(4, iban);
             pt.setInt(5, bakiye);
             pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Costumer.class.getName()).log(Level.SEVERE, null, ex);
        }
      if(getKey()==true)
          return true;
      else
          return false;
   }
   public boolean delCostumer(int id){
       String query="DELETE from user WHERE id=?";
        setKey(false);
        try {
            st=con.createStatement();
            pt=con.prepareStatement(query);
            pt.setInt(1, id);
            pt.executeUpdate();
            setKey(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Costumer.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(getKey()==true)
       return true;
       else
           return false;
   }
   public boolean updateCostumer(int id,String name,String tcno,String sifre,String iban){
       String query="UPDATE user SET id=?,name=?,tcno=?,sifre=?,iban=?";
        try {
            st=con.createStatement();
            pt=con.prepareStatement(query);
            pt.setInt(1, id);
            pt.setString(2, name);
            pt.setString(3, tcno);
            pt.setString(4, sifre);
            pt.setString(5, iban);
            pt.executeUpdate();
            setKey(true);
        } catch (SQLException ex) {
            Logger.getLogger(Costumer.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(getKey()==true)
           return true;
       else
           return false;
   }
  

       
    
        
    
    
    

    /**
     * @return the key
     */
    public boolean getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(boolean key) {
        this.key = key;
    }
}

    /**
     * @return the tutar
     */
  