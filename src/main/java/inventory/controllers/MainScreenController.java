package inventory.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MainScreenController implements Initializable{
    
    @FXML
    private Button addPartsButtonM;

    @FXML
    private Button addProductsMain;

    @FXML
    private Button deletePartsButtonM;

    @FXML
    private Button deleteProdMain;

    @FXML
    private Button mainExit;

    @FXML
    private Button modifyPartsButtonM1;

    @FXML
    private Button modifyProdMain;

    @FXML
    private TableColumn<?, ?> partInvLevel;

    @FXML
    private TableColumn<?, ?> partPrice;

    @FXML
    private TextField partSearch;

    @FXML
    private TableColumn<?, ?> partsID;

    @FXML
    private TableColumn<?, ?> partsName;

    @FXML
    private TableView<?> partsTableM;

    @FXML
    private TableColumn<?, ?> prodInvLevel;

    @FXML
    private TableColumn<?, ?> prodPartID;

    @FXML
    private TableColumn<?, ?> prodPartName;

    @FXML
    private TableColumn<?, ?> prodPriceUnit;

    @FXML
    private TableView<?> prodTableM;

    @FXML
    private TextField productsSearch;

    // This will close the application
    public void onActionClick() {
        Stage stage = (Stage) mainExit.getScene().getWindow();
        stage.close();

    }
    // This will switch stage
    public void switchtoAddForm() throws IOException {
         System.out.println("This was clicked");
         Parent root = FXMLLoader.load(getClass().getResource("/inventory/AddPart.fxml"));
        //  System.out.println(getClass().getResource("/inventory/AddPart.fxml"));
         Stage stage = (Stage) addPartsButtonM.getScene().getWindow();
          stage.setTitle("Add Parts");
        // System.out.println("This was clicked " + root);
         stage.setScene(new Scene(root));
         stage.show();
        // App.setRoot("AddPart");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        System.out.println("The main screen has been intialized");

        // addPartsButtonM.onAction(this::switchtoAddForm);
        
    }

    
}
