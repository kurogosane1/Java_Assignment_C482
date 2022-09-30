package inventory;

public class Outsourced extends Part{
    private String companyName;

    /*
     * Invoking contructor
     */

    /**
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param companyName
     */

   
   public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
       super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }
     
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
