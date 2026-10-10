package Step.Week10;

import java.util.Arrays;

public class CategoryCAssignment {

    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }
        int first = lowerBound(scores, low);
        int last = upperBound(scores, high);
        return Math.max(0, last - first);
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int longestStreak = 0;
        int currentStreak = 0;
        if (days != null) {
            for (int day : days) {
                if (day == 1) {
                    present++;
                    currentStreak++;
                    if (currentStreak > longestStreak) {
                        longestStreak = currentStreak;
                    }
                } else {
                    currentStreak = 0;
                }
            }
        }
        return new int[]{present, longestStreak};
    }

    public static String formatAttendanceSummary(int[] days) {
        int[] res = attendanceSummary(days);
        return "Present: " + res[0] + ", Longest streak: " + res[1];
    }

    public static void printAttendanceSummary(int[] days) {
        System.out.println(formatAttendanceSummary(days));
    }

    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }
        int highest = -1;
        int second = -1;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length == 0) {
            return names;
        }
        int n = names.length;
        int shift = k % n;
        if (shift < 0) {
            shift = (shift + n) % n;
        }
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length == 0) {
            return names;
        }
        int n = names.length;
        int shift = (int) (k % n);
        if (shift < 0) {
            shift = (shift + n) % n;
        }
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] scores1 = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores1, 42, 58));
        System.out.println(countInBand(scores1, 90, 100));

        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        printAttendanceSummary(days1);
        int[] days2 = {0, 0, 0};
        printAttendanceSummary(days2);

        int[] scoresQ7_1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(scoresQ7_1));
        int[] scoresQ7_2 = {50, 50, 50};
        System.out.println(secondHighest(scoresQ7_2));

        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
