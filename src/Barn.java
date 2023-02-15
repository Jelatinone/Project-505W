import java.util.Objects;

public class Barn
{
    private final int Hay;
    private final double  Hay_Cost;
    private final int CornCobs;
    private final double  CornCobs_Cost;
    private final Animal[][] Pen;

    public Barn(int Hay, double Hay_Cost, int CornCobs, double CornCobs_Cost, int Rows, int Columns)
    {
        this.Hay = Hay;
        this.Hay_Cost = Hay_Cost;
        this.CornCobs = CornCobs;
        this.CornCobs_Cost = CornCobs_Cost;
        this.Pen = new Animal[Rows][Columns];
    }

    public void addAnimal(Animal New_Animal)
    {
        boolean FoundSpot = false;
        for(int i = 0; i < Pen.length && !FoundSpot; i++)
        {
            for(int j = 0; j < Pen[i].length && !FoundSpot; j++)
            {
                if(Objects.equals(Pen[i][j],null))
                {
                    Pen[i][j] = New_Animal;
                    FoundSpot = true;
                }
            }
        }
    }
    public int[] searchPen(Animal Searching)
    {
        for(int i = 0; i < Pen.length; i++)
            for(int j = 0; j < Pen[i].length; j++)
                if(Objects.equals(Pen[i][j],Searching))
                    return new int[] {i,j};
        return new int[] {-1,-1};
    }
    public Animal[][] getAnimalPen() {return Pen;}

    public boolean hasEnoughFood()
    {
        double R_CornCobs = 0;
        double R_Hay = 0;
        for(int i = 0; i < Pen.length; i++)
        {
            for (int j = 0; j < Pen[i].length; j++)
            {
                R_CornCobs -= Pen[i][j].getCornCobs();
                R_Hay -= Pen[i][j].getHay();
            }
        }
        return (R_CornCobs + CornCobs >= 0 && R_Hay + Hay >= 0);
    }
    public double getCornCobs_Cost() {
        return CornCobs_Cost;
    }

    public int getCornCobs() {
        return CornCobs;
    }

    public double getHay_Cost() {
        return Hay_Cost;
    }

    public int getHay() {
        return Hay;
    }

    //Possibly create a method to iterate through the matrix and produces calculations

}
