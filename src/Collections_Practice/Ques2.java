package Collections_Practice;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Vehicle{
    protected String Rno;
    protected String model;
    protected double baseRPD;
    Vehicle(String Rno, String model, double baseRPD)
    {
        this.Rno = Rno;
        this.model = model;
        this.baseRPD = baseRPD;
    }
    abstract double calculateTotalCost(int days);

    public String getRno() {
        return Rno;
    }
    public String getModel() {
        return model;
    }
    public double getBaseRPD() {
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
    double calculateTotalCost(int days)
    {
        return (baseRPD * days) + (seatingCapacity * 50.0);
    }
}
class Truck extends Vehicle{
    private double loadCapacity;
    Truck(String Rno, String model, double baseRPD, double loadCapacity)
    {
        super(Rno, model, baseRPD);
        this.loadCapacity = loadCapacity;
    }
    @Override
    double calculateTotalCost(int days)
    {
        return (baseRPD * days) + (loadCapacity * 150.0);
    }
}
class FleetManager{
    ArrayList<Vehicle> list = new ArrayList<>();
    public void addVehicle(Vehicle v)
    {
        list.add(v);
    }
    public void displayTotalCost(int days)
    {
        double total = 0.0;
        for(Vehicle v: list)
        {
            total += v.calculateTotalCost(days);
        }
        System.out.println("Totals cost : " + total);
    }
}
public class Ques2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vehicles: ");
        int n = sc.nextInt();
        FleetManager f = new FleetManager();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the type of Vehicle: ");
            String type = sc.nextLine();
            System.out.println("Enter the Registration no.: ");
            String Rno = sc.nextLine();
            System.out.println("Enter the Model: ");
            String model = sc.nextLine();
            System.out.println("Enter the Base Rate Per day: ");
            double rate = sc.nextDouble();
            if(type.equalsIgnoreCase("Car"))
            {
                System.out.println("Enter the Seating Capacity");
                int seatingCapacity = sc.nextInt();
                f.addVehicle(new Car(Rno, model, rate, seatingCapacity));
            }
            else if(type.equalsIgnoreCase("Truck"))
            {
                System.out.println("Enter the Load Capacity");
                double loadCapacity = sc.nextDouble();
                f.addVehicle(new Truck(Rno, model, rate, loadCapacity));
            }

        }
        System.out.println("Enter the no of days");
        int days = sc.nextInt();
        f.displayTotalCost(days);

    }
}
