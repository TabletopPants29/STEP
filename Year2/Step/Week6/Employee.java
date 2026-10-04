package Step.Week6;

public class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
        employeeCount++;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
