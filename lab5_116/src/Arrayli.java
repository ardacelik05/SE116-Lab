import java.util.Scanner;
import java.util.ArrayList;

public class Arrayli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Shipment> shipmentList = new ArrayList<>();
        while (shipmentList.size() < 2) {
            System.out.println("\n=== Shipment Entry Menu (" + (shipmentList.size() + 1) + "/2) ===");
            System.out.println("1. Standart");
            System.out.println("2. Express");
            System.out.println("3. International");
            System.out.print("Select shipment type: ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Tracking No: ");
            String tNo = sc.nextLine();

            System.out.print("Enter Content Type: ");
            String cType = sc.nextLine();

            System.out.print("Enter Weight (kg): ");
            int weight = sc.nextInt();

            System.out.print("Enter Distance (km): ");
            int distance = sc.nextInt();
            sc.nextLine();

            Shipment s = null;

            if (choice == 1) {
                s = new StandardShipping(tNo, cType, weight, distance);
               // shipmentList.add(new StandardShipping(tNo,cType,weight,distance));
            } else if (choice == 2) {
                s = new ExpressShipping(tNo, cType, weight, distance);
                //shipmentList.add(new ExpressShipping(tNo,cType,weight,distance));
            } else if (choice == 3) {
                s = new InternationalShipping(tNo, cType, weight, distance);
                //shipmentList.add(new InternationalShipping(tNo,cType,weight,distance));
            }

            if (s != null) {
                shipmentList.add(s);
                System.out.println("Shipment added successfully!");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        System.out.println("\n--- ALL SHIPMENTS IN SYSTEM ---");

        for (Shipment kargo : shipmentList) {
            kargo.printReceipt();

            if (kargo instanceof ExpressShipping) {
                ExpressShipping express = (ExpressShipping) kargo;
                express.ExpressNote();
            }
            System.out.println("------------------------------");
        }
    }
}