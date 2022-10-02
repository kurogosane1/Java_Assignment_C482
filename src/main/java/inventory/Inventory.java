package inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();

    
    public void addPart(Part newPart) {
        // adding new parts here
    }

    public void addProduct(Product newProduct) {
        // adding new Product here
    }

    public Product lookupProduct(int productID) {
        // return productID;
        Product result = allProducts.get(productID);
        return result;
    }

    public Part lookupPart(int productID) {
        Part result = allParts.get(productID);
        return result;
    };

    public ObservableList<Part> lookupPartName(String partName) {
        ObservableList<Part> result= FXCollections.observableArrayList();
        int temp = 
        result.add(allParts.contains(partName));
        return result;
    };

    public ObservableList<Product> lookupProductName(String productName) {
        ObservableList<Product> result = FXCollections.observableArrayList();
        int temp = Product.indexOf(productName);

        if (temp != -1) {
            result.add(allProducts.get(temp));
            return result;
        }
        return null;
    };

    public void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    };

    public void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    };

    public boolean deletePart(Part selectedPart) {
        return false;
    }

    public boolean deleteProduct(Product selectedProduct) {
        return false;
    }

    public ObservableList<Part> getAllParts() {
        return allParts;
    }

    public ObservableList<Product> getAllProduct() {
        return allProducts;
    }
}
