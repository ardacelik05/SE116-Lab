public class ExpressShipping  extends Shipment{

    public ExpressShipping(String trackingNo,String contentType, int weightKg,int distanceKm){
        super(trackingNo,contentType,weightKg,distanceKm);
    }
    @Override
    public double calculateFee(){
        return 20.0 + 25.0 + (0.12 * getDistanceKm()) + (2.2 * getWeightKg());
    }
    public void ExpressNote(){
        System.out.println("cargo is express");
    }
}
