package Step.Week7;

public class CategoryCProblems {
    public static void runProblem1() {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("Savings: " + (int) pb.getSavings());
        pb.withdraw(30);
        System.out.println("Savings: " + (int) pb.getSavings());
        boolean success = pb.withdraw(500);
        System.out.println("Withdraw 500 status: " + (success ? "accepted" : "rejected") + ", savings: " + (int) pb.getSavings());
    }

    public static void runProblem2() {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }

    public static void runProblem3() {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname());
    }

    public static void runProblem4() {
        Locker locker = new Locker(101, "1234");
        boolean change1 = locker.changeCode("1234", "5678");
        System.out.println("Change 1: " + (change1 ? "success" : "rejected"));
        boolean change2 = locker.changeCode("0000", "9999");
        System.out.println("Change 2: " + (change2 ? "success" : "rejected"));
    }

    public static void runProblem5() {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present: " + sheet.isPresent("Chen"));
    }

    public static void main(String[] args) {
        runProblem1();
        runProblem2();
        runProblem3();
        runProblem4();
        runProblem5();
    }
}
