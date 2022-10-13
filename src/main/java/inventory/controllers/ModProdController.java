/**
 * @author Syed Khurshid
 * This is to modify the product and leads to the Product Screen
 * Future preference would tbe the textfield is checked as the input is made
 * Future preference would be to have the Save button disabled until all the information is verified and meets the requirements
 * Future preference would also to have them connected to a database
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
 * This is the "Modify controller" for ModProd screen
 * Here the product is passed and modified
 */
public class ModProdController implements Initializable {
    /**
     * Default constructor
     */
    public ModProdController(){}
    /** 
     * This is initialized Product
    */
    public Product prod;
    /** 
     * Observable List of array of parts to get all inventory parts
    */
    public ObservableList<Part> p = Inventory.getAllParts();
   
    /*
     * Buttons for Adding Associate Parts, Cancel Button is for cancelling adding or modifying the parts or products, Removing Associate Parts from the Associated Table and finally the save button to save the Products
     */
     @FXML
     private Button AddAssocButton, CancelButton, RemoveAssocButton, SaveButton;
    /*
     * These are the Textfields for ID of the Product which is disabled, prodInvTF is for invetory/stock of products found, the Maximum inventory of products, Minumum Inventory of products, Price of the product and finally name of the product
     */
     @FXML
     private Label prodIDLabel, prodInvLabel, prodLabel, prodMaxLabel, prodMinLabel, prodNameLabel, prodPriceLabel;
    /*
     * These are the Labels for ID of the Product which is disabled, prodInvTF is for invetory/stock of products found, the Maximum inventory of products, Minumum Inventory of products, Price of the product and finally name of the product
     */
    @FXML
    private TextField prodIDTF, prodInvTF, prodMaxTF, prodMinTF, prodNameTF, prodPriceTF, searchTF;
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
    /**
     * Table Column for the Associated ID 
     */
    @FXML
    private TableColumn<Part, Integer> assIDColumn;
    /**
     * Table Column for Associated Part Stock
     */
    @FXML
    private TableColumn<Part, Integer> assocInvColumn;
    /**
     * Table Column for the associated name stock
     */
    @FXML
    private TableColumn<Part, String> assocNameColumn;
    /**
     * Table Column for the associated parts price .
     */
    @FXML
    private TableColumn<Part, Double> assocPriceColumn;
    /**
     * Table Column for the parts ID
     */
    @FXML
    private TableColumn<Part, Integer> partIDColumn;
    /**
     * Table Column for the parts stock Column
     */
    @FXML
    private TableColumn<Part, Integer> partInvColumn;
    /**
     * Table column for the name of the parts 
     */
    @FXML
    private TableColumn<Part, String> partNameColumn;
     /*
     * Observable Parts List for Associated Parts that will be part of the products
     */
    @FXML
    private TableColumn<Part, Double> partPriceColumn;
    /**
     * This is the associated parts list 
     */
    private ObservableList<Part> assocParts = FXCollections.observableArrayList();
    /**
     * Adding Product to the ObservableList
     * @param event from the save button press to add Products
     * @throws java.lang.NullPointerException which did not result in any value being added
     * @throws java.util.ConcurrentModificationException Error found trying to modify existing form values
     * Errors resulted in No Product being saved
     * After part error was found, once alerted and cleared. The part was allowing duplicates to still happen.
     * It was resolved by having the function end by adding an end function and if statements
     * Future enhancement would to
     * Future preference would tbe the textfield is checked as the input is made
     *  * Future preference would be to have the Save button disabled until all the information is verified and meets the
     *  * requirements
     */
    @FXML
    public void addButtonClick(ActionEvent event) {
        Part selectedPart = PartTable.getSelectionModel().getSelectedItem();
        if(selectedPart != null)
        {
            // assocParts.add(selectedPart);   
            if (assocParts.size() == 0) {
                assocParts.add(selectedPart);
                return;
            }
            else {
                for (Part p : assocParts) {
                    if (p.getName() == selectedPart.getName()) {
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                       alert.setTitle("Duplicate part");
                       alert.setContentText("Part already added. Please selected a new part");
                       alert.showAndWait();
                       return;    
                   } 
                assocParts.add(selectedPart);
                return;
                    
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
     * Future preference would have the screen locations or actions stored in a seperate class where they can be called upon to perform the action
     */
    @FXML
    public void cancelButtonPress() throws IOException {
        System.out.println("Cencel button was pressed");
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.setTitle("Main Screen");
        System.out.println("This was cancelled");
        stage.setScene(new Scene(root));
        stage.show();
    }    
    
    /**
     * Returns to the Main Screen
     * @throws IOException From FXMLLoader for not being able to load the screen. 
     * 
     * Future preference would have the screen locations or actions stored in a seperate class where they can be called upon to perform the action
     */
    public void goBackToMain() throws IOException {
         System.out.println("Go Back Button was pressed");
         Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
         Stage stage = (Stage) CancelButton.getScene().getWindow();
         stage.setTitle("Main Screen");
         System.out.println("This was cancelled");
         stage.setScene(new Scene(root));
         stage.show();          
    }

     /**
     * Remove associated Parts removed from Product created
     * @param event are button action to remove the parts
     * @throws NullPointerException not being able to find the Associated Part
     * This was resolved fxID was not provided before and was later added to match point to the correct field.
     * 
     * Future preference would be to have the model connected to a database
     */
    @FXML
    public void removeButtonClick(ActionEvent event) {
        if (AssociatedTable.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please select Associated Part to remove from the list");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "This will clear out the part \n are you sure you want to continue?");
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
     * 
     * Future preference would tbe the textfield is checked as the input is made
     * Future preference would be to have the Save button disabled until all the information is verified and meets the requirements
     */
    @FXML
    public void saveButtonPress(ActionEvent event) throws IOException{
       int id = Integer.parseInt(prodIDTF.getText());
        try{
            String name = prodNameTF.getText();
            try {
                // Checking for price values
                double price = Double.parseDouble(prodPriceTF.getText());
                try {
                    System.out.println("Reached Max and Min Level");
                    //Checking for Min and Max
                    int max = Integer.parseInt(prodMaxTF.getText());
                    int min = Integer.parseInt(prodMinTF.getText());
                    if (Integer.parseInt(prodMaxTF.getText()) > Integer.parseInt(prodMinTF.getText())) {
                        try {
                            // Checking now with Inventory levels now

                            int stock = Integer.parseInt(prodInvTF.getText());
                            if (max > stock && stock > min) {

                                Product updatedProduct = new Product(id, name, price, stock, min, max);
                                Inventory.updateProduct(id - 1, updatedProduct);
                                if (assocParts.size() != 0) {
                                    for (Part p : assocParts) {
                                        updatedProduct.addAssociatedPart(p);
                                        goBackToMain();
                                    }
                                }
                                goBackToMain();
                            } else {
                                displayError(7);
                                return;
                            }
                        } catch (NullPointerException e) {
                            displayError(5);
                            return;
    
                        } catch (NumberFormatException e) {
                            displayError(8);
                            return;
                        }
                    } else {
                        displayError(11);
                        return;
                    }
                } catch (NullPointerException e) {
                    displayError(3);
                    return;
                } catch (NumberFormatException e) {
                    displayError(9);
                    return;
                }
            } catch (NullPointerException e) {
                displayError(2);
                return;
            } catch (NumberFormatException e) {
                displayError(6);
                return;
            }
            
       } catch (NullPointerException e) {
           // The only catch for String entry
           displayError(4);
           return;
       }
        
    }
    
    /**
     * Searching among the list of parts
     * @param event is a keypress event as the user inputs the values
     * 
     * Future preference would require to have them under the connected to a d
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
     * A simple error producing function
     * @param alertNumber which is the integer passed here
     * 
     * Future preference would be to have the alerts all under one class instead of having a seperate class.
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
                alert.setTitle("Inventory More than Max or Min");
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
     * This is to intialize the Modify Product Screen from the controller
     * @param arg0 coming the URL
     * @param arg1 Coming from the resource Bundle
     * 
     * Future preference would be to have them all connected to the database
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        // Getting the parts to be visible on the columns
        searchTF.setOnKeyPressed(this::searchingParts);
        
        PartTable.setItems(p);
        // AssociatedTable.setItems(prod.getAllAssociatedParts());
        partIDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        assIDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        assocNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        assocPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        assocInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }

    
    /** This is to update the fields of the product selected to be modified including associated parts
     * @param product is passed from the main screen for the values in the text field to filled for modification
     */
    public void ModProduct(Product product) {
        this.prod = product;
        System.out.println(product.getAllAssociatedParts());
        assocParts.addAll(prod.getAllAssociatedParts());
        prodIDTF.setText(String.valueOf(product.getId()));
        prodInvTF.setText(String.valueOf(product.getStock())); 
        prodMaxTF.setText(String.valueOf(product.getMax()));
        prodMinTF.setText(String.valueOf(product.getMin())); 
        prodNameTF.setText(product.getName()); 
        prodPriceTF.setText(String.valueOf(product.getPrice()));
        AssociatedTable.setItems(assocParts);      
    }
}