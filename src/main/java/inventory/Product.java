package inventory;

public class Product{
ObservableList<Part> associatedParts= FXCollections.ObservableArrayList();
int id;
String name;
double price;
int stock;
int min, max;

/** Construct*/
Product(int id, String name, double price, int stock, int min)
{
    this.id = id;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.min = min;
    this.max = max;
}

/* 
 * setters
*/

public void setId(int id){
    this.id = id;
}
public void setName(String name){
    this.name = name;
}
public void setPrice(double price){
    this.price = price;
}
public void setStock(int stock){
    this.stock = stock;
}
public void setMin(int min){
    this.min = min;
}
public void setMax(int max){
    this.max = max;
}

/*
 * Getters
 */
public id getId(){
    return id;
}
public String getName(){
    return name;
}
public double getPrice(){
    return price;
}
public int getStock(){
    return stock;
}
public int getMin(){
    return min;
}
public int min(){
    return max;
}
public void addAssociatedPart(Part part){

}
public boolean deleteAssociatedPart(Part selectedAssociatedPart){

}
public ObservableList<Part> getAllAssociatedPart(){
    return associatedParts;
}


};