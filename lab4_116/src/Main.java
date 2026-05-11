public class Main {
    public static void main(String[] args) {

        Vehicle[] fleet= new Vehicle[3];

        fleet[0]= new Vehicle("35 CIM 768", 1000.0);
        fleet[1]=new Truck(30,"35 HGZ 01", 3000);
        fleet[2]=new HeavyDutyTruck("35 ABD 698",400,2,39);

        System.out.println(" ------ Fleet Rapor ------");

        for(Vehicle v : fleet){
            System.out.println("--------------");
            v.safetyCheck();
            System.out.println("rental cost for 5 day is: " + v.calculateRental(5));
        }
    }
}