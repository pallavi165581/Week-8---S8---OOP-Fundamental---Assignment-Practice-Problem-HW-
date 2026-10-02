import java.time.LocalDate;
import java.util.Scanner;

// Problem 5 - The Streaming Plan Renewal Reminder
// Each plan overrides validityDays(); renewal = start date + that many days.
public class StreamingPlanRenewal {

    static abstract class Plan {
        protected String name;      // subscriber name
        protected LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate start) { super(name, start); }
        int validityDays() { return 30; }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate start) { super(name, start); }
        int validityDays() { return 90; }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate start) { super(name, start); }
        int validityDays() { return 365; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Plan[] subscribers = new Plan[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String name = parts[1];
            LocalDate start = LocalDate.parse(parts[2]); // ISO format parses directly
            switch (parts[0]) {
                case "BASIC":    subscribers[i] = new BasicPlan(name, start); break;
                case "STANDARD": subscribers[i] = new StandardPlan(name, start); break;
                case "PREMIUM":  subscribers[i] = new PremiumPlan(name, start); break;
            }
        }

        // no total line for this one - just each subscriber's renewal date
        for (Plan p : subscribers) {
            System.out.println(p.name + ": " + p.renewalDate());
        }
        sc.close();
    }
}
