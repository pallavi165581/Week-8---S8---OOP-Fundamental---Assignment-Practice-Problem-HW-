import java.util.Scanner;

// Problem 3 - The Hostel Electricity Bill
// Each room type overrides calculateBill(); SHARED carries the extra occupants field.
public class HostelElectricityBill {

    static abstract class Room {
        protected String type;
        protected int units;

        Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) { super("SINGLE", units); }
        double calculateBill() {
            return 8.0 * units;
        }
    }

    static class SharedRoom extends Room {
        private int occupants; // the extra value lives on the subclass that needs it

        SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }
        double calculateBill() {
            return 6.0 * units / occupants; // split equally - each occupant's share
        }
    }

    static class AcRoom extends Room {
        AcRoom(int units) { super("AC", units); }
        double calculateBill() {
            return 10.0 * units + 200; // fixed AC charge on top
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            int units = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units); break;
                case "SHARED":
                    int occupants = Integer.parseInt(parts[2]);
                    rooms[i] = new SharedRoom(units, occupants); break;
                case "AC":
                    rooms[i] = new AcRoom(units); break;
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f%n", r.type, bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
