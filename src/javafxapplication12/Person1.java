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
public abstract class Person1 {
   
    protected String username;
    protected String password;
    protected double points=0;
    protected String role;
   
   
    public String getUsername()
    {
        return username;
    }
   
    public String getPassword()
    {
        return password;
    }  
   
    public String getRole()
    {
        return role;
    }
}
