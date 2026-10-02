import java.util.Scanner;

// Problem 4 - The Festival Bonus Calculator
// Each employee type overrides calculateBonus(); output shows the name, not the type.
public class FestivalBonusCalculator {

    static abstract class Employee {
        protected String name;
        protected double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double salary) { super(name, salary); }
        double calculateBonus() { return monthlySalary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double salary) { super(name, salary); }
        double calculateBonus() { return monthlySalary * 0.05; }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) { super(name, salary); }
        double calculateBonus() { return 2000; } // fixed bonus regardless of salary
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);
            switch (parts[0]) {
                case "FULLTIME": employees[i] = new FullTimeEmployee(name, salary); break;
                case "PARTTIME": employees[i] = new PartTimeEmployee(name, salary); break;
                case "INTERN":   employees[i] = new Intern(name, salary); break;
            }
        }

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
