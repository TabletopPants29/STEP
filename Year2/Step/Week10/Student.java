package Step.Week10;

import java.util.Locale;

public class Student {
    private String name;
    private double[] marks;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = new double[marks.length];
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = marks[i];
        }
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }

    public double calculateAverage() {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public String assignGrade() {
        double avg = calculateAverage();
        if (avg >= 75) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public void printResultCard() {
        double avg = calculateAverage();
        String grade = assignGrade();
        System.out.printf(Locale.US, "%s: Average %.1f, Grade %s%n", name.toUpperCase(), avg, grade);
    }
}
