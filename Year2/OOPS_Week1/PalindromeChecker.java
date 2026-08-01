public class PalindromeChecker {
    public static void main(String[] args) {
        String[] testWords = {"madam", "hello"};

        for (String word : testWords) {
            System.out.println("Input: \"" + word + "\"");
            System.out.println("Iterative: " + (isPalindromeIterative(word) ? "Palindrome" : "Not Palindrome")
                    + " | Recursive: " + (isPalindromeRecursive(word) ? "Palindrome" : "Not Palindrome")
                    + " | Array Reversal: " + (isPalindromeArrayReversal(word) ? "Palindrome" : "Not Palindrome"));
        }
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return text.equals(new String(reversed));
    }
}