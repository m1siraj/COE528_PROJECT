/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author ahmed
 */
public class LoginController implements Initializable {
    
    
    
    @FXML private Label invalidLoginLabel;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordPasswordField;

    
    //When this method is called, it will change the scene to a tableview example
    
    public void LoginButtonPushed(ActionEvent event) throws IOException {
        
        
        //Customer login
        
        //Arraylist to get all the lines of Customer.txt file and then split them to get username and password
        //compare username and password with the user input username and password
        
        Scanner s = new Scanner(new File("Customer.txt"));
        
        while (s.hasNext())
        {
            String[] line = s.nextLine().split(",");
            
            if(usernameTextField.getText().equals(line[0]) && passwordPasswordField.getText().equals(line[1])) {
                
                
                System.out.println("username: "+line[0]+" password: "+line[1]);
                
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("Customer_CustomerView.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
        
                //Stage info
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Bookstore App");
                window.setScene(tableViewScene);
                window.show();
                break;
            }
        }
        
        
        // admin login
       
        if(usernameTextField.getText().equals("admin") && passwordPasswordField.getText().equals("admin")) {
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("CustomerStartScreenfinal.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
        
            //Stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Bookstore App");
            window.setScene(tableViewScene);
            window.show();
        } 
        
        // display error username pasword not found
        
        else {
            invalidLoginLabel.setText("Login Failed!");
        }
        
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
