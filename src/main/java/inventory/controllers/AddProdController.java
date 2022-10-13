/**
 * @author Syed Khurshid
 * Future preference would tbe the textfield is checked as the input is made
 * Future preference would be to have the Save button disabled until all the information is verified and meets the
 * requirements
 * Future preference would be to have all the screen actions be located under one class
 */
package inventory.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import inventory.Inventory;
import inventory.Part;
import inventory.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
/**
 * This is the controller for the Add Products Screen
 * Product forms screen is generated
 * Here new products are added to the Inventory
 */
public class AddProdController implements Initializable {
    /**
     *Default constructor
     */
    public AddProdController(){}
    /*
     * Buttons for Adding Associate Parts, Cancel Button is for cancelling adding or modifying the parts or products, Removing Associate Parts from the Associated Table and finally the save button to save the Products
     */
    @FXML
    private Button AddAssocButton, CancelButton, RemoveAssocButton, SaveButton;
    /*
     * These are the Textfields for ID of the Product which is disabled, prodInvTF is for invetory/stock of products found, the Maximum inventory of products, Minumum Inventory of products, Price of the product and finally name of the product
     */
    @FXML
    private TextField prodIDTF, prodInvTF, prodMaxTF, prodMinTF, prodPriceTF, prodNameTF, searchTF;
    /*
     * These are the Labels for ID of the Product which is disabled, prodInvTF is for invetory/stock of products found, the Maximum inventory of products, Minumum Inventory of products, Price of the product and finally name of the product
     */
    @FXML
    private Label prodInvLabel, prodLabel, prodMaxLabel, prodMinLabel, prodNameLabel, prodPriceLabel, prodIDLabel;
    /*
     * Tableview of the Lists of Associated Parts 
     */
    @FXML
    private TableView<Part> AssociatedTable;
    /*
     * Table view of the Parts of the table
     */
    @FXML
    private TableView<Part> PartTable;
    /*
     * These are Table Columns for the Associated Parts ID, its Stock level. It then contains the columns for the Parts ID and Parts Stock levels
     */
    @FXML
    private TableColumn<Part, Integer> assIDColumn, assocInvColumn, partIDColumn, partInvColumn;
    /*
     * Parts name Table Column for Associated Parts Table
     */
    @FXML
    private TableColumn<Part, String> assocNameColumn;
    /*
     * Price column for the Associated Parts Table
     */
    @FXML
    private TableColumn<Part, Double> assocPriceColumn;
    /*
     * name of the part column for Parts Table
     */
    @FXML
    private TableColumn<Part, String> partNameColumn;
    /*
     * Price column for the Parts Table
     */
    @FXML
    private TableColumn<Part, Double> partPriceColumn;
    
    /*
     * Observable Parts list to hold all parts data
     */
    private ObservableList<Part> p = Inventory.getAllParts();
    /*
     * Observable Parts List for Associated Parts that will be part of the products
     */
    private ObservableList<Part> assocParts = FXCollections.observableArrayList();

    /**
     * Adding Product to the ObservableList
     * @throws java.lang.NullPointerException which did not result in any value being added
     * @throws java.util.ConcurrentModificationException Error found trying to modify existing form values
     * Errors resulted in No Product being saved
     * After part error was found, once alerted and cleared. The part was allowing duplicates to still happen.
     * It was resolved by having the function end by adding an end function and if statements
     */
    @FXML
    public void addButtonClick() {
         if(PartTable.getSelectionModel().getSelectedItem() != null)
         {
             Part selectedPart = PartTable.getSelectionModel().getSelectedItem();
             if (assocParts.size() == 0) {
                 assocParts.add(selectedPart);
                return;
             }
             else {
                for (Part p : assocParts) {
                 if (p.getId() == selectedPart.getId()) {
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Duplicate part");
                  alert.setContentText("Part already added. Please selected a new part");
                  alert.showAndWait();
                  return;
              } else {
                  assocParts.add(selectedPart);
                  return;                       
                }
            }
             }
        }
        else if (PartTable.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("No Value to add");
            alert.showAndWait();  
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please select a Part to add to Assocate");
            alert.showAndWait();  
        }
    }
    
    /**
     * Cancelling transaction and moving to Main Screen
     * @throws IOException errors as such not changing scenery
     * It was fixed by correctly mapping to the correct location which was previously incorrect
     * 
     * Future preference would be to have all the screen actions be located under one class
     */
    @FXML
    public void cancelButtonPress() throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
         Stage stage = (Stage) CancelButton.getScene().getWindow();
         stage.setTitle("Main Screen");
         stage.setScene(new Scene(root));
         stage.show(); 
    }
    
    /**
     * Remove associated Parts removed from Product created
     * @throws java.lang.NullPointerException not being able to find the Associated Part
     * This was resolved fxID was not provided before and was later added to match point to the correct field.
     * 
     * Future preference would be to have all the screen actions be located under one class
     */
    @FXML
    public void removeButtonClick() {
        if(AssociatedTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please select Associated Part to remove from the list");
            alert.showAndWait();
        }
        else {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will clear out the part \n are you sure you want to continue?");
          Optional<ButtonType> result = alert.showAndWait();
          if (result.isPresent() && result.get() == ButtonType.OK) {
              Part p = AssociatedTable.getSelectionModel().getSelectedItem();
              assocParts.remove(p);
          }  
        }
    }
    /**
     * This is to save the Parts we have selected to be associated with
     * @param event Action event to take text inputs and save them to the Parts to the Inventory
     *
     * @throws NumberFormatException which is either the format is not matching we are parsing
     * @throws IOException which is from FXML Loaded not moving to the Main Screen
     * Errors Found were either not saving
     * The screen was not changing
     * The Product input had errors but upon correcting the input, upon saving the product name would be considered a
     * duplicate. The error was resolved by ending the function with a null return
     */
    @FXML
    public void saveButtonPress(ActionEvent event) throws IOException {
        ObservableList<Product> allProducts = Inventory.getAllProducts();
        if (!prodNameTF.getText().isEmpty() && !prodInvTF.getText().isEmpty() && !prodMaxTF.getText().isEmpty() && !prodMinTF.getText().isEmpty()) {
            int id = allProducts.size() +1;
            try {
                String name = prodNameTF.getText();
                try {
                Integer stock = Integer.parseInt(prodInvTF.getText());
                try {
                    double price = Double.parseDouble(prodPriceTF.getText());
                    try {
                        int max = Integer.parseInt(prodMaxTF.getText());
                        int min = Integer.parseInt(prodMinTF.getText());
                        if (Integer.parseInt(prodMaxTF.getText()) > Integer.parseInt(prodMinTF.getText())) {
                            if (Integer.parseInt(prodMaxTF.getText()) > Integer.parseInt(prodInvTF.getText())
                                    && Integer.parseInt(prodMinTF.getText()) < Integer.parseInt(prodInvTF.getText())) {
                                Product newProduct = new Product(id, name, price, stock, min, max);
                                Inventory.addProduct(newProduct);
                                if (assocParts.size() != 0) {
                                    for (Part p : assocParts) {
                                        newProduct.addAssociatedPart(p);
                                        goBackToMain(event);
                                    }
                                }
                                goBackToMain(event);
                            } else {
                                displayError(7);
                                return;
                            }
                        } else {
                            displayError(11);
                            return;
                        }
                    } catch (NumberFormatException e) {
                        displayError(9);
                        return;
                    } catch (NullPointerException e) {
                        displayError(3);
                        return;
                    }
                } catch (NumberFormatException e) {
                    displayError(6);
                    return;
                } catch (NullPointerException e) {
                    displayError(2);
                    return;
                }
            } catch (NumberFormatException e) {
                displayError(8);
                return;
            } catch (NullPointerException e) {
                displayError(5);
                return;
            }    
            } catch (NumberFormatException e) {
                displayError(10);
                return;
            } catch (NullPointerException e) {
                displayError(1);
                return;
            }           
        }
        else {
            displayError(0);
            return;
        }
    }
    
    /**
     * Searching among the list of parts
     * @param event which is the key input
     * 
     * Future preference would be to have all the screen actions be located under one class
     */
    public void searchingParts(KeyEvent event) {
        String s = searchTF.getText();
        ObservableList<Part> part = Inventory.lookupParts(s);
        try {
            if (part.size() == 0) {
                Part p = Inventory.lookupPart(Integer.parseInt(s));
                if (p != null) {
                    part.add(p);
                    PartTable.setItems(part);
                }
            }
        } catch (Exception e) {
            return;
        }
        PartTable.setItems(part);
        searchTF.clear();
    }    
    
    /**
     * Returns to the Main Screen
     * @param event passed from parent method
     * @throws IOException From FXMLLoader
     * 
     * Future preference would be to have all the screen actions be located under one class
     */
        void goBackToMain(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
         Stage stage = (Stage) CancelButton.getScene().getWindow();
         stage.setTitle("Main Screen");
         System.out.println("This was cancelled");
         stage.setScene(new Scene(root));
         stage.show(); 
         
    }    
    
    /**
     * A simple error producing function which based on situation generates an error
     * @param alertNumber which is the integer to cause the alert
     * 
     * Future preference would be to have this function fall under a seperate class since it is utilized on other locations
     * 
     */
    public void displayError(int alertNumber) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        switch (alertNumber) {
            case 1:                
                alert.setTitle("Empty Product Name");
                alert.setContentText("You have not entered the Name of the Product");
                alert.showAndWait();
                break;
            case 2:               
                alert.setTitle("Empty Price");
                alert.setContentText("You have not entered the Price of the Product");
                alert.showAndWait();
                break;
            case 3:
                alert.setTitle("Empty Min or Max Values");
                alert.setContentText("You cannot leave Min or Max Values Blank");
                alert.showAndWait();
                break;
            case 4:
                alert.setTitle("Product Name Error");
                alert.setContentText("You cannot leave Product Name empty");
                alert.showAndWait();
                break;
            case 5:
                alert.setTitle("Inventory Empty error");
                alert.setContentText("Inventory or Stock cannot be left empty");
                alert.showAndWait();
                break;
            case 6:
                alert.setTitle("Price input error");
                alert.setContentText("Price has to be a double format");
                alert.showAndWait();
                break;
            case 7:
                alert.setTitle("Min and Max input");
                alert.setContentText("Inventory Stock cannot be lower or higher Min and Max Values. \n Please correct");
                alert.showAndWait();
                break;
            case 8:
                alert.setTitle("Inventory input error");
                alert.setContentText("Inventory has to be in a Integer format");
                alert.showAndWait();
                break;
            case 9:
                alert.setTitle("Min and Max Input error");
                alert.setContentText("Min and Max has to be in a integer format");
                alert.showAndWait();
                break;
            case 10:
                alert.setTitle("Product Name Error");
                alert.setContentText("Product Name has to be in a String Format");
                alert.showAndWait();
                break;
            case 11:
                alert.setTitle("Min and Max input");
                alert.setContentText("Min cannot be larger than Max inventory stock. \n Please correct");
                alert.showAndWait();
                break;
            default:
                alert.setTitle("No Values Input");
                alert.setContentText("Fields cannot be left blank when saving. Please input all the fields");
                alert.showAndWait();
                break;
      }  
    }
    
    /**
     * This is to initialize the Add Product Screen Controller
     * @param arg0 URL resource
     * @param arg1 Resource Bundle
     * 
     * Future preference would be to have this connected to a database
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        searchTF.setOnKeyPressed(this::searchingParts);
        
        partIDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        assIDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        assocNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        assocPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        assocInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        // Getting the parts to be visible on the columns       
        PartTable.setItems(p);
        AssociatedTable.setItems(assocParts);    
    }
}
