import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueLetterHunt {
    public static void main(String[] args) {
        String[] testStrings = {"swiss", "aabbcc"};

        for (String text : testStrings) {
            char result = findFirstNonRepeatingChar(text);
            System.out.println("Input: \"" + text + "\"");
            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }
}