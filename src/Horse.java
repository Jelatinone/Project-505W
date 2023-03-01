/**
 * Horse animal class
 * @author Cody Washington
 */
public class Horse extends Animal
{
    //Instance Variables
    private int RidesGiven;
    private double CostPerRide;
    
    /** Default Constructor */
    public Horse() {super(); RidesGiven = 0; CostPerRide = 0.0;}
    
    /** Constructor
     * @param Name - The horse's name
     * @param Weight - The horse's weight
     * @param Hay - HayBales eaten per day
     * @param CornCobs - CornCobs eaten per day
     * @param RidesGiven - Rides given per day
     * @paran CostPerRide - Cost for each ride given
     */
    public Horse(String Name, double Weight, int Hay, int CornCobs, int RidesGiven, double CostPerRide)
    {super(Name,Weight,Hay,CornCobs); this.RidesGiven = RidesGiven; this.CostPerRide = CostPerRide;}
    
    /** Set the horse's number of rides per day */
    public void setRidesGiven(int RidesGiven) {this.RidesGiven = RidesGiven;}
    
    /** Set the horse's cost per ride */
    public void setCostPerRide(double CostPerRide) {this.CostPerRide = CostPerRide;}
    
    /** @return The number of rides the horse gives per day. */
    public int getRidesGiven() {return RidesGiven;}
    
    /** @return the cost of each ride the horse gives */
    public double getCostPerRide() {return CostPerRide;}
    
    /** 
     * @param HayCost - Cost of Hay feed
     * @param CornCobCost - Cost of CornCob feed
     * @return the horse's daily income 
     */
    public double getCost(double HayCost, double CornCobCost) 
    {return (RidesGiven *CostPerRide) - ((super.getHay() * HayCost) + (super.getCornCobs() * CornCobCost));}
    
}
