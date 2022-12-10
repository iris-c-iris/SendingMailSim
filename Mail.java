
/**
 * Initializes instance variables, setter & getter methods to be retrieved by Project1 class
 *
 * @author Iris Carrigg
 * @version 8/31/2022
 */
public class Mail
{
    // instance variables
    private String type;
    private String destination;
    private int units;
    private double postagePerUnit;

    /**
     * Constructor for objects of class Mail
     */
    public Mail()
    {
        // initialise instance variables
        this.type = "";
        this.destination = "";
        this.units = 0;
        this.postagePerUnit = 0.0;
        
        
    }

    //destination setter, String parameter, returns nothing
    public void setDestination(String dest)
    {
        this.destination = dest;
    }
    
    //unit quanity setter, int parameter, returns nothing
    public void setUnits(int howMany)
    {
        this.units = howMany;
    }
    
    //postage per unit setter, double parameter, returns nothing
    public void setPostagePerUnit(double stamps)
    {
        this.postagePerUnit = stamps;
    }
    
    //mail type setter, String parameter, returns nothing
    public void setType(String type)
    {
        this.type = type;
    }
    
    //destination getter, no parameter, returns String
    public String getDestination()
    {
        return this.destination;
    }
    
    //unit quantity getter, no parameter, returns int
    public int getUnits()
    {
        return this.units;
    }
    
    //postage per unit getter, no parameter, returns double
    public double getPostagePerUnit()
    {
        return this.postagePerUnit;
    }
    
    //mail type getter, no parameter, returns String
    public String getType()
    {
        return this.type;
    }


}
