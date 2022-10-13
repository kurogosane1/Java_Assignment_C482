package inventory;
/**
 * @author Syed Khurshid
 * Future preference would be to have this connected to a database
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This is the Model of the Inventory object that holds both the Parts and Products all together and is static in nature
 * Future preference is to have them connected to a database
 */
public class Inventory {
    /**
     *Default constructor
     */
    public Inventory(){}
    /**
     * Observable List of Array of Parts holding all the Parts including inHouse and Outsourced Parts
     */
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    /**
     * Observable List of Array of Products 
     */
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
  

    
    /** 
     * This is simply to add the new Part Object in the Parts List Array
     * 
     * @param newPart which is the Part Object
     * 
     * Future preference would be to have this connected to a database
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    };

    
    /** 
     * This is simply to add the new Product Object in the Products List Array
     * 
     * @param newProduct which is the new Product Object
     * 
     * Future preference would be to have this connected to a database
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    };

    
    /** 
     * This is to look up for the Part by its ID in the Parts List Array
     * 
     * @param partID ID of the Part being searched for
     * @return Part which is the Object found based on ID otherwise nothing is returned
     * 
     * Future preference would be to have this connected to a database
     */
    public static Part lookupPart(int partID)
    {
        ObservableList<Part> all = getAllParts();
        for(Part p : all)
        {
            if (p.getId() == partID) {
                return p;
            }
        }
        return null;
    }

    
    /** 
     * This is to look up for the Product by its ID in the Products List Array
     * 
     * @param productID ID of the Product being searched for
     * @return Product which is the Product Object found based on ID otherwise nothing is returned
     * 
     * Future preference would be to have this connected to a database
     */
    public static Product lookupProduct(int productID)
    {
        ObservableList<Product> all = getAllProducts();
        for (Product prod:all)
        {
            if (prod.getId() == productID) {
                return prod;
            }
        }
        return null;
    }

    
    /** 
     * This is the getter for the all the Parts of the
     * 
     * @return All the parts are returned from the ObservableList
     * 
     * Future preference would be to have this connected to a database
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    
    /** 
     * This is the getter for the all of the Products
     * 
     * @return All the Products are returned from the ObservableList
     * 
     * Future preference would be to have this connected to a database
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
       
    
    /** 
     * This is looking for a particular Part by its name
     * 
     * @param partName which is the name of the object being looked for in the ObservableList
     * @return Returns the Object that was being looked for by its name
     * 
     * Future preference would be to have this connected to a database
     */
    public static ObservableList<Part> lookupParts(String partName) {
        
        ObservableList<Part> namedParts = FXCollections.observableArrayList();
        ObservableList<Part> all = getAllParts();
        for (Part p : all) {
            if(p.getName().contains(partName))
            {
                namedParts.add(p);
            }
        }
            return namedParts;
    };
    
    /** 
     * This is loking for the Product by searching for its name
     * 
     * @param productName name of the product being looked for in the observableArrayList
     * @return Returns the product object being searched for by its name
     * 
     * Future preference would be to have this connected to a database
     */
    public static ObservableList<Product> lookupProducts(String productName) {
        ObservableList<Product> namedProduct = FXCollections.observableArrayList();
        ObservableList<Product> all = getAllProducts();
        for (Product prod : all) {
            if (prod.getName().contains(productName)) 
            {
                namedProduct.add(prod);
            }
        }
        return namedProduct;
    };

    
    /** 
     * This is updating the part by its index in the Parts ObservableList Array
     * 
     * @param index position of the part in the Part Object in the observableArrayList
     * @param selectedPart updated part information that is being replaced with the new one
     * 
     * Future preference would be to have this connected to a database
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    };
    
    
    /** 
     * This is updating the Product by its index in the Product ObservableList Array
     * 
     * @param index position of the product in the Product ObservableList Array
     * @param selectedProduct updated product information that is being replaced with the new one
     * 
     * Future preference would be to have this connected to a database
     */
    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    };

    
    /** 
     * This is deleting the Part being provided from the Part Observable List Array
     * 
     * @param selectedPart part that is being removed 
     * @return boolean that will return nothing if nothing is found or found and just delete the part if found
     * 
     * Future preference would be to have this connected to a database
     */
    public static boolean deletePart(Part selectedPart) {
        return  allParts.remove(selectedPart);
        }
    
    /** 
     * This is deleting the Product being provided from the Product ObservableList
     * 
     * @param selectedProd product to be removed
     * @return boolean that will return nothing if nothing is found or found and just removed the product Object
     * 
     * Future preference would be to have this connected to a database
     */
    public static boolean deleteProduct(Product selectedProd) {
        return allProducts.remove(selectedProd);
    } 
}
