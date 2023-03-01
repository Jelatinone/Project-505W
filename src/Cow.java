public class Cow extends Animal
{
    public double MilkProduced;
    
    /** Default Constructor */
    public Cow() {super(); MilkProduced = 0.0;}
    
    /** Constructor
     * @param Name - The cow's name
     * @param Weight - The cow's weight
     * @param Hay - HayBales eaten per day
     * @param CornCobs - CornCobs eaten per day
     * @param MilkProduced - The amount of milk produced
     */
     public Cow(String Name, double Weight, int Hay, int CornCobs, double MilkProduced)
     {super(Name,Weight,Hay,CornCobs); this.MilkProduced = MilkProduced;}
     
     /** Set cow's amount of milk produced. */
     public void setMilkProduced(double MilkProduced) {this.MilkProduced = MilkProduced;}
     
     /** @return the cow's amount of milk produced. */
     public double getMilk() {return MilkProduced;}
     
     /** @return the cow's income per day */
     public double getCost(double HayCost, double CornCobCost) 
     {return (MilkProduced * 0.20) - (super.getCornCobs() * CornCobCost);}
    
}
