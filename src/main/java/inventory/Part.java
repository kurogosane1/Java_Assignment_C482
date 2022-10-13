/**
* Supplied class Part.java 
 *@author Syed Khurshid
 */

package inventory;
/**
 * This is the parts model
 * In the Inventory this is one of the Inventory items
 * Future preference would be to have them connected to a database
 */
public class Part {
    /**
     * The id of the part
     */
    private int id;
    /**
     * The name of the Part
     */
    private String name;
    /**
     * The price of the part
     */
    private double price;
    /**
     * The stock/Inventory level of the part
     */
    private int stock;
    /**
     * The minimum stock levels of the part
     */
    private int min;
    /**
     * The maximum stock levels of the part
     */
    private int max;

    /**
     *This is the Constructor of the parts instance
     *
     * @param id  this is the ID of the part
     * @param name  which is the Name of the Part Object
     * @param price  Parts price of the object
     * @param stock Parts stock level that is currently for the Part
     * @param max Inventory or stock level maximum that the Part can hold
     * @param min Inventory or stock level minimum that can be held
     */
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * This is the getter of the id of the Part
     * @return the id to get
     */
    public int getId() {
        return id;
    }

    /**
     * This is the setter of the id of the part
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This is the getter of the name of the part
     * @return the name to get
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter of the name of the part
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is the getter of the price of the part
     * @return the price to get
     */
    public double getPrice() {
        return price;
    }

    /**
     * This is the setter of the price of the part
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * This is the getter of the stock of the part
     * @return the stock to get
     */
    public int getStock() {
        return stock;
    }

    /**
     * This is the setter of the stock of the part
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * This is the getter of the minimum stock levels being asked to be return
     * @return the min to get
     */
    public int getMin() {
        return min;
    }

    /**
     * This is the minimum stock level setter
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * This is the getter of the max level of stock
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * This is the setter of the max level of stock
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }



    
}