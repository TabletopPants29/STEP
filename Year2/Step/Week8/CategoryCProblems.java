package Step.Week8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoryCProblems {

    public abstract static class PaymentMethod {
        protected double amount;

        public PaymentMethod(double amount) {
            this.amount = amount;
        }

        public abstract double getAdjustedAmount();
        public abstract String getType();
    }

    public static class CardPayment extends PaymentMethod {
        public CardPayment(double amount) {
            super(amount);
        }

        @Override
        public double getAdjustedAmount() {
            return amount * 1.02;
        }

        @Override
        public String getType() {
            return "CARD";
        }
    }

    public static class WalletPayment extends PaymentMethod {
        public WalletPayment(double amount) {
            super(amount);
        }

        @Override
        public double getAdjustedAmount() {
            return amount * 1.01;
        }

        @Override
        public String getType() {
            return "WALLET";
        }
    }

    public static class BankTransferPayment extends PaymentMethod {
        public BankTransferPayment(double amount) {
            super(amount);
        }

        @Override
        public double getAdjustedAmount() {
            return amount;
        }

        @Override
        public String getType() {
            return "BANKTRANSFER";
        }
    }

    public static void runPaymentSystem(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<PaymentMethod> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if ("CARD".equalsIgnoreCase(type)) {
                payments.add(new CardPayment(amount));
            } else if ("WALLET".equalsIgnoreCase(type)) {
                payments.add(new WalletPayment(amount));
            } else {
                payments.add(new BankTransferPayment(amount));
            }
        }
        double grandTotal = 0;
        for (PaymentMethod p : payments) {
            double adjusted = p.getAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf(Locale.US, "%s: %.2f%n", p.getType(), adjusted);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public abstract static class LibraryItem {
        protected String title;

        public LibraryItem(String title) {
            this.title = title;
        }

        public abstract LocalDate getDueDate(LocalDate fromDate);
        public String getTitle() {
            return title;
        }
    }

    public static class BookItem extends LibraryItem {
        public BookItem(String title) {
            super(title);
        }

        @Override
        public LocalDate getDueDate(LocalDate fromDate) {
            return fromDate.plusDays(14);
        }
    }

    public static class DvdItem extends LibraryItem {
        public DvdItem(String title) {
            super(title);
        }

        @Override
        public LocalDate getDueDate(LocalDate fromDate) {
            return fromDate.plusDays(7);
        }
    }

    public static class MagazineItem extends LibraryItem {
        public MagazineItem(String title) {
            super(title);
        }

        @Override
        public LocalDate getDueDate(LocalDate fromDate) {
            return fromDate.plusDays(3);
        }
    }

    public static void runLibraryItemDueDates(Scanner scanner) {
        if (!scanner.hasNextLine()) return;
        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        int n = Integer.parseInt(firstLine);
        LocalDate baseDate = LocalDate.parse("2023-10-26");
        List<LibraryItem> items = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\w+)\\s+\"?([^\"]+)\"?");
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                String type = m.group(1);
                String title = m.group(2);
                if ("BOOK".equalsIgnoreCase(type)) {
                    items.add(new BookItem(title));
                } else if ("DVD".equalsIgnoreCase(type)) {
                    items.add(new DvdItem(title));
                } else {
                    items.add(new MagazineItem(title));
                }
            }
        }
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate(baseDate));
        }
    }

    public abstract static class Delivery {
        protected double weight;
        protected double distance;

        public Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public abstract double getFee();
        public abstract String getType();
    }

    public static class StandardDelivery extends Delivery {
        public StandardDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        public double getFee() {
            return 5.0 + 0.50 * weight + 0.10 * distance;
        }

        @Override
        public String getType() {
            return "STANDARD";
        }
    }

    public static class ExpressDelivery extends Delivery {
        public ExpressDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        public double getFee() {
            return 20.0 + 1.00 * weight + 0.20 * distance;
        }

        @Override
        public String getType() {
            return "EXPRESS";
        }
    }

    public static class InternationalDelivery extends Delivery {
        private final double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public double getFee() {
            return 35.0 + 2.00 * weight + 0.50 * distance + customsFee;
        }

        @Override
        public String getType() {
            return "INTERNATIONAL";
        }
    }

    public static void runDeliveryFee(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            if ("INTERNATIONAL".equalsIgnoreCase(type)) {
                double customs = scanner.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customs));
            } else if ("EXPRESS".equalsIgnoreCase(type)) {
                deliveries.add(new ExpressDelivery(weight, distance));
            } else {
                deliveries.add(new StandardDelivery(weight, distance));
            }
        }
        double grandTotal = 0;
        for (Delivery d : deliveries) {
            double fee = d.getFee();
            grandTotal += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", d.getType(), fee);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public abstract static class Question {
        protected String text;
        protected String correctAnswer;
        protected int points;

        public Question(String text, String correctAnswer, int points) {
            this.text = text;
            this.correctAnswer = correctAnswer;
            this.points = points;
        }

        public abstract double grade(String studentAnswer);
        public abstract String getType();
    }

    public static class McqQuestion extends Question {
        public McqQuestion(String text, String correctAnswer, int points) {
            super(text, correctAnswer, points);
        }

        @Override
        public double grade(String studentAnswer) {
            return correctAnswer.equals(studentAnswer) ? points : 0.0;
        }

        @Override
        public String getType() {
            return "MCQ";
        }
    }

    public static class TfQuestion extends Question {
        public TfQuestion(String text, String correctAnswer, int points) {
            super(text, correctAnswer, points);
        }

        @Override
        public double grade(String studentAnswer) {
            return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
        }

        @Override
        public String getType() {
            return "TF";
        }
    }

    public static class EssayQuestion extends Question {
        public EssayQuestion(String text, String correctAnswer, int points) {
            super(text, correctAnswer, points);
        }

        @Override
        public double grade(String studentAnswer) {
            String[] keywords = correctAnswer.split(",");
            int matchCount = 0;
            String lowerStudent = studentAnswer.toLowerCase();
            for (String kw : keywords) {
                String clean = kw.trim().toLowerCase();
                if (!clean.isEmpty() && lowerStudent.contains(clean)) {
                    matchCount++;
                }
            }
            if (matchCount >= 2) {
                return points * 0.75;
            } else if (matchCount == 1) {
                return points * 0.50;
            }
            return 0.0;
        }

        @Override
        public String getType() {
            return "ESSAY";
        }
    }

    public static void runExamGrader(String rawInput) {
        Scanner scanner = new Scanner(rawInput);
        if (!scanner.hasNextLine()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Double> scores = new ArrayList<>();
        List<String> types = new ArrayList<>();
        Pattern linePattern = Pattern.compile("^(\\w+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)");
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            Matcher m = linePattern.matcher(line);
            if (m.find()) {
                String type = m.group(1);
                String text = m.group(2);
                String correct = m.group(3);
                String student = m.group(4);
                int points = Integer.parseInt(m.group(5));
                Question q;
                if ("MCQ".equalsIgnoreCase(type)) {
                    q = new McqQuestion(text, correct, points);
                } else if ("TF".equalsIgnoreCase(type)) {
                    q = new TfQuestion(text, correct, points);
                } else {
                    q = new EssayQuestion(text, correct, points);
                }
                types.add(q.getType());
                scores.add(q.grade(student));
            }
        }
        double total = 0;
        for (int i = 0; i < scores.size(); i++) {
            double score = scores.get(i);
            total += score;
            System.out.printf(Locale.US, "%s: %.2f%n", types.get(i), score);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }

    public abstract static class Transport {
        protected double distance;

        public Transport(double distance) {
            this.distance = distance;
        }

        public abstract double getFare();
        public abstract String getType();
    }

    public static class BusTransport extends Transport {
        public BusTransport(double distance) {
            super(distance);
        }

        @Override
        public double getFare() {
            return Math.min(10.0, 2.0 + 0.10 * distance);
        }

        @Override
        public String getType() {
            return "BUS";
        }
    }

    public static class TrainTransport extends Transport {
        public TrainTransport(double distance) {
            super(distance);
        }

        @Override
        public double getFare() {
            return 3.0 + 0.15 * distance;
        }

        @Override
        public String getType() {
            return "TRAIN";
        }
    }

    public static class MetroTransport extends Transport {
        private final double peakHourFactor;

        public MetroTransport(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public double getFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }

        @Override
        public String getType() {
            return "METRO";
        }
    }

    public static void runTransportFare(Scanner scanner) {
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Transport> transports = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            if ("METRO".equalsIgnoreCase(type)) {
                double factor = scanner.nextDouble();
                transports.add(new MetroTransport(distance, factor));
            } else if ("TRAIN".equalsIgnoreCase(type)) {
                transports.add(new TrainTransport(distance));
            } else {
                transports.add(new BusTransport(distance));
            }
        }
        double grandTotal = 0;
        for (Transport t : transports) {
            double fare = t.getFare();
            grandTotal += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        String paymentInput = "3\nCARD 1000\nWALLET 500\nBANKTRANSFER 2000";
        runPaymentSystem(new Scanner(paymentInput));

        String libraryInput = "3\nBOOK \"1984\"\nDVD \"The Matrix\"\nMAGAZINE \"Forbes Issue 500\"";
        runLibraryItemDueDates(new Scanner(libraryInput));

        String deliveryInput = "3\nSTANDARD 10 50\nEXPRESS 5 20\nINTERNATIONAL 20 100 30";
        runDeliveryFee(new Scanner(deliveryInput));

        String examInput = "4\nMCQ \"What is the capital of France?\" \"Paris\" \"Paris\" 10\nTF \"The Earth is flat?\" \"False\" \"True\" 5\nESSAY \"Name two primary OOP principles.\" \"Inheritance, Polymorphism, Encapsulation\" \"Polymorphism is one.\" 20\nESSAY \"Describe abstraction and composition.\" \"Abstraction, Composition\" \"I talked about abstraction.\" 15";
        runExamGrader(examInput);

        String transportInput = "3\nBUS 15\nTRAIN 50\nMETRO 10 1.5";
        runTransportFare(new Scanner(transportInput));
    }
}
