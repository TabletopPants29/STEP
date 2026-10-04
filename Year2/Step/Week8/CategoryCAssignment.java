package Step.Week8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CategoryCAssignment {

    public abstract static class Customer {
        protected double amount;

        public Customer(double amount) {
            this.amount = amount;
        }

        public abstract double getFinalAmount();
        public abstract String getType();
    }

    public static class StudentCustomer extends Customer {
        public StudentCustomer(double amount) {
            super(amount);
        }

        @Override
        public double getFinalAmount() {
            return amount * 0.90;
        }

        @Override
        public String getType() {
            return "STUDENT";
        }
    }

    public static class StaffCustomer extends Customer {
        public StaffCustomer(double amount) {
            super(amount);
        }

        @Override
        public double getFinalAmount() {
            return amount * 0.95;
        }

        @Override
        public String getType() {
            return "STAFF";
        }
    }

    public static class GuestCustomer extends Customer {
        public GuestCustomer(double amount) {
            super(amount);
        }

        @Override
        public double getFinalAmount() {
            return amount + 10.0;
        }

        @Override
        public String getType() {
            return "GUEST";
        }
    }

    public static void runCanteenBilling(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if ("STUDENT".equalsIgnoreCase(type)) {
                customers.add(new StudentCustomer(amount));
            } else if ("STAFF".equalsIgnoreCase(type)) {
                customers.add(new StaffCustomer(amount));
            } else {
                customers.add(new GuestCustomer(amount));
            }
        }
        double grandTotal = 0;
        for (Customer c : customers) {
            double finalAmount = c.getFinalAmount();
            grandTotal += finalAmount;
            System.out.printf(Locale.US, "%s: %.2f%n", c.getType(), finalAmount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public abstract static class Vehicle {
        protected int hours;

        public Vehicle(int hours) {
            this.hours = hours;
        }

        public abstract double getCharge();
        public abstract String getType();
    }

    public static class Bike extends Vehicle {
        public Bike(int hours) {
            super(hours);
        }

        @Override
        public double getCharge() {
            return hours * 10.0;
        }

        @Override
        public String getType() {
            return "BIKE";
        }
    }

    public static class Car extends Vehicle {
        public Car(int hours) {
            super(hours);
        }

        @Override
        public double getCharge() {
            if (hours <= 1) {
                return 30.0;
            }
            return 30.0 + (hours - 1) * 20.0;
        }

        @Override
        public String getType() {
            return "CAR";
        }
    }

    public static class Truck extends Vehicle {
        public Truck(int hours) {
            super(hours);
        }

        @Override
        public double getCharge() {
            return Math.max(100.0, hours * 50.0);
        }

        @Override
        public String getType() {
            return "TRUCK";
        }
    }

    public static void runParkingCalculator(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            if ("BIKE".equalsIgnoreCase(type)) {
                vehicles.add(new Bike(hours));
            } else if ("CAR".equalsIgnoreCase(type)) {
                vehicles.add(new Car(hours));
            } else {
                vehicles.add(new Truck(hours));
            }
        }
        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            double charge = v.getCharge();
            grandTotal += charge;
            System.out.printf(Locale.US, "%s: %.2f%n", v.getType(), charge);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public abstract static class Room {
        protected int units;

        public Room(int units) {
            this.units = units;
        }

        public abstract double getBill();
        public abstract String getType();
    }

    public static class SingleRoom extends Room {
        public SingleRoom(int units) {
            super(units);
        }

        @Override
        public double getBill() {
            return units * 8.0;
        }

        @Override
        public String getType() {
            return "SINGLE";
        }
    }

    public static class SharedRoom extends Room {
        private final int occupants;

        public SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        public double getBill() {
            return (units * 6.0) / occupants;
        }

        @Override
        public String getType() {
            return "SHARED";
        }
    }

    public static class AcRoom extends Room {
        public AcRoom(int units) {
            super(units);
        }

        @Override
        public double getBill() {
            return units * 10.0 + 200.0;
        }

        @Override
        public String getType() {
            return "AC";
        }
    }

    public static void runHostelElectricity(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if ("SHARED".equalsIgnoreCase(type)) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if ("SINGLE".equalsIgnoreCase(type)) {
                rooms.add(new SingleRoom(units));
            } else {
                rooms.add(new AcRoom(units));
            }
        }
        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.getBill();
            grandTotal += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", r.getType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public abstract static class Employee {
        protected String name;
        protected double monthlySalary;

        public Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public abstract double getBonus();
        public String getName() {
            return name;
        }
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double getBonus() {
            return monthlySalary * 0.10;
        }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double getBonus() {
            return monthlySalary * 0.05;
        }
    }

    public static class InternEmployee extends Employee {
        public InternEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double getBonus() {
            return 2000.0;
        }
    }

    public static void runFestivalBonus(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            if ("FULLTIME".equalsIgnoreCase(type)) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if ("PARTTIME".equalsIgnoreCase(type)) {
                employees.add(new PartTimeEmployee(name, salary));
            } else {
                employees.add(new InternEmployee(name, salary));
            }
        }
        double grandTotal = 0;
        for (Employee e : employees) {
            double bonus = e.getBonus();
            grandTotal += bonus;
            System.out.printf(Locale.US, "%s: %.2f%n", e.getName(), bonus);
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", grandTotal);
    }

    public abstract static class StreamingPlan {
        protected String name;
        protected LocalDate startDate;

        public StreamingPlan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public abstract LocalDate getRenewalDate();
        public String getName() {
            return name;
        }
    }

    public static class BasicPlan extends StreamingPlan {
        public BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate getRenewalDate() {
            return startDate.plusDays(30);
        }
    }

    public static class StandardPlan extends StreamingPlan {
        public StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate getRenewalDate() {
            return startDate.plusDays(90);
        }
    }

    public static class PremiumPlan extends StreamingPlan {
        public PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate getRenewalDate() {
            return startDate.plusDays(365);
        }
    }

    public static void runStreamingPlanRenewal(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<StreamingPlan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate date = LocalDate.parse(dateStr);
            if ("BASIC".equalsIgnoreCase(type)) {
                plans.add(new BasicPlan(name, date));
            } else if ("STANDARD".equalsIgnoreCase(type)) {
                plans.add(new StandardPlan(name, date));
            } else {
                plans.add(new PremiumPlan(name, date));
            }
        }
        for (StreamingPlan p : plans) {
            System.out.println(p.getName() + ": " + p.getRenewalDate());
        }
    }

    public static void main(String[] args) {
        String canteenInput = "3\nSTUDENT 200\nSTAFF 300\nGUEST 150";
        runCanteenBilling(new Scanner(canteenInput));

        String parkingInput = "4\nBIKE 3\nCAR 4\nTRUCK 1\nCAR 1";
        runParkingCalculator(new Scanner(parkingInput));

        String hostelInput = "3\nSINGLE 120\nSHARED 150 3\nAC 100";
        runHostelElectricity(new Scanner(hostelInput));

        String bonusInput = "3\nFULLTIME Asha 50000\nPARTTIME Ravi 30000\nINTERN Neha 15000";
        runFestivalBonus(new Scanner(bonusInput));

        String streamingInput = "4\nBASIC Asha 2024-01-15\nSTANDARD Ravi 2024-02-01\nPREMIUM Neha 2024-03-10\nBASIC Kiran 2024-12-20";
        runStreamingPlanRenewal(new Scanner(streamingInput));
    }
}
