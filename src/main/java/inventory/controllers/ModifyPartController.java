/**
 * @author Syed Khurshid
 * Future preference would tbe the textfield is checked as the input is made
 * Future preference would be to have the Save button disabled until all the information is verified and meets the
 * requirements
 * Future reference is the instead of passing the ID, will send the part itself
 * This should result in a faster loading time
 */
package inventory.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import inventory.Inventory;
import inventory.Outsourced;
import inventory.Part;
import inventory.inHouse;
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
 * This is the modify Part Controller for the Modify Screen
 * Information of the selected Part from the main screen is processed here
 * The updated Part information is added as a new part in the existing position of the Observable array list
 */
public class ModifyPartController implements Initializable {
    /**
     *Default constructor
     */
    public ModifyPartController(){}
    /**
     * ID used to store the index the of the part being modified 
     */
    int num = 0;
    /**
     * id Text Field of the Parts field
     */
    @FXML
    private TextField partIDTF;
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
     * Currently not needed
     * For Future purpose becoming a Key Input press event instead of actionable for verifying
     * @param event actionable event with the button press
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
     * For Future purpose becoming a Key Input press event instead of actionable for verifying
     * @param event actionable event with the button press
     */
    @FXML
    void nameChangePress(ActionEvent event) {}
    /**
     * 
     * @param event
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
     * This cancels the input and takes us back to the Main Screen
     * @throws IOException where the location was not found and was rectified by providing the correct location
     * 
     * Future preference is to have one function that would take action. Possibly a switch statement taking action based on task requested
     */
    @FXML
    public void cancelButtonPress() throws IOException {
        System.out.println("Cencel button was pressed");
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.setTitle("Main Screen");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    /**
     * This returns to the main screen after the Updated part is saved
     * 
     * @throws IOException This is due to incorrect location and was rectified
     * 
     * Future preference is to have one function that would take action. Possibly a switch statement taking action based on task requested
     */
    public void mainScreenReturn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_master/MainScreen.fxml"));
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.setTitle("Main Screen");
        stage.setScene(new Scene(root));
        stage.show();
    }
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
     * @throws Exception which is either the format is not matching we are parsing
     *
     * Errors Found were either not saving
     * The screen was not changing
     * The part was not being added with no errors
     * 
     * Future preference is for the lines to be automatically checked as the key is typed so that future checks can be done at real time and not on save
     */
    @FXML
    public void saveButtonPress(ActionEvent event) throws Exception {
        invErrorText.setVisible(true);
        minErrorText.setVisible(true);
        nameErrorText.setVisible(true);
        priceErrorText.setVisible(true);
        if (!partPriceATF.getText().isEmpty() && !partInvAddTF.getText().isEmpty() && !partMaxTF.getText().isEmpty()
                && !partMinTF.getText().isEmpty() && !partNameTF.getText().isEmpty()) {
                try {
                        int id = Integer.parseInt(partIDTF.getText());
                        String name = partNameTF.getText();
                        double price = Double.parseDouble(partPriceATF.getText());
                        try {
                            int stock = Integer.parseInt(partInvAddTF.getText());
                            try {
                                int max = Integer.parseInt(partMaxTF.getText());
                                int min = Integer.parseInt(partMinTF.getText());
                                if (Integer.parseInt(partMaxTF.getText()) > Integer.parseInt(partMinTF.getText()))
                                {
                                    if (Integer.parseInt(partMaxTF.getText()) > Integer.parseInt(partInvAddTF.getText())
                                            && Integer.parseInt(partMinTF.getText()) < Integer.parseInt(partInvAddTF.getText())) {
                                                
                                        if (radiobutton1.isSelected())
                                        {
                                            int machID = Integer.parseInt(partMachineIDTF.getText());
                                            Inventory.updatePart(id - 1, new inHouse(id, name, price, stock, min, max, machID));

                                        }
                                            String compName = companyNameTF.getText();
                                            Inventory.updatePart(id - 1, new Outsourced(id, name, price, stock, min, max, compName));

                                        try {
                                            mainScreenReturn();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    else {
                                    nameErrorText.setText(null);
                                    priceErrorText.setText(null);
                                    invErrorText.setText("Inventory can't be more than maximum stock");  
                                    minErrorText.setText(
                                                "Inventory is more or less than max or minimum \n Please make sure maximum is larger than inventory and minimum is greater than Inventory");
                                    return;
                                    }
                                } else {
                                    nameErrorText.setText(null);
                                    priceErrorText.setText(null);
                                    invErrorText.setText(null);
                                    minErrorText.setText("Max cannot be lower than Min. Please correct it");
                                    return;
                                }
                            } catch (NumberFormatException e) {
                                nameErrorText.setText(null);
                                priceErrorText.setText(null);
                                invErrorText.setText(null);
                                minErrorText.setText("Min should be in Integer format like 1 or 2.0");
                                return;    
                            } catch (NullPointerException e) {
                                nameErrorText.setText(null);
                                priceErrorText.setText(null);
                                invErrorText.setText(null);
                                minErrorText.setText("Min or Max cannot be left blank");
                                return;
                            }
                        } catch (NumberFormatException e) {
                            nameErrorText.setText(null);
                            minErrorText.setText(null);
                            priceErrorText.setText(null);
                            invErrorText.setText("Inventory needs to be a Integer");
                            return;
                        } catch (NullPointerException e) {
                            nameErrorText.setText(null);
                            minErrorText.setText(null);
                            priceErrorText.setText(null);
                            invErrorText.setText("Inventory cannot be empty");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        nameErrorText.setText(null);
                        minErrorText.setText(null);
                        invErrorText.setText(null);
                        priceErrorText.setText("Price needs to be a double example 20.99 or 1.99");
                        return;
                    } catch (NullPointerException e) {
                        nameErrorText.setText(null);
                        minErrorText.setText(null);
                        invErrorText.setText(null);
                        priceErrorText.setText("Price cannot be left blank, please enter a price");
                        return;
                }
        }
        else {
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
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("");

    }
    
    /**
     * This takes in the id sent from the main screen of the part selected and updates the textfields as well as redio buttons are disabled or enabled depending on selection
     * @param id of the Part selected in the main screen
     * 
     * @throws NullPointerException due to the ID not passing. The function added in main screen needed to have the function as well as passing the id.
     * Future preference would be to have the part passed instead of the ID itself and that should reduce the call back to get the information again
     */

    public void modPart(int id) {
        this.num = id;
        System.out.println(id);
        Part p = Inventory.lookupPart(id+1);
        if (p instanceof inHouse) {
            radiobutton2.setSelected(false);
            radiobutton1.setSelected(true);
            partMachineIDTF.setText(String.valueOf(((inHouse) p).getMachineID()));
            partNameTF.setText(((inHouse) p).getName());
            partMaxTF.setText(String.valueOf(((inHouse) p).getMax()));
            partMinTF.setText(String.valueOf(((inHouse) p).getMin()));
            partIDTF.setText(String.valueOf(((inHouse) p).getId()));
            partPriceATF.setText(String.valueOf(((inHouse) p).getPrice()));
            partInvAddTF.setText(String.valueOf(((inHouse) p).getStock()));
        }
        else {
            radiobutton2.setSelected(true);
            radiobutton1.setSelected(false);
            machineLabel.setVisible(false);
            partMachineIDTF.setVisible(false);
            partCompNameLabel.setVisible(true);
            companyNameTF.setVisible(true);
            partCompNameLabel.setDisable(false);
            companyNameTF.setDisable(false);
            companyNameTF.setText(String.valueOf(((Outsourced) p).getCompanyName()));
            partNameTF.setText(((Outsourced) p).getName());
            partMaxTF.setText(String.valueOf(((Outsourced) p).getMax()));
            partMinTF.setText(String.valueOf(((Outsourced) p).getMin()));
            partIDTF.setText(String.valueOf(((Outsourced) p).getId()));
            partPriceATF.setText(String.valueOf(((Outsourced) p).getPrice()));
            partInvAddTF.setText(String.valueOf(((Outsourced) p).getStock()));
        }
        

        

        
        
    }
}

