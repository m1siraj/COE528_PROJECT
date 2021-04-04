/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

/**
 *
 * @author Abdulrehman
 */
public class Book1 {
   
    protected String name;
    protected double price;
   
   
   public Book1 (String name, double price){
        this.name = name;
        this.price= price;
    }
   
   public void setPrice (double price){
       this.price = price;
   }
   
   
   public double getPrice (){
       return price;
   }
   
   public void setName (String name){
       this.name = name;
   }
   
   public String getName (){
       return name;
   }
   
   public Book1 getBookStatus (Book1 book){
   
      if (book.name == null) {
          System.out.println ("Book is not available\n");  
      }  
      return book;
   }
   
   @Override
   public String toString(){
       return "Name: " + name + " Price : $" + price;
   }
}
