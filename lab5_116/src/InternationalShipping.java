public class InternationalShipping extends Shipment{

    public InternationalShipping(String trackingNo,String contentType, int weightKg,int distanceKm){
        super(trackingNo,contentType,weightKg,distanceKm);
    }
    @Override
    public double calculateFee(){
        if(getDistanceKm()<=800){
            return 30.0 + 40.0 + (0.15 * getDistanceKm())+ (3.0 * getWeightKg());
        }
        else{
            return 30.0 + 40.0 + (0.15 * getDistanceKm())+ (3.0 * getWeightKg()) + 35.0 ;
            }
        }
    }

