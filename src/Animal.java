public class Animal 
{
    String Name;
    double Weight;
    int Hay;
    int CornCobs;
    
    /** Default constructor */
    public Animal()
    {
        Name = "John Doe";
        Weight = Double.MAX_VALUE;
        Hay = Integer.MAX_VALUE;
        CornCobs = Integer.MAX_VALUE;
    }
    
    /** Constructor
     * @param Name - The animal's name
     * @param Weight - The animal's weight
     * @param Hay - HayBales eaten per day
     * @param CornCobs - CornCobs eaten per day
     */
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