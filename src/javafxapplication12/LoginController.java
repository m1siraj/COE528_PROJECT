/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
        
        
        
        //add while loop to allow the customers to login 
        
        
        
        
        
        
        
        
        
        
        
        if(usernameTextField.getText().equals("admin") && passwordPasswordField.getText().equals("pass")) {
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("interface.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
        
            //Stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Bookstore App");
            window.setScene(tableViewScene);
            window.show();
        }
//        } else if (usernameTextField.getText().equals("test") && passwordPasswordField.getText().equals("test")) {
//            
//            Parent tableViewParent = FXMLLoader.load(getClass().getResource("interface.fxml"));
//            Scene tableViewScene = new Scene(tableViewParent);
//        
//            //Stage info
//            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//            window.setTitle("Bookstore App");
//            window.setScene(tableViewScene);
//            window.show();
//        } 
        
        else {
            invalidLoginLabel.setText("Login Failed!");
        }
        
    }
        
        
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
