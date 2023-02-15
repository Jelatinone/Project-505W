public class Cow extends Animal
{
    double Milk;

    /** Constructor. */
    public Cow()
    {
        super();
        this.Milk = 0.0;
    }

    /** Constructor.
     * @param Name - Animal's name
     * @param Weight - Animal's weight
     * @param Milk - Animal's milk
     * @param Hay - Animal's required hay per day
     * @param CornCobs - Animal's required corncobs per day
     */
    public Cow(String Name, double Weight, double Milk, int Hay, int CornCobs)
    {
        super(Name,Weight,Hay,CornCobs);
        this.Milk = Milk;
    }
    public String getName()
    {
        return super.getName();
    }

    public double getWeight()
    {
        return super.getWeight();
    }

    @Override
    public double getMilk()
    {
        return this.Milk;
    }

    public int getHay()
    {
        return super.getHay();
    }

    public int getCornCobs()
    {
        return super.getCornCobs();
    }

    public double getIncome(double HayCost, double CornCobsCost)
    {
        return (Milk*20) - ((super.getHay()*HayCost) + (super.getCornCobs()*CornCobsCost));
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

    public void setMilk(int m)
    {
        this.Milk = m;
    }
}
