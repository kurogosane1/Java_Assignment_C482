/**
 * @author Syed Khurshid
 * Future preference would tbe the textfield is checked as the input is made
 * Future preference would be to have the Save button disabled until all the information is verified and meets the
 * requirements
 */
package inventory.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import inventory.Inventory;
import inventory.Outsourced;
import inventory.Part;
import inventory.inHouse;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This is the controller for the Add Parts Controller Form.
 * Here will add the new parts
 * Verifying input as we go
 * Uses default constructor
 */
public class AddPartController implements Initializable{
    /**
     *Default constructor
     */
    public AddPartController(){}
    /**
     * Label for the Add Part Label
     */
    @FXML
    private Label addLabelM;
    /**
     * Saving Button for Parts
     */
    @FXML
    private Button addSaveButton;
    /**
     * Toggling Grouping between 2 radio buttons
     */
    @FXML
    private ToggleGroup addToggle;
    /**
     * Button to Cancel Adding new Parts
     */
    @FXML
    private Button cancelButton;
    /**
     * Text Field for Parts Company Name
     */
    @FXML
    private TextField companyNameTF;
    /**
     * Stock or Inventory Text for Errors
     */
    @FXML
    private Text invErrorText;
    /**
     * Min or Max Text for Errors
     */
    @FXML
    private Text minErrorText;
    /**
     * Name is the Text for errors for Part Name
     */
    @FXML
    private Text nameErrorText;
    /**
     * Company Label Field
     */
    @FXML
    private Label partCompNameLabel;
    /**
     * TextField for Inventory or Stock of Parts
     */
    @FXML
    private TextField partInvAddTF;
    /**
     * TextField for Machine ID for Parts
     */
    @FXML
    private TextField partMachineIDTF;
    /**
     * TextField for Max inventory of Parts allowed
     */
    @FXML
    private TextField partMaxTF;
    /**
     * TextField for Min Inventory of Parts allowed
     */
    @FXML
    private TextField partMinTF;
    /**
     * TextField for Parts Name
     */
    @FXML
    private TextField partNameTF;
    /**
     * TextField for Price for Parts 
     */
    @FXML
    private TextField partPriceATF;
    /**
     * TextField for Errors found in the Price Text Field
     */
    @FXML
    private Text priceErrorText;
    /**
     * RadioButton for inHouse for Parts
     */
    @FXML
    private RadioButton radiobutton1;
    /**
     * RadioButton for Outsourced for Parts
     */
    @FXML
    private RadioButton radiobutton2;
    /**
     * This is the Machine label for the Machine Text Field
     */
    @FXML
    private Label machineLabel;
    
    /**
     * Button action to cancel adding any Parts and returning to Main Screen
     * @throws IOException which disables from going further
     * 
     * Future preference would be to have all the screen actions be located under one class
     */
    @FXML
    public void cancelButtonPress() throws IOException {
        System.out.println("Cencel button was pressed");
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.setTitle("Main Screen");
        System.out.println("This was cancelled");
        stage.setScene(new Scene(root));
        stage.show();
    }    
    
    /**
     * Action to return to the Main Screen
     * @throws IOException which does not proceed to the main screen
     * 
     * Future preference would be to have all the screen actions be located under one class
     */
    public void mainScreenReturn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.setTitle("Main Screen");
        System.out.println("This was cancelled");
        stage.setScene(new Scene(root));
        stage.show();
    }
    /**
     * Currently not needed
     * FOr Future purpose can be used to check input as the key is pressed
     * @param event actionable event with the press of the key
     */
    @FXML
    void compNameChangePr(ActionEvent event) {}
    /**
     * Currently not needed
     * For Future purpose becoming a Key Input press event instead of actionable for verifying
     * @param event actionable event with the button press
     */
    @FXML
    void maxChangePress(ActionEvent event) {}
    /**
     * Currently not needed
     * For Future purpose becoming a Key Input press event instead of actionable for verifying
     * @param event actionable event with the button press
     */
    @FXML
    void minChangePress(ActionEvent event) {}
    /**
     * Currently not needed
     *For Future purpose becoming a Key Input press event instead of actionable for verifying
     * @param event actionable event with the button press
     */
    @FXML
    void nameChangePress(ActionEvent event) {}
    /**
     * Currently not needed
     * For Future purpose becoming a Key Input press event instead of actionable for verifying
     * @param event actionable event with the button press
     */
    @FXML
    void priceChangePress(ActionEvent event) {}
    /**
     * Currently not needed
     * For Future purpose becoming a Key Input press event instead of actionable for verifying
     * @param event actionable event with the button press
     */
    @FXML
    void priceInvChange(ActionEvent event) {}
    /**
     * radiobutton press1 is for the inHouse button. Events based on the selection made
     * Company name label and text field are disabled and made invisible from the radiobutton1 press for inHouse
     * @param event which is the radiobutton inHouse Button press
     */
    @FXML
    public void radioPress1(ActionEvent event) {
        companyNameTF.setVisible(false);
        partCompNameLabel.setVisible(false);
        companyNameTF.setDisable(true);
        partCompNameLabel.setDisable(true);
        partMachineIDTF.setVisible(true);
        machineLabel.setVisible(true);
        partMachineIDTF.setDisable(false);
        machineLabel.setDisable(false);
    }
    
    /**
     * radiobutton press2 is for the Outsourced button. Events based on the selection made
     * Company name label and text field are enabled and made visible from the radiobutton2 press for inHouse
     * @param event which is the radiobutton Outsource Button press
     * 
     */
    @FXML
    public void radioPress2(ActionEvent event) {
        companyNameTF.setVisible(true);
        partCompNameLabel.setVisible(true);
        companyNameTF.setDisable(false);
        partCompNameLabel.setDisable(false);
        partMachineIDTF.setVisible(false);
        machineLabel.setVisible(false);
        partMachineIDTF.setDisable(true);
        machineLabel.setDisable(true);
    } 
    
    /**
     * This is to save the Parts we have
     * @param event Action event to take text inputs and save them to the Parts to the Inventory
     *
     * @throws NumberFormatException which is either the format is not matching we are parsing
     *
     * Errors Found were either not saving
     * The screen was not changing
     * The part was not being added with no errors
     * 
     * Future preference would be to have all the screen actions be located under one class
     * Future preference would have this checked individually based on key press instead of the press of the save button
     */
    @FXML
    public void saveButtonPress(ActionEvent event) {
        ObservableList<Part> parts = Inventory.getAllParts();
         int id = parts.size() + 1;
         if (!partPriceATF.getText().isEmpty() && !partInvAddTF.getText().isEmpty() && !partMaxTF.getText().isEmpty()
                 && !partMinTF.getText().isEmpty() && !partNameTF.getText().isEmpty()) {
                    try {
                    double price = Double.parseDouble(partPriceATF.getText());
                    try {
                        int stock = Integer.parseInt(partInvAddTF.getText());
                        try {
                            int max = Integer.parseInt(partMaxTF.getText());
                            int min = Integer.parseInt(partMinTF.getText());
                            if(Integer.parseInt(partMaxTF.getText())>Integer.parseInt(partMinTF.getText())){
                                if(Integer.parseInt(partMaxTF.getText())>Integer.parseInt(partInvAddTF.getText()) && Integer.parseInt(partMinTF.getText())<Integer.parseInt(partInvAddTF.getText())){
                                
                                    try {                               
                                            String name = partNameTF.getText();
                                            if (radiobutton1.isSelected()) {
                                                    int machID = Integer.parseInt(partMachineIDTF.getText());
                                                    Inventory.addPart(new inHouse(id-1, name, price, stock, min, max, machID));

                                                } else {
                                                    String compName = companyNameTF.getText();
                                                    Inventory.addPart(new Outsourced(id-1, name, price, stock, min, max, compName));
                                                }

                                                try {
                                                    mainScreenReturn();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                    
                                        
                                    } catch (NullPointerException e) {
                                        nameErrorText.setVisible(true);
                                        nameErrorText.setText("Name Cannot be left blank");
                                    } catch (NumberFormatException e) {
                                        nameErrorText.setVisible(true);
                                        nameErrorText.setText("Name has to a String");
                                    }

                                }
                                else {
                                    minErrorText.setVisible(true);
                                    minErrorText.setText(
                                            "Inventory is more or less than max or minimum \n Please make sure maximum is larger than inventory and minimum is greater than Inventory");
                                
                                }
                            } else {
                                minErrorText.setVisible(true);
                                minErrorText.setText("Max cannot be lower than Min. Please correct it");
                                return;
                            
                            }
                        } catch (NumberFormatException e) {
                            minErrorText.setVisible(true);
                            minErrorText.setText("Min should be in Integer format like 1 or 2.0");
                            return;                 
                        }
                        catch (NullPointerException e) {
                            minErrorText.setVisible(true);
                            minErrorText.setText("Min or Max cannot be left blank");
                            return;
                        }

                    } catch (NumberFormatException e) {
                        invErrorText.setVisible(true);
                        invErrorText.setText("Inventory needs to be a Integer");
                        return;
                    }
                    catch (NullPointerException e) {
                        invErrorText.setVisible(true);
                        invErrorText.setText("Inventory cannot be empty");
                        return;
                    }
                } catch (NumberFormatException e) {
                    priceErrorText.setVisible(true);
                    priceErrorText.setText("Price needs to be a double example 20.99 or 1.99");
                    return;
                } catch (NullPointerException e) {
                    priceErrorText.setVisible(true);
                    priceErrorText.setText("Price cannot be left blank, please enter a price");
                    return;
                }
            } else {
                nameErrorText.setVisible(true);
                invErrorText.setVisible(true);
                minErrorText.setVisible(true);
                priceErrorText.setVisible(true);
                nameErrorText.setText("Cannot be left Blank");
                invErrorText.setText("Inventory cannot be empty");
                minErrorText.setText("Min and Max stocks cannot be left empty");
                priceErrorText.setText("Price cannot be left blank");
         }
    }  
     /**
     * Initializing the Add Part Screen
      *
      * @param arg0 which is the URL or address
      * @param arg1 which is the screen resource bundle
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {}
}

