package Step.Week10;

import java.util.Arrays;

public class CategoryCProblems {

    public static void countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;
        String lower = word.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void reverseAndCheckPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();
        if (word.equals(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }

    public static void countEvenAndOdd(int[] numbers) {
        int even = 0;
        int odd = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    public static void reverseArrayInPlace(int[] arr) {
        if (arr == null) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void digitSumAndReverse(int number) {
        int sum = 0;
        int reversed = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void checkPrime(int n) {
        if (isPrime(n)) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void printFactorial(int n) {
        System.out.println(factorial(n));
    }

    public static String getGrade(int marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 60) {
            return "Grade C";
        } else if (marks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void printGrade(int marks) {
        System.out.println(getGrade(marks));
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }

    public static void generateStudentResultCard(String name, double[] marks) {
        Student student = new Student(name, marks);
        student.printResultCard();
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Programming");

        reverseAndCheckPalindrome("level");
        reverseAndCheckPalindrome("java");

        int[] numsQ3 = {3, 8, 12, 5, 7, 10};
        countEvenAndOdd(numsQ3);

        int[] tokens = {11, 22, 33, 44};
        reverseArrayInPlace(tokens);
        System.out.println(Arrays.toString(tokens));

        digitSumAndReverse(4721);

        checkPrime(29);
        checkPrime(21);

        printFactorial(5);
        printFactorial(0);

        printGrade(72);
        printGrade(95);
        printGrade(35);

        checkLeapYear(2024);
        checkLeapYear(1900);
        checkLeapYear(2000);

        Student asha = new Student("Asha", new double[]{80, 90, 70});
        asha.printResultCard();
        Student ravi = new Student("Ravi", new double[]{60, 55, 50});
        ravi.printResultCard();
    }
}
