/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author g14910he
 */
    public class User {   
    private String id;
    private String pass;
    
    public User(String id,String pass){
        this.id = id;
        this.pass = pass;
    }
    public String getId(){return id;}
    public String getPass(){return pass;}
}
