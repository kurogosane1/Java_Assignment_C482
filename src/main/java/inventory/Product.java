package inventory;
/**
 *@author Syed Khurshid
 * Future preference would be to have them connected to a database
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * This is the Product class that will be inherited by Inventory.
 * 
 * Future preference would be to have this connected to a database
*/
public class Product {
    /**
     * id of the product, stock levels of the product, Minimum and Maximum stock levels of the product
     */
    private int id, min, max, stock;
    /**
     * Name of the Product
     */
    private String name;
    /**
     * Price of the Product
    */
    private double price;
    /**
     * Associated Parts of the Product
     */
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    
     /**
     * Constructor for a new instance of a product
     *
     * @param id the ID for the product
     * @param name the name of the product
     * @param price the price of the product
     * @param stock the inventory level of the product
     * @param min the minimum level for the product
     * @param max the maximum level for the product
     */
     public Product(int id, String name, double price,int stock,int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    };

    
    /**
     * The setter for the id
     *
     * @param id The id of the product
     */
    public void setID(int id) {
        this.id = id;
    };

    
   /**
     * The setter for the name
     *
     * @param name The name of the product
     */
    public void setName(String name) {
        this.name = name;
    };

    
    /**
     * The setter for the price
     *
     * @param price The price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    };

    /**
     * The setter for the stock
     *
     * @param stock The inventory level of the product
     */
    public void setStock(int stock) {
        this.stock = stock;
    };

    
    /**
     * The setter for the min
     *
     * @param min The minimum level for the product
     */
    public void setMin(int min) {
        this.min = min;
    };

    
    /**
     * The setter for the max
     *
     * @param max The maximum level of the product
     */
    public void setMax(int max) {
        this.max = max;
    };

    
    /**
     * The getter for the id
     *
     * @return id of the product
     */
    public int getId() {
        return id;
    };

    
    /**
     * The getter for the name
     *
     * @return name of the product
     */
    public String getName() {
        return name;
    };
    
    
     /**
     * The getter for the price
     * @return price of the product
      */
    public double getPrice() {
        return price;
    };

    
    /**
     * The getter for the stock
     *
     * @return the stock of the product
     */
    public int getStock() {
        return stock;
    };

    
    /**
     * The getter for the min
     *
     * @return the min of the product
     */
    public int getMin() {
        return min;
    };

    
    /**
     * The getter for max
     *
     * @return the max of the product
     */
    public int getMax() {
        return max;
    };
    
    
    /**
     * Adds a part to the associated parts list for the product.
     *
     * @param part The part to add
     * 
     * Future preference would have them connected to a database
     */
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);

    };

    
      /**
      * Deletes a part from the associated parts list for the product.
      *
      * @param selectedAssociatedPart The part to delete
      * @return a boolean indicating status of part deletion
      * 
      * Future preference would have them connected to a database
      */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        if (associatedParts.contains(selectedAssociatedPart)) {
            associatedParts.remove(selectedAssociatedPart);
            return true;
        }
        else
            return false;
    }

    
    
    
    /** This is where we return all the assocated parts
     * @return Returns associated Parts
     * 
     * Future preference would have them connected to a database
     */
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
  
}
