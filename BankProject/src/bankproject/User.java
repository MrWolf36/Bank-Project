/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankproject;

import Helper.DBConnection;

/**
 *
 * @author TURBOX
 */
public class User {
    DBConnection conn=new DBConnection();
    private int id;
    private String name;
    private String tcno;
    String sifre;
    private String iban;
    private int bakiye;
   

    //public User(){}
    public User(int id,String name,String tcno,String sifre,String iban,int bakiye){
        this.id=id;
        this.name=name;
        this.tcno=tcno;
        this.sifre=sifre;
        this.bakiye=bakiye;
        this.iban=iban;
    }
    public User(){};
    
    public String getTcno() {
        return tcno;
    }

    public void setName(String tcno) {
        this.setTcno(tcno);
    }

   
    public String getSifre() {
        return sifre;
    }

    
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param tcno the tcno to set
     */
    public void setTcno(String tcno) {
        this.tcno = tcno;
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
     * @return the balance
     */
  
}
