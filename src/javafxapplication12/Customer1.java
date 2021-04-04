/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

public class Customer1 extends Person1 {
   
 
   
    protected Customer1 customerStatus;
   
    public Customer1(String username, String password){
       
        this.username = username;
        this.password = password;
       
        role = "Customer";
       
    }
     
    public double getPoints ()
    {
        return points;
    }
   
   
    public double buyBook (Book1 book) {
     
        double cost;
        cost = book.price;
        this.points = cost * 10;
        customerStatus.checkLevel();
   
        return cost;
   
    }
   
    public double redeemBuyBook (Book1 book) {
   
        double cost;
        cost = book.price - (points * 0.01);
        this.points = cost * 10;
        customerStatus.checkLevel();
   
        return cost;

    }
   
    public String checkLevel()  
    {
        if (this.points < 1000) {
            return "Silver";
        } else {          
             return "Gold";
        }
   
    }
   
    @Override
   public String getUsername(){
        return username;
    }
   
    public void setUsername(String username){
        this.username = username;
    }
   
    @Override
    public String getPassword(){
        return password;
    }
   
    public void setPassword(String password){
        this.password = password;
    }

}