/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @FXML private TableView<Customer> tableView;
    @FXML private TableColumn<Customer, String> UsernameColumn;
    @FXML private TableColumn<Customer, String> PasswordColumn;
    @FXML private TableColumn<Customer, String> PointsColumn;
    
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
        Customer customerSelected =  tableView.getSelectionModel().getSelectedItem();
        customerSelected.setPassword(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the owner to double click on a cell and update
     * the username of the customer
     */
    public void changePasswordCellEvent(CellEditEvent edittedCell)
    {
        Customer customerSelected =  tableView.getSelectionModel().getSelectedItem();
        customerSelected.setPassword(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the owner to double click on a cell and update
     * the username of the customer
     */
    public void changePointsCellEvent(CellEditEvent edittedCell)
    {
        Customer customerSelected =  tableView.getSelectionModel().getSelectedItem();
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
        UsernameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("Username"));
        PasswordColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("Password"));
        PointsColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("Points"));
        
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
        // check for null values
        // check for duplicate username
        // return eror for above checks

        Customer newRegistration = new Customer(UsernameTextField.getText(), PasswordTextField.getText(), "0");
        if(newRegistration.checkNull()) {// && !newRegistration.duplicate()) {
           // display error 
            // System.out.println("checkNull is true");
           
        } else {
            //check for duplicate
                //  return error} else{BookB
            // System.out.println("checkNull is false");
            ObservableList<Customer> newCustomer = tableView.getItems();
            newCustomer.add(newRegistration);   // Add new user to the grid


            

            // add user to the txt file for permanent storage        
            FileWriter file_writer;
            try {
                file_writer = new FileWriter("Customer.txt", true);
                BufferedWriter bw = new BufferedWriter(file_writer);
                bw.write(newRegistration.saveString());
                bw.newLine();
                bw.close();
            }catch (IOException E) {
                System.out.print("Error is ");
            }

            // clear user registation fields
            UsernameTextField.clear();
            PasswordTextField.clear();
            PointsTextField.clear();
            
        }
        
                
        
        
    }
    
    
    
    /**
     * This method will remove the selected row(s) from the table 
     */
    public void deleteButtonPushed()
    {
        
//        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
            
        ObservableList<Customer> selectedRows, allCustomer;
        allCustomer = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        System.out.println("selectedRows is " + selectedRows);
        selectedRows.forEach(allCustomer::remove);
        

        
        
        
        System.out.println("allCustomer is " + allCustomer);
    }
    
    
    
    public ObservableList<Customer>  getCustomer()
    {
        ObservableList<Customer> customer = FXCollections.observableArrayList();
            
        try {
            
            Scanner s = new Scanner(new File("Customer.txt"));
            ArrayList<String> customerList = new ArrayList<String>();
            while (s.hasNext())
            {
                customerList.add(s.nextLine());
                //parse each line and create an instance of customer
                String[] customerDetails;
                customerDetails = (customerList.get(customerList.size() - 1)).split(",");
                System.out.println("customerDetails is " + customerDetails[0] + customerDetails[1] + customerDetails[2]);
                Customer temp = new Customer (customerDetails[0], customerDetails[1], customerDetails[2]);
                customer.add(temp);
                //add the instance to customer
            }
            System.out.println(customerList);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }
}
    
