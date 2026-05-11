import java.util.Scanner;
import java.util.HashMap;

public class SwiftRouteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Shipment> shipmentMap = new HashMap<>();


        while (shipmentMap.size() < 5) {
            System.out.println("===Shipment Entry Menu===");
            System.out.println("1.Standart\n" +
                    "2.Express\n" +
                    "3.International");

            System.out.print("Select shipment type: ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Tracking No: ");
            String tNo = sc.nextLine();

            System.out.print("Enter Content Type (toy, book, etc.): ");
            String cType = sc.nextLine();

            System.out.print("Enter Weight (kg): ");
            int weight = sc.nextInt();

            System.out.print("Enter Distance (km): ");
            int distance = sc.nextInt();


            Shipment s = null;

            if (choice == 1) {
                s = new StandardShipping(tNo, cType, weight, distance);
            } else if (choice == 2) {
                s = new ExpressShipping(tNo, cType, weight, distance);
            } else if (choice == 3) {
                s = new InternationalShipping(tNo, cType, weight, distance);
            }

            if (s != null) {
                String key = tNo + "-" + cType;
                shipmentMap.put(key, s);
                System.out.println("Shipment added successfully!");
            }
        }
        System.out.println("\n--- ALL SHIPMENTS IN SYSTEM ---");
            for (Shipment kargo : shipmentMap.values()) {
                kargo.printReceipt();


                if (kargo instanceof ExpressShipping) {

                    ExpressShipping express = (ExpressShipping) kargo;
                    express.ExpressNote();
                }
                System.out.println();
            }
        }
    }