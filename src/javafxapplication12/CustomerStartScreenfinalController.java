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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author Abdulrehman
 */
public class CustomerStartScreenfinalController implements Initializable {
    
    @FXML private TableView<Book1> CustomertableView;
    @FXML private TableColumn<Book1, String> BookNameColumn;
    @FXML private TableColumn<Book1, String> BookPriceColumn;
    @FXML private TableColumn<Book1, String> SelectionColumn;
    @FXML private Label welcomingLabel;
    @FXML private TextArea textarea;
    
    private Customer1 theCustomer = null;
    
    
    
    public void currentCustomer(/*Customer1 theCustomer*/){
        
        //Testing label
        String labeltesting = "Testing";
        welcomingLabel.setText(labeltesting);
        
//        this.theCustomer = theCustomer;
//        
//        welcomingLabel.setText("Welcome " + theCustomer.getUsername() + ". You have: " + theCustomer.getPoints() + " points. Your status is: " + theCustomer.checkLevel());
    }
    


    
    
    public void closeButtonPushed(ActionEvent event) throws IOException {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Bookstore App");
        window.show();    
    }
    
    public void LogoutButtonPushed(ActionEvent event) throws IOException {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("interface.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void buyButtonPushed(ActionEvent event) throws IOException {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("CustomerCostScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();   
    }
    
    public void redeemPointsAndBuyButtonPushed(ActionEvent event) throws IOException {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("CustomerCostScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();   
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      
    
}


