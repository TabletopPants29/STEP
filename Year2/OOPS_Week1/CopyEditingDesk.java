public class CopyEditingDesk {
    public static void main(String[] args) {
        String text = "Java is an object oriented programming language";
        String[] result = findShortestAndLongestWord(text);

        System.out.println("Input: " + text);
        System.out.println("Shortest: \"" + result[0] + "\" (" + result[0].length() + ") | Longest: \"" + result[1] + "\" (" + result[1].length() + ")");
    }

    public static String[] findShortestAndLongestWord(String text) {
        String[] words = text.split("\\W+");
        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return new String[] { shortest, longest };
    }
}