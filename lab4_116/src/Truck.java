public class Truck extends Vehicle {
    double cargoCapasity;
    public Truck(double cargoCapasity, String licensePlate, double dailyRate){
        super(licensePlate,dailyRate);
        this.cargoCapasity=cargoCapasity;
    }

    @Override
    public void safetyCheck(){
        super.safetyCheck();
        if(cargoCapasity>=40){
            System.out.println("Cargo capasity exceeds limits!");
        }
        else{
            System.out.println("cargo security verified safe to go");
        }
    }
}
