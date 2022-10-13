/**
 * @author Syed Khurshid
 * Future preference would have this all connceted to a database
 */
package inventory;

/** 
 * Outsourced Model of an outsourced Part
 * Future preference would be to have this connected to a database
*/
public class Outsourced extends Part {
    /** 
     * The company name for the Outsourced Part
    */
    private String companyName;

    /**
     *Constructor for a new instanc ef the Outsourced Part
     * @param id the ID for the Outsourced part
     * @param name The name of the Outsourced part
     * @param price for the price of the outsourced part
     * @param stock the inventory/stock level of the outsourced part
     * @param min minimum level of stock that the outsourced part can have
     * @param max maximum level of stock that the outsourced part can have
     * @param companyName the company name of the outsourced part
     */  
   public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
       super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }
    
    /**
     * This sets the company name of the Outsourced part
     * 
     * @param companyName which is the name of the company name for getting the part
     * 
     * Future preference would have them connected to a database
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    
    /** 
     * This will return the company name of the part of the associated Parts
     * 
     * @return company name of the outsourced part
     * 
     * Future preference would have them connected to a database
     */
    public String getCompanyName() {
        return companyName;
    }
}
