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
public class BooksController implements Initializable {

    @FXML private TableView<Books> tableView;
    @FXML private TableColumn<Books, String> BooknameColumn;
    @FXML private TableColumn<Books, String> BookpriceColumn;
    
    //These instance variables are used to create new Person objects
    @FXML private TextField BooknameTextField;
    @FXML private TextField BookpriceTextField;

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
     * the book name of the book
     */
    public void changeUserNameCellEvent(CellEditEvent edittedCell)
    {
        Books bookSelected =  tableView.getSelectionModel().getSelectedItem();
        bookSelected.setBookname(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the owner to double click on a cell and update
     * the book price of the book
     */
    public void changePasswordCellEvent(CellEditEvent edittedCell)
    {
        Books bookSelected =  tableView.getSelectionModel().getSelectedItem();
        bookSelected.setBookprice(edittedCell.getNewValue().toString());
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
        BooknameColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("Bookname"));
        BookpriceColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("Bookprice"));
        
        //load dummy data
        tableView.setItems(getBooks());
        
        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        BooknameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        BookpriceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    
    /**
     * This method will create a new Book object and add it to the table. It also save the book
 information in Book text file.
     */
    public void AddButtonPushed()
    {
        ObservableList<Books> newBooks = tableView.getItems();
        newBooks.add(new Books(BooknameTextField.getText(),
            BookpriceTextField.getText()
        ));
        
        BooknameTextField.setText("");
        BookpriceTextField.setText("");
        
        //Save Book information in a Book.txt file
        
        FileWriter file_writer;
       try {
           file_writer = new FileWriter("Books.txt", true);
           BufferedWriter bw = new BufferedWriter(file_writer);
           for(Books books : newBooks){
               bw.write(books.toString());
               bw.newLine();
           }
           bw.close();
           

            }catch (IOException E) {
                System.out.print("Error is ");
            }
   
        
        
        //Get all the items from the table as a list, then add the new person to
        //the list
//        tableView.getItems().add(newCustomer);
        BooknameTextField.clear();
        BookpriceTextField.clear();
                
        
        
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
    
    
    
    public ObservableList<Books>  getBooks()
    {
        ObservableList<Books> book = FXCollections.observableArrayList();
        book.add(new Books("Frank","Sinatra"));
        book.add(new Books("John","Smith"));
        book.add(new Books("Ali","Hamza"));
        
        return book;
    }
}
    


