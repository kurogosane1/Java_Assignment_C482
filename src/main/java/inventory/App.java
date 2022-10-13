package inventory;

/**
 * @author Syed Khurshid
 * Inventory Management App that was built on JavaFX
 * Future preference would have this all connceted to a database
 * Also future can also include classes for the screen change
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
// import javafx.scene.Parent;

/**
 * Inventory Management App that was built on JavaFX
 * 
 */
public class App extends Application {
    private static Scene scene;   
    /**
     * This is where the app will start to look for when starting
     *
     * @param stage which is the Stage to develop the scene
     * @throws IOException when loading new scenery
     * 
     * Future preference is to have this connected to a database
     * Future preference would also to have all the screen actions be located in one class
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("MainScreen.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        
     }     
     
     /**
      * Main starting function of the entire Inventory project
      *
      * @param args This is the main function that will be the first to run in the entire app
      */
     public static void main(String[] args) {
        /* 
         * Adding fake data for initial method
        */
         Part part1 = new inHouse(1,"Motherboard",120.99,20,0,100,111);
         Part part2 = new inHouse(2, "SSD Storage", 220.22, 10, 1, 40,112);
         Part part3 = new inHouse(3, "Hard Drives", 67.99, 5, 0, 40,113);
         Part part4 = new inHouse(4, "GPU", 899.99, 12, 2, 20,114);
         Part part5 = new inHouse(5, "Power Supply", 120.1, 100, 1, 1000,115);
         Product prod1 = new Product(1,"Macbook Pro", 2999.99,20,0,100);
         Product prod2 = new Product(2,"Dell Desktops", 899.99,10,0,2000);
         Product prod3 = new Product(3, "Mac Pro", 10099.99, 10, 0, 15);
         
        /** Adding them into the List Array */
         Inventory.addPart(part1);
         Inventory.addPart(part2);
         Inventory.addPart(part3);
         Inventory.addPart(part4);
         Inventory.addPart(part5);
         Inventory.addProduct(prod1);
         Inventory.addProduct(prod2);
         Inventory.addProduct(prod3);

         launch();
     }


}
