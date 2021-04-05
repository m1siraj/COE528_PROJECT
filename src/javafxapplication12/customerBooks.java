/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Abdulrehman
 */
public class customerBooks {
   
    protected final SimpleStringProperty Bookname;
    protected double Bookprice;
    private CheckBox select;
    
    public customerBooks(String Bookname, double Bookprice){
        
        this.Bookname = new SimpleStringProperty(Bookname);
        this.Bookprice = Bookprice;
        this.select = new CheckBox();
    }


    public String getBookname(){
        return Bookname.get();
    }
    public double getBookprice(){
        return Bookprice;
    }
    
    //Setters
    public void setBookname(String bookname){
        Bookname.set(bookname);
    }
    public void setBookprice(double bookprice){
       this.Bookprice = bookprice;
    
    }
    
    public customerBooks getBookStatus (customerBooks book){
   
      if (book.Bookname == null) {
          System.out.println ("Book is not available\n");  
      }  
      return book;
   }
       
    public CheckBox getSelect(){
        return select;
    }
    
    public void setSelect (CheckBox select){
        this.select = select;
    }
    
    @Override
    public String toString() {
        return ""+ getBookname()+" "+ getBookprice();
    }
}

