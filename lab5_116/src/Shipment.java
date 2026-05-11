public class Shipment{
    private String trackingNo;
    private String contentType;
    private int weightKg;
    private int distanceKm;

    public Shipment(String trackingNo, String contentType, int weightKg, int distanceKm){
        this.trackingNo=trackingNo;
        this.contentType=contentType;
        this.weightKg=weightKg;
        this.distanceKm=distanceKm;
    }

    public String getContentType() {
        return contentType;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double calculateFee(){
return 0.0;
    }

    public void printReceipt(){
        System.out.println("Trackink no: " + trackingNo);
        System.out.println("Content Type: " + contentType);
        System.out.println("Shipment Type: " + this.getClass().getSimpleName());
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("Distance: " + distanceKm + " km");
        System.out.println("Total Fee: $" + calculateFee());
        System.out.println("**************************************");
    }
}