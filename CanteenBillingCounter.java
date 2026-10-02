import java.util.Scanner;

// Problem 1 - The Canteen Billing Counter
// Each customer type overrides finalAmount() with its own pricing rule.
public class CanteenBillingCounter {

    static abstract class Customer {
        protected String type;
        protected double billAmount;

        Customer(String type, double billAmount) {
            this.type = type;
            this.billAmount = billAmount;
        }

        abstract double finalAmount(); // each customer type has its own rule
    }

    static class Student extends Customer {
        Student(double amount) { super("STUDENT", amount); }
        double finalAmount() { return billAmount * 0.90; }        // 10% off
    }

    static class Staff extends Customer {
        Staff(double amount) { super("STAFF", amount); }
        double finalAmount() { return billAmount * 0.95; }        // 5% off
    }

    static class Guest extends Customer {
        Guest(double amount) { super("GUEST", amount); }
        double finalAmount() { return billAmount + 10; }          // Rs 10 service charge
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Customer[] customers = new Customer[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            double amount = Double.parseDouble(parts[1]);
            switch (parts[0]) {
                case "STUDENT": customers[i] = new Student(amount); break;
                case "STAFF":   customers[i] = new Staff(amount); break;
                case "GUEST":   customers[i] = new Guest(amount); break;
            }
        }

        // one polymorphic loop - the right rule runs without any type checks
        double total = 0;
        for (Customer c : customers) {
            double finalAmt = c.finalAmount();
            System.out.printf("%s: %.2f%n", c.type, finalAmt);
            total += finalAmt;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
