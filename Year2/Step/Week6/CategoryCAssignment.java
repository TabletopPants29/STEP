package Step.Week6;

public class CategoryCAssignment {
    public static void runM1() {
        BookInventory[] books = new BookInventory[]{
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };
        for (BookInventory book : books) {
            book.printEntry();
        }
    }

    public static void runM2() {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }

    public static void runM3() {
        Employee perm = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");
        perm.printProfile();
        intern.printProfile();
    }

    public static void runM4() {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }

    public static void runM5() {
        new Employee("Alice", 50000);
        new Employee("Bob", 60000);
        new Employee("Charlie", 70000);
        Employee.printCompanyInfo();
    }

    public static void main(String[] args) {
        runM1();
        runM2();
        runM3();
        runM4();
        runM5();
    }
}
