package Step.Week7;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int capacity) {
        this.presentStudents = new String[capacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (name == null || isPresent(name)) {
            return;
        }
        if (count < presentStudents.length) {
            presentStudents[count++] = name;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (name.equals(presentStudents[i])) {
                return true;
            }
        }
        return false;
    }
}
