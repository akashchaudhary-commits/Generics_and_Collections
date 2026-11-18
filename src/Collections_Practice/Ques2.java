package Collections_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle{
    private String Rno;
    private String model;
    private double baseRPD;

    Vehicle(String Rno, String model, double baseRPD)
    {
        this.Rno = Rno;
        this.model = model;
        this.baseRPD = baseRPD;
    }
    abstract double calculateRentalCost(int days);

    public String getRno()
    {
        return Rno;
    }
    public String getmodel()
    {
        return model;
    }
    public double getBaseRPD()
    {
        return baseRPD;
    }
}
class Car extends Vehicle{
    private int seatingCapacity;
    Car(String Rno, String model, double baseRPD, int seatingCapacity)
    {
        super(Rno, model, baseRPD);
        this.seatingCapacity = seatingCapacity;
    }
    @Override
    double calculateRentalCost(int days)
    {
        return ((getBaseRPD() * days) + (seatingCapacity*50.0));
    }
}
class Truck extends Vehicle{
    double loadCapacity;
    Truck(String Rno, String model, double baseRPD, double loadCapacity)
    {
        super(Rno, model, baseRPD);
        this.loadCapacity = loadCapacity;
    }
    @Override
    double calculateRentalCost(int days)
    {
        return ((getBaseRPD()*days) + (loadCapacity*150.0));
    }

}
class FleetManager{
    List<Vehicle> fleet = new ArrayList<>();
    public void addVehicle(Vehicle v)
    {
        fleet.add(v);
    }
    public void displayTotalRentCoat(int days)
    {
        double total = 0.0;
        for(Vehicle v : fleet)
        {
            total += v.calculateRentalCost(days);
        }
        System.out.printf("Total Rent cost for %d days is %.2f ", days, total);
    }
    public void filterByMinRate(double minRate)
    {
        for(Vehicle v: fleet)
        {
            if(v.getBaseRPD() >= minRate)
            {
                System.out.println(v.getRno());
            }
        }
    }

}
public class Ques2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vehicles: ");
        int N = sc.nextInt();
        FleetManager f = new FleetManager();
        for(int i=0;i<N;i++)
        {
            System.out.println("Enter vehicle type: ");
            String type = sc.next();
            System.out.println("Enter Registration no: ");
            String rno = sc.next();
            System.out.println("Enter Model: ");
            String model = sc.next();
            sc.nextLine();
            System.out.println("Enter Rate: ");
            double rate = sc.nextDouble();
            if(type.equalsIgnoreCase("Car"))
            {
                System.out.println("Enter no. of seats for car: ");
                int seats = sc.nextInt();
                f.addVehicle(new Car(rno, model, rate, seats));
            }
            else if(type.equalsIgnoreCase("Truck"))
            {
                System.out.println("Enter load capacity for truck: ");
                double capacity = sc.nextDouble();
                f.addVehicle(new Truck(rno, model, rate, capacity));
            }


        }
        System.out.println("Enter no. of days");
        int days = sc.nextInt();
        System.out.println("Enter the minRate: ");
        double minRate = sc.nextDouble();

        f.displayTotalRentCoat(days);
        f.filterByMinRate(minRate);


    }
}
