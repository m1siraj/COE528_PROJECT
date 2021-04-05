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
public class Books {
    private final SimpleStringProperty Bookname;
    private final SimpleStringProperty Bookprice;
    
    public Books(String Bookname, String Bookprice){
        this.Bookname = new SimpleStringProperty(Bookname);
        this.Bookprice = new SimpleStringProperty(Bookprice);
    }


    //Getters
    public String getBookname(){
        return Bookname.get();
    }
    public String getBookprice(){
        return Bookprice.get();
    }
    
    //Setters
    public void setBookname(String bookname){
        Bookname.set(bookname);
    }
    public void setBookprice(String bookprice){
        Bookprice.set(bookprice);
    }
    

    @Override
    public String toString() {
        return ""+ getBookname()+" "+ getBookprice();
    }
    
}