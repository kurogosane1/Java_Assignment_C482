package inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Part> filteredParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private ObservableList<Product> filteredProducts = FXCollections.observableArrayList();

    public void addPart(Part newPart) {
        allParts.add(newPart);
    };

    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    };

    public Part lookupPart(int partID)
    {
        Part result = allParts.get(partID);
        return result;
    }

    public Product lookupProduct(int productID)
    {
        Product result = allProducts.get(productID);
        return result;
    }

    public ObservableList<Part> getAllParts() {
        return allParts;
    }

    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }
    public ObservableList<Part> getFilteredParts() {
        return filteredParts;
    }

    public ObservableList<Product> getFilteredProducts() {
        return filteredProducts;
    }
    
    
    public ObservableList<Part> lookupParts(String partName) {
        if (!(getFilteredParts().isEmpty()))
            getFilteredParts().clear();
        for(Part part: getAllParts())
        {
            if (part.getName().contains(partName))
                getFilteredParts().add(part);
        }
        //  Incase we are not able to find anything from the search
        if (getFilteredParts().isEmpty())
        {
            return getAllParts();
        }
        return getFilteredParts();
            
    };

    public ObservableList<Product> lookupProducts(String productName) {
        if (!(getFilteredProducts().isEmpty()))
            getFilteredProducts().clear();
        for (Product p: getAllProducts())
        {
            if (p.getName().contains(productName))
                getFilteredProducts().add(p);
        }
        // This is incase we are not able to find anything from the search
        if (getFilteredProducts().isEmpty())
        {
            return getAllProducts();
        }
        return getFilteredProducts();
    };

    public void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    };
    
    public void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    };

    public boolean deletePart(Part selectedPart) {
        return  allParts.remove(selectedPart);
        }
    public boolean deleteProduct(Product selectedProd) {
        return allProducts.remove(selectedProd);
    } 
}
