package Step.Week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CategoryCAssignment {

    public abstract static class Ticket {
        protected int count;
        public static final double CONVENIENCE_FEE = 20.0;

        public Ticket(int count) {
            this.count = count;
        }

        public abstract double getPrice();
        public abstract String getSeatType();

        public double calculateTotal() {
            return (getPrice() + CONVENIENCE_FEE) * count;
        }
    }

    public static class RegularTicket extends Ticket {
        public RegularTicket(int count) {
            super(count);
        }

        @Override
        public double getPrice() {
            return 150.0;
        }

        @Override
        public String getSeatType() {
            return "REGULAR";
        }
    }

    public static class PremiumTicket extends Ticket {
        public PremiumTicket(int count) {
            super(count);
        }

        @Override
        public double getPrice() {
            return 250.0;
        }

        @Override
        public String getSeatType() {
            return "PREMIUM";
        }
    }

    public static class ReclinerTicket extends Ticket {
        public ReclinerTicket(int count) {
            super(count);
        }

        @Override
        public double getPrice() {
            return 400.0;
        }

        @Override
        public String getSeatType() {
            return "RECLINER";
        }
    }

    public static void runMovieTicketCounter(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            if ("REGULAR".equalsIgnoreCase(seat)) {
                tickets.add(new RegularTicket(count));
            } else if ("PREMIUM".equalsIgnoreCase(seat)) {
                tickets.add(new PremiumTicket(count));
            } else {
                tickets.add(new ReclinerTicket(count));
            }
        }
        double grandTotal = 0;
        for (Ticket t : tickets) {
            double total = t.calculateTotal();
            grandTotal += total;
            System.out.printf(Locale.US, "%s: %.2f%n", t.getSeatType(), total);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public interface Insurable {
        double calculateInsurance();
    }

    public abstract static class Parcel {
        protected double weightKg;
        protected double declaredValue;

        public Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public abstract double calculateShippingCharge();
        public abstract String getType();

        public double calculateInsurance() {
            if (this instanceof Insurable) {
                return ((Insurable) this).calculateInsurance();
            }
            return 0.0;
        }

        public double calculateTotal() {
            return calculateShippingCharge() + calculateInsurance();
        }
    }

    public static class StandardParcel extends Parcel {
        public StandardParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 40.0 + 10.0 * weightKg;
        }

        @Override
        public String getType() {
            return "STANDARD";
        }
    }

    public static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 80.0 + 15.0 * weightKg;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }

        @Override
        public String getType() {
            return "EXPRESS";
        }
    }

    public static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 40.0 + 10.0 * weightKg + 50.0;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }

        @Override
        public String getType() {
            return "FRAGILE";
        }
    }

    public static void runParcelShippingDesk(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();
            if ("STANDARD".equalsIgnoreCase(type)) {
                parcels.add(new StandardParcel(weight, value));
            } else if ("EXPRESS".equalsIgnoreCase(type)) {
                parcels.add(new ExpressParcel(weight, value));
            } else {
                parcels.add(new FragileParcel(weight, value));
            }
        }
        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateShippingCharge();
            double insurance = p.calculateInsurance();
            double total = p.calculateTotal();
            grandTotal += total;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.getType(), charge, insurance, total);
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }

    public interface BusUser {
        double TRANSPORT_FEE = 12000.0;
        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    public abstract static class Student {
        protected String name;

        public Student(String name) {
            this.name = name;
        }

        public abstract double getTuition();
        public abstract double getExtraFee();

        public double getTotalFee() {
            return getTuition() + getExtraFee();
        }

        public String getName() {
            return name;
        }
    }

    public static class DayScholar extends Student implements BusUser {
        public DayScholar(String name) {
            super(name);
        }

        @Override
        public double getTuition() {
            return 40000.0;
        }

        @Override
        public double getExtraFee() {
            return getTransportFee();
        }
    }

    public static class Hosteller extends Student {
        public Hosteller(String name) {
            super(name);
        }

        @Override
        public double getTuition() {
            return 40000.0;
        }

        @Override
        public double getExtraFee() {
            return 60000.0;
        }
    }

    public static class ScholarshipStudent extends Student implements BusUser {
        public ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        public double getTuition() {
            return 20000.0;
        }

        @Override
        public double getExtraFee() {
            return getTransportFee();
        }
    }

    public static void runCollegeFeeCounter(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if ("DAY_SCHOLAR".equalsIgnoreCase(type)) {
                students.add(new DayScholar(name));
            } else if ("HOSTELLER".equalsIgnoreCase(type)) {
                students.add(new Hosteller(name));
            } else {
                students.add(new ScholarshipStudent(name));
            }
        }
        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.getTotalFee();
            totalCollected += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
    }

    public interface NightService {
        double applyNightSurcharge(double baseFare);
    }

    public abstract static class Cab {
        protected double distanceKm;

        public Cab(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        public abstract double getRatePerKm();
        public abstract String getType();

        public double calculateBaseFare() {
            return Math.max(100.0, distanceKm * getRatePerKm());
        }
    }

    public static class MiniCab extends Cab {
        public MiniCab(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getRatePerKm() {
            return 10.0;
        }

        @Override
        public String getType() {
            return "MINI";
        }
    }

    public static class SedanCab extends Cab implements NightService {
        public SedanCab(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getRatePerKm() {
            return 14.0;
        }

        @Override
        public double applyNightSurcharge(double baseFare) {
            return baseFare * 1.20;
        }

        @Override
        public String getType() {
            return "SEDAN";
        }
    }

    public static class SuvCab extends Cab implements NightService {
        public SuvCab(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getRatePerKm() {
            return 18.0;
        }

        @Override
        public double applyNightSurcharge(double baseFare) {
            return baseFare * 1.20;
        }

        @Override
        public String getType() {
            return "SUV";
        }
    }

    public static void runCityCabFareMeter(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            Cab cab;
            if ("MINI".equalsIgnoreCase(cabType)) {
                cab = new MiniCab(km);
            } else if ("SEDAN".equalsIgnoreCase(cabType)) {
                cab = new SedanCab(km);
            } else {
                cab = new SuvCab(km);
            }

            if ("NIGHT".equalsIgnoreCase(time)) {
                if (cab instanceof NightService) {
                    double fare = ((NightService) cab).applyNightSurcharge(cab.calculateBaseFare());
                    total += fare;
                    System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
                } else {
                    System.out.printf("%s: night service not available%n", cab.getType());
                }
            } else {
                double fare = cab.calculateBaseFare();
                total += fare;
                System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public interface SaverMode {
        double applySaverReduction(double units);
    }

    public abstract static class Appliance {
        protected double hours;

        public Appliance(double hours) {
            this.hours = hours;
        }

        public abstract double getPowerWatts();
        public abstract String getType();

        public double calculateUnits() {
            return (getPowerWatts() * hours) / 1000.0;
        }

        public double calculateCost(double units) {
            return units * 8.0;
        }
    }

    public static class FridgeAppliance extends Appliance {
        public FridgeAppliance(double hours) {
            super(hours);
        }

        @Override
        public double getPowerWatts() {
            return 150.0;
        }

        @Override
        public String getType() {
            return "FRIDGE";
        }
    }

    public static class AcAppliance extends Appliance implements SaverMode {
        public AcAppliance(double hours) {
            super(hours);
        }

        @Override
        public double getPowerWatts() {
            return 1500.0;
        }

        @Override
        public double applySaverReduction(double units) {
            return units * 0.75;
        }

        @Override
        public String getType() {
            return "AC";
        }
    }

    public static class TvAppliance extends Appliance {
        public TvAppliance(double hours) {
            super(hours);
        }

        @Override
        public double getPowerWatts() {
            return 100.0;
        }

        @Override
        public String getType() {
            return "TV";
        }
    }

    public static class WasherAppliance extends Appliance implements SaverMode {
        public WasherAppliance(double hours) {
            super(hours);
        }

        @Override
        public double getPowerWatts() {
            return 500.0;
        }

        @Override
        public double applySaverReduction(double units) {
            return units * 0.75;
        }

        @Override
        public String getType() {
            return "WASHER";
        }
    }

    public static void runHomeApplianceEnergy(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String appType = scanner.next();
            double hours = scanner.nextDouble();
            boolean isSaver = false;
            if (scanner.hasNext("SAVER")) {
                scanner.next();
                isSaver = true;
            }
            Appliance appliance;
            if ("FRIDGE".equalsIgnoreCase(appType)) {
                appliance = new FridgeAppliance(hours);
            } else if ("AC".equalsIgnoreCase(appType)) {
                appliance = new AcAppliance(hours);
            } else if ("TV".equalsIgnoreCase(appType)) {
                appliance = new TvAppliance(hours);
            } else {
                appliance = new WasherAppliance(hours);
            }

            if (isSaver) {
                if (appliance instanceof SaverMode) {
                    double units = ((SaverMode) appliance).applySaverReduction(appliance.calculateUnits());
                    double cost = appliance.calculateCost(units);
                    totalCost += cost;
                    System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", appliance.getType(), units, cost);
                } else {
                    System.out.printf("%s: saver mode not supported%n", appliance.getType());
                }
            } else {
                double units = appliance.calculateUnits();
                double cost = appliance.calculateCost(units);
                totalCost += cost;
                System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", appliance.getType(), units, cost);
            }
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }

    public static void main(String[] args) {
        String ticketInput = "3\nREGULAR 3\nPREMIUM 2\nRECLINER 1";
        runMovieTicketCounter(new Scanner(ticketInput));

        String parcelInput = "3\nSTANDARD 3 500\nEXPRESS 2 1000\nFRAGILE 4 2000";
        runParcelShippingDesk(new Scanner(parcelInput));

        String studentInput = "3\nDAY_SCHOLAR Asha\nHOSTELLER Ravi\nSCHOLAR Neha";
        runCollegeFeeCounter(new Scanner(studentInput));

        String cabInput = "4\nMINI 8 DAY\nSEDAN 10 NIGHT\nSUV 20 DAY\nMINI 5 NIGHT";
        runCityCabFareMeter(new Scanner(cabInput));

        String energyInput = "4\nFRIDGE 24\nAC 8 SAVER\nTV 5\nWASHER 2 SAVER";
        runHomeApplianceEnergy(new Scanner(energyInput));
    }
}
