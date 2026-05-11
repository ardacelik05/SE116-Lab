public class Vehicle {
String licensePlate;
double dailyRate;

public Vehicle(String licensePlate, double dailyRate) {
this.licensePlate=licensePlate;
this.dailyRate=dailyRate;
    }


    public double calculateRental(int days){
    return days * dailyRate;
    }


public void safetyCheck(){
    System.out.println("Plate: " + licensePlate);
    System.out.println("Brakes and Lights are working");
    }
}

