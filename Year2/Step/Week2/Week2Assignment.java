package Step.Week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week2Assignment {
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversed.append(words[i].charAt(j));
            }
            if (i > 0) {
                result.append(' ');
            }
            result.append(reversed);
        }
        return result.toString();
    }

    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
    }

    public static String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3) {
            return code.toUpperCase();
        }
        return code.substring(0, 3).toUpperCase() + code.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }
        StringBuilder result = new StringBuilder();
        result.append('[').append(code, 0, 3).append("] YEAR: ");
        result.append(code, 3, 7).append(" | CATALOG: ");
        result.append(code, 7, 13);
        return result.toString();
    }

    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace('.', ' ').replace(',', ' ');
        String[] words = cleaned.trim().split("\\s+");
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            boolean isStopWord = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }
            if (!isStopWord && !word.isEmpty()) {
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort((first, second) -> second.getValue() - first.getValue());
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
