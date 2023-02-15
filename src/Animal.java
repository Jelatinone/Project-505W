public class Animal
{
    private String Name;
    private double Weight;
    private int Hay;
    private int CornCobs;

    public Animal()
    {
        this.Name = "Animal";
        this.Weight = 10;
        this.Hay = 10;
        this.CornCobs = 10;
    }

    public Animal(String Name, double Weight, int Hay, int CornCobs)
    {
        this.Name = Name;
        this.Weight = Weight;
        this.Hay = Hay;
        this.CornCobs = CornCobs;
    }

    public String getName()
    {
        return Name;
    }

    public double getWeight()
    {
        return Weight;
    }

    public int getHay()
    {
        return Hay;
    }

    public int getCornCobs()
    {
        return CornCobs;
    }

    public void setName(String n)
    {
        Name = n;
    }

    public void setWeight(double w)
    {
        Weight = w;
    }

    public void setHay(int h)
    {
        Hay = h;
    }

    public void setCornCobs(int c)
    {
        CornCobs = c;
    }

    public double getMilk()
    {
        return 0.0;
    }

    public int getRides()
    {
        return 0;
    }

    public double getCost()
    {
        return 0.0;
    }
}
