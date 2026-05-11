public class HeavyDutyTruck extends Truck {
    int axleCount;

    public HeavyDutyTruck(String licensePlate, double dailyRate, int axleCount,double cargoCapasity){
        super(cargoCapasity,licensePlate,dailyRate);
        this.axleCount=axleCount;
    }

    @Override
    public double calculateRental(int days){
        return super.calculateRental(days)+axleCount;
    }

}
