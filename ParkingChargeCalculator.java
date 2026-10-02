import java.util.Scanner;

// Problem 2 - The Campus Parking Charge Calculator
// Each vehicle type overrides calculateCharge() with its own hourly rule.
public class ParkingChargeCalculator {

    static abstract class Vehicle {
        protected String type;
        protected int hours;

        Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) { super("BIKE", hours); }
        double calculateCharge() {
            return 10.0 * hours;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) { super("CAR", hours); }
        double calculateCharge() {
            // Rs 30 for hour one, Rs 20 for every hour after that
            return 30 + 20.0 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        private static final double MIN_CHARGE = 100.0;

        Truck(int hours) { super("TRUCK", hours); }
        double calculateCharge() {
            return Math.max(50.0 * hours, MIN_CHARGE); // never below the minimum
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Vehicle[] vehicles = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            int hours = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "BIKE":  vehicles[i] = new Bike(hours); break;
                case "CAR":   vehicles[i] = new Car(hours); break;
                case "TRUCK": vehicles[i] = new Truck(hours); break;
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", v.type, charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
