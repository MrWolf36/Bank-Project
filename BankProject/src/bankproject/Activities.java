/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankproject;
import Helper.DBConnection;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Kerem
 */
public class Activities {
    private int id;
    private String name;
    private String tcno;
    private int tutar;
    private int bakiye;
    
    private String activity;
    private String iban;
    DBConnection conn=new DBConnection();
    Connection con=conn.connDB();
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement pt=null;
     public Activities(){}
   public Activities( int id, String name, String tcno, int bakiye,int tutar,String activity,String iban) {
        this.id=id;
        this.name=name;
        this.tcno=tcno;
        this.bakiye=bakiye;
        this.tutar=tutar;
        this.iban=iban;
        this.activity = activity;
    }
  public ArrayList<Activities> actList(String tcno){
       ArrayList<Activities> list =new ArrayList<>();
            Activities obj;
        try {
           
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM activities WHERE tcno="+tcno);
            while(rs.next()){
                obj=new Activities(rs.getInt("id"),rs.getString("name"),rs.getString("tcno"),rs.getInt("tutar"),rs.getInt("bakiye"),rs.getString("activity"),rs.getString("iban"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      
  }
    public void AddActivity(String name,String tcno,int tutar,int bakiye,String activity,String iban){
        try {
            String query="INSERT INTO activities"+"(name,tcno,tutar,bakiye,activity,iban)"+"VALUES (?,?,?,?,?,?)";
            Connection con = conn.connDB();
            st=con.createStatement();
            pt=con.prepareStatement(query);
            pt.setString(1, name);
            pt.setString(2, tcno);
            pt.setInt(3, tutar);
            pt.setInt(4, bakiye);
            pt.setString(5, activity);
            pt.setString(6, iban);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    /**
     * @return the activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * @return the tutar
     */
    public int getTutar() {
        return tutar;
    }

    /**
     * @param tutar the tutar to set
     */
    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tcno
     */
    public String getTcno() {
        return tcno;
    }

    /**
     * @param tcno the tcno to set
     */
    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    /**
     * @return the bakiye
     */
    public int getBakiye() {
        return bakiye;
    }

    /**
     * @param bakiye the bakiye to set
     */
    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * @param iban the iban to set
     */
    public void setIban(String iban) {
        this.iban = iban;
    }
}
