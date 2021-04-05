/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

public class CustomerCustomer extends Person1 {
   
 
   
    protected CustomerCustomer customerStatus;
   
    public CustomerCustomer(String username, String password){
       
        this.username = username;
        this.password = password;
    }
     
    public double getPoints ()
    {
        return points;
    }
   
   
    public double buyBook (customerBooks book) {
     
        double cost;
        cost = book.Bookprice;
        this.points = cost * 10;
        customerStatus.checkLevel();
   
        return cost;
   
    }
   
    public double redeemBuyBook (customerBooks book) {
   
        double cost;
        cost = book.Bookprice - (points * 0.01);
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