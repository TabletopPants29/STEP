package Step.Week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CategoryCProblems {

    public abstract static class GardenPlot {
        protected String owner;

        public GardenPlot(String owner) {
            this.owner = owner;
        }

        public abstract double getArea();
        public abstract String getShape();
        public String getOwner() {
            return owner;
        }
    }

    public static class CirclePlot extends GardenPlot {
        private final double radius;

        public CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public String getShape() {
            return "CIRCLE";
        }
    }

    public static class RectanglePlot extends GardenPlot {
        private final double length;
        private final double width;

        public RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }

        @Override
        public String getShape() {
            return "RECTANGLE";
        }
    }

    public static class TrianglePlot extends GardenPlot {
        private final double base;
        private final double height;

        public TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        public double getArea() {
            return 0.5 * base * height;
        }

        @Override
        public String getShape() {
            return "TRIANGLE";
        }
    }

    public static void runGardenPlot(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<GardenPlot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            if ("CIRCLE".equalsIgnoreCase(shape)) {
                double r = scanner.nextDouble();
                plots.add(new CirclePlot(owner, r));
            } else if ("RECTANGLE".equalsIgnoreCase(shape)) {
                double l = scanner.nextDouble();
                double w = scanner.nextDouble();
                plots.add(new RectanglePlot(owner, l, w));
            } else {
                double b = scanner.nextDouble();
                double h = scanner.nextDouble();
                plots.add(new TrianglePlot(owner, b, h));
            }
        }
        double totalArea = 0;
        for (GardenPlot p : plots) {
            double area = p.getArea();
            totalArea += area;
            System.out.printf(Locale.US, "%s (%s): %.2f%n", p.getOwner(), p.getShape(), area);
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
    }

    public abstract static class Staff {
        protected String name;

        public Staff(String name) {
            this.name = name;
        }

        public abstract double getPay();
        public String getName() {
            return name;
        }
    }

    public static class FullTimeStaff extends Staff {
        private final double weeklySalary;

        public FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double getPay() {
            return weeklySalary;
        }
    }

    public static class HourlyStaff extends Staff {
        private final double hours;
        private final double rate;

        public HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public double getPay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return 40 * rate + (hours - 40) * 1.5 * rate;
        }
    }

    public static class InternStaff extends Staff {
        private final double stipend;

        public InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        public double getPay() {
            return stipend;
        }
    }

    public static void runWeeklyStaffPay(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Staff> staffList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if ("FULLTIME".equalsIgnoreCase(type)) {
                double salary = scanner.nextDouble();
                staffList.add(new FullTimeStaff(name, salary));
            } else if ("HOURLY".equalsIgnoreCase(type)) {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staffList.add(new HourlyStaff(name, hours, rate));
            } else {
                double stipend = scanner.nextDouble();
                staffList.add(new InternStaff(name, stipend));
            }
        }
        double totalPayroll = 0;
        for (Staff s : staffList) {
            double pay = s.getPay();
            totalPayroll += pay;
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), pay);
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", totalPayroll);
    }

    public abstract static class LibraryItem {
        protected String title;
        protected int daysLate;

        public LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public abstract double getFine();
        public String getTitle() {
            return title;
        }
    }

    public static class BookItem extends LibraryItem {
        public BookItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double getFine() {
            return 2.0 * daysLate;
        }
    }

    public static class DvdItem extends LibraryItem {
        public DvdItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double getFine() {
            return Math.min(50.0, 5.0 * daysLate);
        }
    }

    public static class MagazineItem extends LibraryItem {
        public MagazineItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double getFine() {
            return 1.0 * daysLate;
        }
    }

    public static void runLibraryLateFine(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int days = scanner.nextInt();
            if ("BOOK".equalsIgnoreCase(type)) {
                items.add(new BookItem(title, days));
            } else if ("DVD".equalsIgnoreCase(type)) {
                items.add(new DvdItem(title, days));
            } else {
                items.add(new MagazineItem(title, days));
            }
        }
        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.getFine();
            totalFines += fine;
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", totalFines);
    }

    public abstract static class Connection {
        protected int units;

        public Connection(int units) {
            this.units = units;
        }

        public abstract double getBill();
        public abstract String getType();
    }

    public static class HomeConnection extends Connection {
        public HomeConnection(int units) {
            super(units);
        }

        @Override
        public double getBill() {
            if (units <= 100) {
                return units * 5.0;
            }
            return 100 * 5.0 + (units - 100) * 7.0;
        }

        @Override
        public String getType() {
            return "HOME";
        }
    }

    public static class ShopConnection extends Connection {
        public ShopConnection(int units) {
            super(units);
        }

        @Override
        public double getBill() {
            return 100.0 + units * 8.0;
        }

        @Override
        public String getType() {
            return "SHOP";
        }
    }

    public static class FactoryConnection extends Connection {
        public FactoryConnection(int units) {
            super(units);
        }

        @Override
        public double getBill() {
            return Math.max(1000.0, units * 6.0);
        }

        @Override
        public String getType() {
            return "FACTORY";
        }
    }

    public static void runElectricityBilling(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if ("HOME".equalsIgnoreCase(type)) {
                connections.add(new HomeConnection(units));
            } else if ("SHOP".equalsIgnoreCase(type)) {
                connections.add(new ShopConnection(units));
            } else {
                connections.add(new FactoryConnection(units));
            }
        }
        double grandTotal = 0;
        for (Connection c : connections) {
            double bill = c.getBill();
            grandTotal += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", c.getType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public abstract static class TravelBooking {
        protected double distanceKm;
        public static final double BOOKING_FEE = 50.0;

        public TravelBooking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        public abstract double getBaseFare();
        public abstract String getMode();

        public double getTotalFare() {
            return getBaseFare() + BOOKING_FEE;
        }
    }

    public static class BusBooking extends TravelBooking {
        public BusBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getBaseFare() {
            return 2.0 * distanceKm;
        }

        @Override
        public String getMode() {
            return "BUS";
        }
    }

    public static class TrainBooking extends TravelBooking {
        public TrainBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getBaseFare() {
            return 1.5 * distanceKm;
        }

        @Override
        public String getMode() {
            return "TRAIN";
        }
    }

    public static class FlightBooking extends TravelBooking {
        public FlightBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getBaseFare() {
            return 2500.0 + 4.0 * distanceKm;
        }

        @Override
        public String getMode() {
            return "FLIGHT";
        }
    }

    public static void runTravelBooking(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            if ("BUS".equalsIgnoreCase(mode)) {
                bookings.add(new BusBooking(distance));
            } else if ("TRAIN".equalsIgnoreCase(mode)) {
                bookings.add(new TrainBooking(distance));
            } else {
                bookings.add(new FlightBooking(distance));
            }
        }
        for (TravelBooking b : bookings) {
            System.out.printf(Locale.US, "%s: %.2f%n", b.getMode(), b.getTotalFare());
        }
    }

    public static void main(String[] args) {
        String plotInput = "3\nCIRCLE Asha 5\nRECTANGLE Ravi 4 6\nTRIANGLE Neha 10 3";
        runGardenPlot(new Scanner(plotInput));

        String staffInput = "3\nFULLTIME Asha 12000\nHOURLY Ravi 45 200\nINTERN Neha 5000";
        runWeeklyStaffPay(new Scanner(staffInput));

        String fineInput = "3\nBOOK Algebra 4\nDVD Inception 12\nMAGAZINE Sports 3";
        runLibraryLateFine(new Scanner(fineInput));

        String elecInput = "3\nHOME 150\nSHOP 90\nFACTORY 120";
        runElectricityBilling(new Scanner(elecInput));

        String travelInput = "3\nBUS 200\nTRAIN 300\nFLIGHT 500";
        runTravelBooking(new Scanner(travelInput));
    }
}
