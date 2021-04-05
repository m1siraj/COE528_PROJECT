/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Abdulrehman
 */
public class CustomerStartScreenfinalController implements Initializable {
    
    @FXML private TableView<customerBooks> CustomertableView;
    @FXML private TableColumn<customerBooks, String> BookNameColumn;
    @FXML private TableColumn<customerBooks, String> BookPriceColumn;
    @FXML private TableColumn<customerBooks, String> selectCol;
    @FXML private Label welcomingLabel;
    
    public CustomerCustomer theCustomer;
    
    
    
    public void currentCustomer(CustomerCustomer theCustomer){
        
        this.theCustomer = theCustomer;       
        welcomingLabel.setText("Welcome " + theCustomer.getUsername() + ". You have: " + theCustomer.getPoints() + " points. Your status is: " + theCustomer.checkLevel());
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
        BookNameColumn.setCellValueFactory(new PropertyValueFactory<customerBooks, String>("Bookname"));
        BookPriceColumn.setCellValueFactory(new PropertyValueFactory<customerBooks, String>("Bookprice"));
        
        //Adding a select coloumn with checkboxes
        TableColumn selectCol = new TableColumn("Select");
        CustomertableView.getColumns().addAll(selectCol);
        selectCol.setCellValueFactory(new PropertyValueFactory<customerBooks, String>("Select"));
        
        //load dummy data
        CustomertableView.setItems(getBooks());
        
    } 
    
    public ObservableList <customerBooks>  getBooks()
    {
        ObservableList<customerBooks> book = FXCollections.observableArrayList();
        book.add(new customerBooks("Game of Thrones", 99.99));
        book.add(new customerBooks("The Walking Dead", 50.00));
        book.add(new customerBooks("Bones", 100.00));
        
        return book;
    }   
      
    
}


