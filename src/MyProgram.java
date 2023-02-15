import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args) throws IOException
    {
        //Analysis Data
        double CumulativeWeight = 0.0;
        double CumulativeIncome = 0.0;
        Horse LeastValuableHorse = new Horse("none",Double.MAX_VALUE,0,0,Integer.MAX_VALUE,Double.MAX_VALUE);
        Cow LeastValuableCow = new Cow("none",Double.MAX_VALUE,Double.MAX_VALUE,0,0);

        //Input
        Scanner file = new Scanner(new File("src\\505t.txt"));
        String[] Hay = file.nextLine().split(" ");
        String[] Corn = file.nextLine().split(" ");
        int File_Length;
        int CountPens = 0;
        for(File_Length = 0; file.hasNext(); File_Length++)
        {
            String[] LineReadIn = file.nextLine().split(" ");
            if(Objects.equals(LineReadIn.length,2))
            {
                try
                {
                    Integer.parseInt(LineReadIn[0]);
                    Integer.parseInt(LineReadIn[1]);
                    CountPens++;
                }
                catch (NumberFormatException ignored) {}
            }
        }
        String[] Lines = new String[File_Length];
        String[][] Pens = new String[CountPens][2];
        Barn[] Barns = new Barn[CountPens];
        Animal[] Animals = new Animal[File_Length - CountPens];
        file = new Scanner(new File("src\\505t.txt"));
        file.nextLine();
        file.nextLine();
        //File Read
        for(int i = 0, Pen_Count = 0, Animal_Count = 0;file.hasNext();i++)
        {
            String[] LineReadIn = file.nextLine().split(" ");
            Lines[i] = String.join(" ",LineReadIn);
            switch(LineReadIn.length)
            {
                case 2:
                    Pens[Pen_Count] = LineReadIn;
                    Pen_Count++;
                    break;
                case 5:
                    Animals[Animal_Count] = new Cow(LineReadIn[0],Double.parseDouble(LineReadIn[1]),Double.parseDouble(LineReadIn[2]),Integer.parseInt(LineReadIn[3]),Integer.parseInt(LineReadIn[4]));
                    Animal_Count++;
                    CumulativeWeight += Animals[Animal_Count].getWeight();
                    break;
                case 6:
                    Animals[Animal_Count] = new Horse(LineReadIn[0],Double.parseDouble(LineReadIn[1]),Integer.parseInt(LineReadIn[2]),Integer.parseInt(LineReadIn[3]),Integer.parseInt(LineReadIn[4]),Double.parseDouble(LineReadIn[5]));
                    Animal_Count++;
                    CumulativeWeight += Animals[Animal_Count].getWeight();
                    break;
            }
            if(i == (File_Length-1))
            {
                System.out.println("X");
                for(int j = 0; j < Pens.length; j++)
                {
                    System.out.println("X");
                    Barns[j] = new Barn(Integer.parseInt(Hay[0]), Double.parseDouble(Hay[1]), Integer.parseInt(Corn[0]), Double.parseDouble(Corn[1]), Integer.parseInt(Pens[j][0]), Integer.parseInt(Pens[j][1]));
                }
                for(Animal animal: Animals)
                {
                    CumulativeWeight += animal.getWeight();
                    if(animal instanceof Cow CheckCow)
                    {
                        Barns[0].addAnimal(CheckCow);
                        if(CheckCow.getIncome(Barns[0].getHay_Cost(),Barns[0].getCornCobs_Cost()) < LeastValuableCow.getIncome(Barns[0].getHay_Cost(),Barns[0].getCornCobs_Cost()))
                        {
                            LeastValuableCow = CheckCow;
                            CumulativeIncome += CheckCow.getIncome(Barns[0].getHay_Cost(),Barns[0].getCornCobs_Cost());
                        }
                    }
                    else if(animal instanceof Horse CheckHorse)
                    {
                        Barns[1].addAnimal(CheckHorse);
                        if(CheckHorse.getIncome(Barns[1].getHay_Cost(),Barns[1].getCornCobs_Cost()) < LeastValuableCow.getIncome(Barns[1].getHay_Cost(),Barns[1].getCornCobs_Cost()))
                        {
                            LeastValuableHorse = CheckHorse;
                            CumulativeIncome += CheckHorse.getIncome(Barns[0].getHay_Cost(),Barns[0].getCornCobs_Cost());
                        }
                    }
                }
            }

            System.out.println("DATA ANALYSIS RESULTS:");
            System.out.println("----------------------------");
            System.out.println("Cumulative Income: " + CumulativeIncome);
            System.out.println("Cumulative Weight: " + CumulativeWeight);
            System.out.println("Enough Food: " + (Barns[0].hasEnoughFood() && Barns[1].hasEnoughFood()));
            System.out.println("Least Profitable Cow: " + Arrays.toString(Barns[0].searchPen(LeastValuableCow)));
            System.out.println("Least Profitable Horse: " + Arrays.toString(Barns[1].searchPen(LeastValuableHorse)));

        }
    }
}