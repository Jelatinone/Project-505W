public class Horse extends Animal
{
    int RidesGiven;
    double CostRide;

    /** Constructor.
     * @param Name - Animal's name
     * @param Weight - Animal's weight
     * @param Hay - Animal's required hay per day
     * @param CornCobs - Animal's required corncobs per day
     * @param RidesGiven - Number of rides given
     * @param CostRide - Cost per ride given
     */
    public Horse(String Name, double Weight, int Hay, int CornCobs, int RidesGiven, double CostRide )
    {
        super(Name,Weight,Hay,CornCobs);
        this.RidesGiven = RidesGiven;
        this.CostRide = CostRide;
    }
    public Horse()
    {
        super();
        this.RidesGiven = 0;
        this.CostRide = 0.0;
    }
    public String getName()
    {
        return super.getName();
    }

    public double getWeight()
    {
        return super.getWeight();
    }

    public int getHay()
    {
        return super.getHay();
    }

    public int getCornCobs()
    {
        return super.getCornCobs();
    }

    public void setName(String n)
    {
        super.setName(n);
    }

    public void setWeight(double w)
    {
        super.setWeight(w);
    }

    public void setHay(int h)
    {
        super.setHay(h);
    }

    public void setCornCobs(int c)
    {
        super.setCornCobs(c);
    }

    public void setRides(int r)
    {
        RidesGiven = r;
    }

    public void setCostRide(double cr)
    {
        CostRide = cr;
    }

    public double getIncome(double HayCost, double CornCobsCost)
    {
        return (RidesGiven*CostRide) - ((super.getHay()*HayCost) + (super.getCornCobs()*CornCobsCost));
    }


    @Override
    public int getRides()
    {
        return RidesGiven;
    }

    @Override
    public double getCost()
    {
        return CostRide;
    }
}
