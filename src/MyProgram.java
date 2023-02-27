import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.lang.NumberFormatException;

public class MyProgram
{
    public static void main(String[] args) throws IOException
    {
        //Analysis Data
        double CumulativeWeight = 0.0;
        double CumulativeIncome = 0.0;
        Horse LeastValuableHorse = new Horse("none",Double.MAX_VALUE,0,0,Integer.MAX_VALUE,Double.MAX_VALUE);
        Cow LeastValuableCow = new Cow("none",Double.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Double.MAX_VALUE);
        
        //Input
        Scanner FileReader = new Scanner(new File("src\\505t.txt"));
        String[] Hay = FileReader.nextLine().split(" ");
        String[] Corn = FileReader.nextLine().split(" ");
        String[][] Pens;
        Barn[] Barns;
        Animal[] Animals;
        int AnimalCount = 0;
        int PenCount = 0;
        while(FileReader.hasNext())
        {
            String[] FileRead = FileReader.nextLine().split(" ");
            switch(FileRead.length)
            {
                case 2:
                    PenCount++;
                    break;
                default:
                    AnimalCount++;
                    break;
            }
        }
        Animals = new Animal[AnimalCount];
        Barns = new Barn[PenCount];
        Pens = new String[PenCount][2];        
        FileReader = new Scanner(new File("src\\505t.txt"));
        FileReader.nextLine();
        FileReader.nextLine();
        for(int FilePosition = 3, PenPosition = 0, AnimalPosition = 0; FileReader.hasNext(); FilePosition++)
        {
            String[] FileRead =  FileReader.nextLine().split(" ");
            switch(FileRead.length)
            {
                case 2:
                    Barns[PenPosition] = new Barn(Integer.parseInt(Hay[0]),Double.parseDouble(Hay[1]),Integer.parseInt(Corn[0]),
                    Double.parseDouble(Corn[1]),Integer.parseInt(FileRead[0]),Integer.parseInt(FileRead[1]));PenPosition++;break;
                case 5:
                    Animals[AnimalPosition] = new Cow(FileRead[0],Double.parseDouble(FileRead[1]),Integer.parseInt(FileRead[2]),Integer.parseInt(FileRead[3]),
                    Double.parseDouble(FileRead[4])); Barns[0].addAnimal(Animals[AnimalPosition]); CumulativeWeight += ((Cow)Animals[AnimalPosition]).getWeight(); 
                    CumulativeIncome += (((Cow)Animals[AnimalPosition]).getCost(Barns[0].getHayCost(),Barns[0].getCornCobsCost())); if(((Cow)Animals[AnimalPosition]).getCost(Barns[0].getHayCost(),
                    Barns[0].getCornCobsCost()) < LeastValuableCow.getCost(Barns[0].getHayCost(),Barns[0].getCornCobsCost())) 
                    {LeastValuableCow = (Cow)Animals[AnimalPosition];} AnimalPosition++; break;
                case 6:
                    Animals[AnimalPosition] = new Horse(FileRead[0],Double.parseDouble(FileRead[1]),Integer.parseInt(FileRead[2]),Integer.parseInt(FileRead[3]),
                    Integer.parseInt(FileRead[4]),Double.parseDouble(FileRead[5])); Barns[1].addAnimal(Animals[AnimalPosition]); CumulativeWeight += ((Horse)Animals[AnimalPosition]).getWeight(); 
                    CumulativeIncome += (((Horse)Animals[AnimalPosition]).getCost(Barns[1].getHayCost(),Barns[1].getCornCobsCost())); 
                    if(((Horse)Animals[AnimalPosition]).getCost(Barns[1].getHayCost(),Barns[1].getCornCobsCost()) < LeastValuableHorse.getCost(Barns[1].getHayCost(),Barns[1].getCornCobsCost())) 
                    {LeastValuableHorse = (Horse)Animals[AnimalPosition];} AnimalPosition++; break;
            }
        }    
        
        for(int i = 0; i < Barns[1].Pen.length; i++)
            for(int j = 0; j < Barns[1].Pen[i].length; j++)
                System.out.println(((Barns[1].Pen)[i][j]));

        //Output
        System.out.println("DATA ANALYSIS RESULTS:");
        System.out.println("----------------------------");
        System.out.println("Cumulative Income: $" + CumulativeIncome);
        System.out.println("Cumulative Weight: " + CumulativeWeight + "lbs");
        System.out.println("Enough Food: " + (Barns[0].hasEnoughFood() && Barns[1].hasEnoughFood()));
        System.out.println("Least Profitable Cow: " + LeastValuableCow.getName() + " in Barn One, Row: " + Barns[0].searchAnimal(LeastValuableCow)[0] + ", Column: " + Barns[0].searchAnimal(LeastValuableCow)[1]);
        System.out.println("Least Profitable Horse: " + LeastValuableHorse.getName() + " in Barn Two, Row: " + Barns[1].searchAnimal(LeastValuableCow)[0] + ", Column: " + Barns[1].searchAnimal(LeastValuableCow)[1]);
    }
}
