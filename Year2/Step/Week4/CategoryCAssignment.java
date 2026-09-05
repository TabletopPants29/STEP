package Step.Week4;

public class CategoryCAssignment {
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }

    public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current + nums[i] < nums[i]) {
                current = nums[i];
            } else {
                current += nums[i];
            }
            if (current > maximum) {
                maximum = current;
            }
        }
        return maximum;
    }

    public static int[][] threeSum(int[] nums) {
        int[][] triplets = new int[nums.length * nums.length][3];
        int tripletCount = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum != 0) {
                        continue;
                    }
                    int first = nums[i];
                    int second = nums[j];
                    int third = nums[k];
                    if (first > second) {
                        int value = first;
                        first = second;
                        second = value;
                    }
                    if (second > third) {
                        int value = second;
                        second = third;
                        third = value;
                    }
                    if (first > second) {
                        int value = first;
                        first = second;
                        second = value;
                    }
                    boolean alreadyFound = false;
                    for (int existing = 0; existing < tripletCount; existing++) {
                        if (triplets[existing][0] == first && triplets[existing][1] == second && triplets[existing][2] == third) {
                            alreadyFound = true;
                            break;
                        }
                    }
                    if (alreadyFound) {
                        continue;
                    }
                    triplets[tripletCount][0] = first;
                    triplets[tripletCount][1] = second;
                    triplets[tripletCount][2] = third;
                    tripletCount++;
                }
            }
        }
        int[][] result = new int[tripletCount][3];
        for (int i = 0; i < tripletCount; i++) {
            result[i][0] = triplets[i][0];
            result[i][1] = triplets[i][1];
            result[i][2] = triplets[i][2];
        }
        return result;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int findMin(int[] nums) {
        int minimum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minimum) {
                minimum = nums[i];
            }
        }
        return minimum;
    }
}
