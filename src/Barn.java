public class Barn 
{
    public int HayAvailable;
    public double HayCost;
    public int CornCobsAvailable;
    public double CornCobsCost;
    public Animal[][] Pen;
    
    /** Default Constructor */
    public Barn()
    {
        HayAvailable = Integer.MAX_VALUE;
        HayCost = Double.MAX_VALUE;
        CornCobsAvailable = Integer.MAX_VALUE;
        CornCobsCost = Double.MAX_VALUE;
        Pen = new Animal[1][1];
    }
    /**
     * Constructor.
     * @param Hay - The amount of hay available
     * @param HayCost - The cost of hay
     * @param CornCobs - The amount of corncobs available
     * @param CornCobsCost - The cost of corncobs
     * @param PenRow - Length of Pen
     * @param PenColumn - Width of Pen
     */
    public Barn(int Hay, double HayCost, int CornCobs, double CornCobsCost, int PenRow, int PenColumn)
    {
        HayAvailable = Hay;
        HayCost = HayCost;
        CornCobsAvailable = CornCobs;
        CornCobsCost = CornCobsCost;
        Pen = new Animal[PenRow][PenColumn];
    }
    
    /** @return Whether or not the barn has enough food for the animals in the pen */
    public boolean hasEnoughFood()
    {
        int HayTotal = 0;
        int CornCobTotal = 0;
        for(int i = 0; i < Pen.length; i++)
            for(int j = 0; j < Pen[i].length; j++)
                if(Pen[i][j] != null) {HayTotal += Pen[i][j].getHay(); CornCobTotal += Pen[i][j].getCornCobs();}
        return !(HayTotal > HayAvailable) && !(CornCobTotal > CornCobsAvailable);        
    }
    
    /** 
     * Search for and add an animal to a spot in the pen 
     * @param NewAnimal - The animal to be added to the pen
     */
    public void addAnimal(Animal NewAnimal)
    {
        boolean FoundSpot = false;
        for(int i = 0; i < Pen.length && FoundSpot == false; i++)
            for(int j = 0; j < Pen[i].length && FoundSpot == false; j++)
                if(Pen[i][j] != null && Pen[i][j] instanceof Animal) {Pen[i][j] = NewAnimal; FoundSpot = true;}
    }
    
    public int[] searchAnimal(Animal Search)
    {
        for(int i = 0; i < Pen.length; i++)
            for(int j = 0; j < Pen[i].length; j++)
                if(Pen[i][j] == Search) {return new int[]{i,j};}
        return null;
    }
    
    /**
     * Add an animal in provided spot assuming it is open
     * @param NewAnimal - The animal to be added to the pen
     * @param PenX - X position within the pen
     * @paran PenY - Y position within the pen
     */
    public void addAnimal(Animal NewAnimal, int PenX, int PenY)
    {if(Pen[PenY][PenX] != null) {Pen[PenY][PenX] = NewAnimal;}}
    
    /** @return The amount of hay the barn has */
    public int getHay() {return HayAvailable;}
    
    /** @return The cost of hay */
    public double getHayCost() {return HayCost;}
    
    /** @return The amount of corncobs the barn has */
    public int getCornCobs() {return CornCobsAvailable;}
    
    /** @return The cost of corncobs */
    public double getCornCobsCost() {return CornCobsCost;}
}
