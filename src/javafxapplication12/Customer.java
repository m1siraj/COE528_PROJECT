/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ahmed
 */
public class Customer {
    private final SimpleStringProperty Username;
    private final SimpleStringProperty Password;
    private final SimpleStringProperty Points;
    
    public Customer(String UserName, String Password, String Points){
        this.Username = new SimpleStringProperty(UserName);
        this.Password = new SimpleStringProperty(Password);
        this.Points = new SimpleStringProperty(Points);
    }


    //Getters
    public String getUsername(){
        return Username.get();
    }
    public String getPassword(){
        return Password.get();
    }
    public String getPoints(){
        return Points.get();
    }
    
    //Setters
    public void setUsername(String username){
        Username.set(username);
    }
    public void setPassword(String password){
        Password.set(password);
    }
    public void setPoints(String points){
        Points.set(points);
    }

   // lfas;kfas
    @Override
    public String toString() {
        return ""+ getUsername()+" "+ getPassword()+" "+getPoints();
    }
    
}
//This is my line


