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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addProdFormController implements Initializable{
   
    
    @FXML
    private AnchorPane ProductAddPage;

    @FXML
    private Button buttonRemAsso, cancelProdBut, partAddAssoc, saveProdBut;


    @FXML
    private Label label, prodID;

    @FXML
    private TableColumn<?, ?> partID;

    @FXML
    private TableColumn<?, ?> partIDAssoc;

    @FXML
    private TableColumn<?, ?> partInv;

    @FXML
    private TableColumn<?, ?> partInvAssoc;

    @FXML
    private TableColumn<?, ?> partName;

    @FXML
    private TableColumn<?, ?> partNameAssoc;

    @FXML
    private TableColumn<?, ?> partPrice;

    @FXML
    private TableColumn<?, ?> partPriceAssoc;

    @FXML
    private TableView<?> partTable;

    @FXML
    private TableView<?> partTableAssoc;

    @FXML
    private TextField prodIDText;

    @FXML
    private Label prodInv;

    @FXML
    private TextField prodInvText;

    @FXML
    private Label prodMax;

    @FXML
    private TextField prodMaxText;

    @FXML
    private Label prodMin;

    @FXML
    private TextField prodMinTextF;

    @FXML
    private Label prodName;

    @FXML
    private TextField prodNameText;

    @FXML
    private Label prodPrice;

    @FXML
    private TextField prodPriceText;

    @FXML
    private TextField prodSearchText;

    @FXML
    void onCancelPress(ActionEvent event) throws IOException {
         System.out.println("Cencel button was pressed");
         Parent root = FXMLLoader.load(getClass().getResource("/inventory/MainScreen.fxml"));
         Stage stage = (Stage) cancelProdBut.getScene().getWindow();
         stage.setTitle("Main Screen");
         System.out.println("This was cancelled");
         stage.setScene(new Scene(root));
         stage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("This add Product Form");
        
    }
 
}
