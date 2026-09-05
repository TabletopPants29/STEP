package Step.Week4;

public class CategoryCProblems {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else if (prices[i] - lowestPrice > maximumProfit) {
                maximumProfit = prices[i] - lowestPrice;
            }
        }
        return maximumProfit;
    }

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        int resultIndex = 0;
        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] <= arr2[second]) {
                result[resultIndex++] = arr1[first++];
            } else {
                result[resultIndex++] = arr2[second++];
            }
        }
        while (first < arr1.length) {
            result[resultIndex++] = arr1[first++];
        }
        while (second < arr2.length) {
            result[resultIndex++] = arr2[second++];
        }
        return result;
    }

    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        int[] rotated = new int[nums.length];
        k %= nums.length;
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        return rotated;
    }
}
