/**
 * @author Syed Khurshid
 * Future preference would have this all connceted to a database
 */
package inventory;

/** 
 * inHouse Model of an inHoused Parts
 * 
 * Future preference would be to have this connceted to a database and use one template instead of multiple
*/
public class inHouse extends Part {
    /** 
     * The Machine ID of the new inHouse Part
    */
    private int machineID;

    /** 
     * Constructor for the new inHouse instance 
     * 
     * @param id The ID of the new inHouse Part
     * @param name The name of the new inHouse Part
     * @param price The price of the new inHouse Part
     * @param stock The Inventory stock level of the new inHouse Part
     * @param max The Max level of stock or inventory the part can have
     * @param min The Minimum level of stock or inventory the part can have
     * @param machineID The Machine ID of the new inHouse Part
    */
   public inHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);
        this.machineID = machineID;
            }

        
        /** 
         * This is where we set the Machine ID to the Part
         * 
         * @param machineID sets the machine ID of the new in House Part
         */
        public void setMachineID(int machineID) {
            this.machineID = machineID;
        }
    
        
        /** 
         * This is to return the Machine ID of the selected Part
         * 
         * @return The machine id of the in House Part
         */
        public int getMachineID() {
            return machineID;
        }
    
}
