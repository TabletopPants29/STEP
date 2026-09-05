package Step.Week5;

public class CategoryCAssignment {
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static String findDuplicatePick(String[] playerNames) {
        for (int first = 0; first < playerNames.length; first++) {
            for (int second = first + 1; second < playerNames.length; second++) {
                if (playerNames[first].equals(playerNames[second])) {
                    return "Duplicate Found: " + playerNames[first];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static String findMinMaxSpread(int[] scores) {
        int minimum = scores[0];
        int maximum = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minimum) {
                minimum = scores[i];
            }
            if (scores[i] > maximum) {
                maximum = scores[i];
            }
        }
        return "Min: " + minimum + " | Max: " + maximum + " | Spread: " + (maximum - minimum);
    }

    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        int total = 0;
        for (int value : row) {
            total += value;
        }
        return (double) total / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ");
            if (rowAverage(runsPerOver[i]) >= threshold) {
                result.append("Power Surge");
            } else {
                result.append("Normal");
            }
        }
        return result.toString();
    }
}