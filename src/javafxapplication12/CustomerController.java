/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class CustomerController implements Initializable {

    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, String> UsernameColumn;
    @FXML private TableColumn<Book, String> PasswordColumn;
    @FXML private TableColumn<Book, String> PointsColumn;
    
    //These instance variables are used to create new Person objects
    @FXML private TextField UsernameTextField;
    @FXML private TextField PasswordTextField;
    @FXML private TextField PointsTextField;
    
    //When this method is called, it will change the scene to a Login view
    
    public void closeButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Bookstore App");
        window.show();
        
    }
    
    /**
     * This method will allow the owner to double click on a cell and update
     * the username of the customer
     */
    public void changeUserNameCellEvent(CellEditEvent edittedCell)
    {
        Book customerSelected =  tableView.getSelectionModel().getSelectedItem();
        customerSelected.setUsername(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the owner to double click on a cell and update
     * the username of the customer
     */
    public void changePasswordCellEvent(CellEditEvent edittedCell)
    {
        Book customerSelected =  tableView.getSelectionModel().getSelectedItem();
        customerSelected.setPassword(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the owner to double click on a cell and update
     * the username of the customer
     */
    public void changePointsCellEvent(CellEditEvent edittedCell)
    {
        Book customerSelected =  tableView.getSelectionModel().getSelectedItem();
        customerSelected.setPoints(edittedCell.getNewValue().toString());
    }
    
    
    
    
    
    public void BackButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("interface.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
//    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        UsernameColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("Username"));
        PasswordColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("Password"));
        PointsColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("Points"));
        
        //load dummy data
        tableView.setItems(getCustomer());
        
        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        UsernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PasswordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PointsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    
    /**
     * This method will create a new Book object and add it to the table. It also save the customer
 information in Customer text file.
     */
    public void AddButtonPushed()
    {
        ObservableList<Book> newCustomer = tableView.getItems();
        newCustomer.add(new Book(UsernameTextField.getText(),
            PasswordTextField.getText(),
            PointsTextField.getText()
        ));
        
        UsernameTextField.setText("");
        PasswordTextField.setText("");
        PointsTextField.setText("");
        
        //Save Book information in a Book.txt file
        
        FileWriter file_writer;
       try {
           file_writer = new FileWriter("Customer.txt", true);
           BufferedWriter bw = new BufferedWriter(file_writer);
           for(Book customers : newCustomer){
               //add while loop to see for duplicates
               //if else to 
               bw.write(customers.toString());
               bw.newLine();
           }
           bw.close();
           

            }catch (IOException E) {
                System.out.print("Error is ");
            }
   
        
        
        //Get all the items from the table as a list, then add the new person to
        //the list
//        tableView.getItems().add(newCustomer);
        UsernameTextField.clear();
        PasswordTextField.clear();
        PointsTextField.clear();
                
        
        
    }
    
    
    
    /**
     * This method will remove the selected row(s) from the table 
     */
    public void deleteButtonPushed()
    {
        
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
            
//        ObservableList<Customer> selectedRows, allCustomer;
//        allCustomer = tableView.getItems();
//        
//        //this gives us the rows that were selected
//        selectedRows = tableView.getSelectionModel().getSelectedItems();
//        
//        //loop over the selected rows and remove the Person objects from the table
//        for (Book customer: selectedRows)
//        {
//            allCustomer.remove(customer);
//        }
    }
    
    
    
    public ObservableList<Book>  getCustomer()
    {
        ObservableList<Book> owner = FXCollections.observableArrayList();
        owner.add(new Book("Frank","Sinatra","90"));
        owner.add(new Book("John","Smith","80"));
        owner.add(new Book("Ali","Hamza","20"));
        
        return owner;
    }
}
    
