package inventory.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;

public class AddFormController implements Initializable{
    
    @FXML
    private Label Inventory;

    @FXML
    private Button cancelPart;

    @FXML
    private TextField comapnyNameID;

    @FXML
    private Label compNameLabel;

    @FXML
    private TextField inventory;

    @FXML
    private TextField machineID;

    @FXML
    private TextField max;

    @FXML
    private Label maxLabel;

    @FXML
    private TextField min;

    @FXML
    private Label minLabel1;

    @FXML
    private TextField name;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField partID;

    @FXML
    private Label partLabel;

    @FXML
    private TextField price;

    @FXML
    private Label priceLabel;

    @FXML
    private Label priceLabel1;

    @FXML
    private RadioButton radioHouse;

    @FXML
    private RadioButton radioOuts;

    @FXML
    private Button savePartBut;

    @FXML
    void houseAction(ActionEvent event) {

    }

    @FXML
    void onCancelPress(ActionEvent event) {

    }

    @FXML
    void onSaveButtonPart(ActionEvent event) {

    }

    @FXML
    void outSelection(ActionEvent event) {

    }

    @FXML
    void setCompanyName(ActionEvent event) {

    }

    @FXML
    void setID(ActionEvent event) {

    }

    @FXML
    void setMachineID(ActionEvent event) {

    }

    @FXML
    void setMax(ActionEvent event) {

    }

    @FXML
    void setMin(ActionEvent event) {

    }

    @FXML
    void setName(ActionEvent event) {

    }

    @FXML
    void setPrice(ActionEvent event) {

    }

    @FXML
    void setStock(ActionEvent event) {

    }
    
    public void onCancelClick() throws IOException {
        System.out.println("Cencel button was pressed");
         Parent root = FXMLLoader.load(getClass().getResource("/inventory/MainScreen.fxml"));
         Stage stage = (Stage) cancelPart.getScene().getWindow();
         stage.setTitle("Main Screen");
         System.out.println("This was cancelled");
         stage.setScene(new Scene(root));
         stage.show();
    }
    /* (non-Javadoc)
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // System.out.println("I am initialized");
    }
}
