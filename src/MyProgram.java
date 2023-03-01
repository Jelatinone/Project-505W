import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/** 
 * <t>505W Animals, Cows, and Horses Oh My!</t>
 * <p>Repository - {@link www.github.com/Jelatinone/project505w}</p>
 * @author Jelatinone(CW)
 */
public class MyProgram
{
    public static void main(String[] args) throws IOException
    {
        //Analysis Data
        double CumulativeWeight = 0.0;
        double CumulativeIncome = 0.0;
        Horse LeastValuableHorse = new Horse("none",Double.MAX_VALUE,0,0,Integer.MAX_VALUE,Double.MAX_VALUE);
        Cow MostValuableCow = new Cow("none",Double.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Double.MIN_VALUE);
        int[] LVH_Position = new int[2];
        int[] MVC_Position = new int[2];
        
        //Input
        Scanner FileReader = new Scanner(new File("src\\505t.txt"));
        String[] Hay = FileReader.nextLine().split(" ");
        String[] Corn = FileReader.nextLine().split(" ");
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
        FileReader = new Scanner(new File("src\\505t.txt"));
        FileReader.nextLine();
        FileReader.nextLine();
        for(int FilePosition = 3, PenPosition = 0, AnimalPosition = 0; FileReader.hasNext(); FilePosition++)
        {
            String[] FileRead =  FileReader.nextLine().split(" ");
            switch(FileRead.length)
            {
                case 2:
                    Barns[PenPosition] = new Barn(Integer.parseInt(Hay[0]),Double.parseDouble(Hay[1]),Integer.parseInt(Corn[0]),Double.parseDouble(Corn[1]),Integer.parseInt(FileRead[0]),Integer.parseInt(FileRead[1]));
                    PenPosition++;break;
                case 5:
                    Animals[AnimalPosition] = new Cow(FileRead[0],Double.parseDouble(FileRead[1]),Integer.parseInt(FileRead[2]),Integer.parseInt(FileRead[3]),Double.parseDouble(FileRead[4]));
                    CumulativeIncome += (((Cow)Animals[AnimalPosition]).getCost(Barns[0].getHayCost(),Barns[0].getCornCobsCost())); CumulativeWeight += ((Cow)Animals[AnimalPosition]).getWeight();
                    if(((Cow)Animals[AnimalPosition]).getCost(Barns[0].getHayCost(),Barns[0].getCornCobsCost()) >= MostValuableCow.getCost(Barns[0].getHayCost(),Barns[0].getCornCobsCost()))
                    {MostValuableCow = (Cow)Animals[AnimalPosition];MVC_Position = Barns[0].addAnimal((Animal)MostValuableCow);}
                    else {Barns[0].addAnimal(Animals[AnimalPosition]);}AnimalPosition++;break;
                case 6:
                    Animals[AnimalPosition] = new Horse(FileRead[0],Double.parseDouble(FileRead[1]),Integer.parseInt(FileRead[2]),Integer.parseInt(FileRead[3]),Integer.parseInt(FileRead[4]),Double.parseDouble(FileRead[5])); 
                    CumulativeIncome += (((Horse)Animals[AnimalPosition]).getCost(Barns[1].getHayCost(),Barns[1].getCornCobsCost()));CumulativeWeight += ((Horse)Animals[AnimalPosition]).getWeight();
                    if(((Horse)Animals[AnimalPosition]).getCost(Barns[1].getHayCost(),Barns[1].getCornCobsCost()) <= LeastValuableHorse.getCost(Barns[1].getHayCost(),Barns[1].getCornCobsCost()))
                    {LeastValuableHorse = (Horse)Animals[AnimalPosition]; LVH_Position = Barns[1].addAnimal((Animal)LeastValuableHorse);}
                    else{Barns[1].addAnimal(Animals[AnimalPosition]);}AnimalPosition++;break;
            }
        }    

        //Output
        System.out.println("DATA ANALYSIS RESULTS:");
        System.out.println("----------------------------");
        System.out.println("Cumulative Income: $" + CumulativeIncome);
        System.out.println("Cumulative Weight: " + CumulativeWeight + "lbs");
        System.out.println("Enough Food: " + (Barns[0].hasEnoughFood()));
        System.out.println("Most Profitable Cow: " + MostValuableCow.getName() + " in Barn One, Row: " + MVC_Position[0] + ", Column: " + MVC_Position[1]);
        System.out.println("Least Profitable Horse: " + LeastValuableHorse.getName() + " in Barn Two, Row: " + LVH_Position[0] + ", Column: " + LVH_Position[1]);
    }
}
