/**
 * @author Syed Khurshid
 * Future preference would tbe the textfield is checked as the input is made
 * Future preference would be to have a keypress event happing live instead of a enter key press
 * requirements
 * Instead of passing the id of the part selected. I shoudl send the part itself. This should speed faster
 */
package inventory.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import inventory.Inventory;
import inventory.Part;
import inventory.Product;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This is the main screen controller that is initialized when the Main App is started
 * THis is where we display the product inventory and part inventory
 */
public class MainScreenController implements Initializable {
    /**
     *Default constructor
     */
    public MainScreenController(){}
    /*
     * This is the main screen AnchorPane
     */
    @FXML
    private AnchorPane MainScreen;
    /*
     * This has Buttons Exit Button to end the Software, Adding Parts Button, Deleting Parts Button, Modifying the Parts Buttons, Deleting product Buttons, Modify Product Button and Adding Product Button
     */
    @FXML
    private Button mainExitButton, partAddButtonM, partDeleteButtonM, partModifyButtonM, prodDeleteButtonM, prodModifyButtonM, prodAddButtonM;
    /*
     * Labels for the main page Label, as well as the label of the Parts Table and Product Labels
     */
    @FXML
    private Label mainLabel, partLabelM, prodLabelM;
    /*
     * Panes for both the Part and Product Tables
     */
    @FXML
    private Pane partBorderM, prodtBorderM;
    /*
     * Parts ID Column for Parts Table View
     */
    @FXML
    private TableColumn<Part, Integer> partIdM;
    /*
     * Inventory or Stock of the Parts Table
     */
    @FXML
    private TableColumn<Part, Integer> partInventoryM;
    /*
     * Parts Name for the Parts Table View
     */
    @FXML
    private TableColumn<Part, String> partNameM;
    /*
     * Parts Price or Cost per unit column for the Table View
     */
    @FXML
    private TableColumn<Part, Double> partPrice;
    /*
     * Search field for the Parts Table View and Product Table View
     */
    @FXML
    private TextField partSearchButtonM, prodtSearchButtonM;
    /*
     * Parts Table View
     */
    @FXML
    private TableView<Part> partTableM;
    /*
     * Products Table View
     */
    @FXML
    private TableView<Product> partTableM1;
    /*
     * Products ID Column for the Product Table View
     */
    @FXML
    private TableColumn<Product, Integer> prodIDM;
    /*
     * Products Inventory or Stock Column for the Products Table View
     */
    @FXML
    private TableColumn<Product, Integer> prodInventoryM;
    /*
     * Product Names Column for the Products Table View
     */
    @FXML
    private TableColumn<Product, String> prodNameM;
    /*
     * Products Price or Cost per Unit for Products Table View
     */
    @FXML
    private TableColumn<Product, Double> prodPrice;
    
    /**
     * Closing the main app itself
     * @param event of the button press
     */
    @FXML
    public void onClosePress(ActionEvent event) {
        Stage stage = (Stage) mainExitButton.getScene().getWindow();
        stage.close();
    }
    
    /**
     * This is to lead to Adding Part and changing screen
     * @param event button press to add new parts
     * @throws IOException as the screen is not able to locate the error. It was rectified after correct file directory was created
     * 
     * Future preference would be to utilize a object that would hold the locations and using a function pull the locations based on the option selected in the
     * Preferably using a switch statements to perfom the locations change
     */
    @FXML
    public void onPartAddPress(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/AddPartScreen.fxml"));
        Stage stage = (Stage) partAddButtonM.getScene().getWindow();
        stage.setTitle("Add Parts");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    /**
     * Deleting the part selected from the Parts Table
     * @param event which is a button click to delete the part
     * Error found is the part is not deleting and no error being displayed
     * 
     * Future preference would be to utilize a object that would hold the locations and using a function pull the locations based on the option selected in the
     * Preferably using a switch statements to perfom the locations change
     */
    @FXML
    public void onPartDelPress(ActionEvent event) {        
          //To Check if the user has selected a line in the table        
        if (partTableM.getSelectionModel().getSelectedItem() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "This will clear out the part \n are you sure you want to continue?");
            Optional<ButtonType> result = alert.showAndWait();
             //Check if the button pressed is ok
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Part p = partTableM.getSelectionModel().getSelectedItem();
                Inventory.deletePart(p);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please select a Part to remove from the list");
            alert.showAndWait();
        }
    }
    
    /**
     * Changing and moving to the Modify Screen to modify the part selected
     * @param event which is when the Modify button is pressed
     * @throws IOException Button Action event not being able to find the location of the screen which was corrected
     * after the directory was correctly added.
      * Future preference would be to utilize an object that would hold the locations and using a function pull the
     * locations based on the option selected in the
     * Preferably using a switch statements to perform the locations change
     */
    @FXML
    public void onPartModPress(ActionEvent event) throws IOException {
        if (partTableM.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventory_master/ModifyPartScreen.fxml"));
            Parent root = loader.load();
            ModifyPartController mpc = loader.getController();
            Part p = partTableM.getSelectionModel().getSelectedItem();
            int id = p.getId() - 1;
            mpc.modPart(id);

            Stage stage = (Stage) partModifyButtonM.getScene().getWindow();
            stage.setTitle("Modify Part");
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please select a Part to Update from the list");
            alert.showAndWait();
        }

    }
    
    /**
     * Modifying a Product Selected from Table and redirect to the "Modify Product Screen"
     * @param event which is the modify button press in the main screen after selecting the product to modify
     * @throws IOException Button Action event where it could not find the file
     * 
     * Future preference would be to utilize an object that would hold the locations and using a function pull the
     * locations based on the option selected in the
     * Preferably using a switch statements to perform the locations change
     */
    @FXML
    public void onModProdPress(ActionEvent event) throws IOException {
        if (partTableM1.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventory_master/ModProduct.fxml"));
            Parent root = loader.load();
            ModProdController mpc = loader.getController();
            Product p = partTableM1.getSelectionModel().getSelectedItem();
            mpc.ModProduct(p);
            Stage stage = (Stage) partModifyButtonM.getScene().getWindow();
            stage.setTitle("Modify Part");
            stage.setScene(new Scene(root));
            stage.show();
        }
        else {
           Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please select a Product to Update from the list");
            alert.showAndWait(); 
        }
       }    
    
    /**
     * Going to add product screen
     * @param event which is from the button press to add Product
     * @throws IOException with the error due to location not found. Correctly addressed the issue with inputting the
     * correct location of the screen
     * 
      * Future preference would be to utilize a object that would hold the locations and using a function pull the locations based on the option selected in the
     * Preferably using a switch statements to perfom the locations change
     */
    @FXML
    public void onProdAddPress(ActionEvent event) throws IOException {
        System.out.println("Going to the add Product Form");
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/AddProdScreen.fxml"));
        Stage stage = (Stage) partAddButtonM.getScene().getWindow();
        stage.setTitle("Add Product");
        stage.setScene(new Scene(root));
        stage.show();
    }
     
     /**
     * Removing the Product when the selection of the product from the table is made
     * @param event Button press of the delete button
     * @throws java.lang.NullPointerException  for not finding the matching product if nothing is found
     * 
     * Future prefernece would be to have it connected to a database
     * Also for future use refactor the code to under one class for all the Button action events
     */
    @FXML
    public void onProdDeletePress(ActionEvent event) {
        Product selectedProduct = partTableM1.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "This will clear out the Product \n are you sure you want to continue?");
            Optional<ButtonType> result = alert.showAndWait();
            if (selectedProduct.getAllAssociatedParts().size() == 0) {
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    System.out.println("Here I am");
                    Inventory.deleteProduct(selectedProduct);

                }
            }
            else {                
                System.out.println(selectedProduct.getAllAssociatedParts());
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Warning Dialog");
                warning.setContentText("Product has an Associated Parts and Cannot be deleted");
                warning.showAndWait(); 
           }
        }
    }

/**
 * Searching parts using a keyboard event
 * @param event press event along with value from Selection
 * @throws IllegalArgumentException which is basically because the part cannot be found. it was rectified with a try and catch
 * 
 * Future preference would to be get the data from a database
 */
   public void searchingParts(KeyEvent event) {
        // Getting the string from the search
        if (event.getCode() == KeyCode.ENTER) {
            String q = partSearchButtonM.getText();
            ObservableList<Part> part = Inventory.lookupParts(q);         
            // if no result from searching by name, then searching by id
          try {
            if (part.size() == 0) {
             Part p = Inventory.lookupPart(Integer.parseInt(q));
                  if (p != null) {
                      part.add(p);
                      partTableM.setItems(part);
                  }                 
              } 
          } catch (Exception e) {
              return;
          }
              partTableM.setItems(part);
              partSearchButtonM.clear();
          }                    
    }
 
 /**
 * Searching parts using a keyboard event
 * @param event key press event along with value from Selection
 * @throws IllegalArgumentException which is because the individual product was not found and required a try catch to fix the error
 * 
 * Future preference would to be get the data from a database
 */
  public void searchingProducts(KeyEvent event) {
            if(event.getCode() == KeyCode.ENTER)
            {
                String q = prodtSearchButtonM.getText();
                ObservableList<Product> prod = Inventory.lookupProducts(q);
                // If no result, then search via ID
               try {
                 if(prod.size() == 0)
                {
                    Product p = Inventory.lookupProduct(Integer.parseInt(q));
                    if (p != null) {
                        prod.add(p);
                        partTableM1.setItems(prod);
                    }
                }
            } catch (Exception e) {
                return;
         }
         partTableM1.setItems(prod);
         prodtSearchButtonM.clear();
      }
    }     
    
    /**
     * Initializing the Main Screen Controller 
     * @param arg0 which is the URL package
     * @param arg1 which is the Resource Bundle Package
     * 
     * Future preference is to have one function that would take action. Possibly a switch statement taking action based on task requested
     * Future preference would be to have it connceted to a database
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Linking the search textfield with Function by KeyEvent
        partSearchButtonM.setOnKeyPressed(this::searchingParts);
        prodtSearchButtonM.setOnKeyPressed(this::searchingProducts);
   
        // Getting the data connected to the tableview of Parts
        partTableM.setItems(Inventory.getAllParts());
        partIdM.setCellValueFactory(new PropertyValueFactory<>("Id"));
        partNameM.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryM.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        // Getting the data connected to the Tableview of Products
        partTableM1.setItems(Inventory.getAllProducts());
        prodIDM.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodNameM.setCellValueFactory(new PropertyValueFactory<>("name"));
        prodInventoryM.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    }



   
}
