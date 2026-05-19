import java.util.*;

public class KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = 1;
        int count = 0, sum = Integer.MIN_VALUE;
        while (j < n) {
            int diff = Math.abs(nums[j] - nums[i]);
            if (diff == k && (nums[i] + nums[j]) != sum) {
                sum = nums[i] + nums[j];
                count++;
                i++;
                j++;
            } else if (diff < k) {
                j++;
            } else {
                i++;
                if (i == j)
                    j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KDiffPairsInArray solution = new KDiffPairsInArray();

        // Test Case 1: nums=[3,1,4,1,5], k=2 → Expected: 2
        runTestCase(solution, new int[]{3, 1, 4, 1, 5}, 2, 1);

        // Test Case 2: nums=[1,2,3,4,5], k=1 → Expected: 4
        runTestCase(solution, new int[]{1, 2, 3, 4, 5}, 1, 2);

        // Test Case 3: nums=[1,3,1,5,4], k=0 → Expected: 1
        runTestCase(solution, new int[]{1, 3, 1, 5, 4}, 0, 3);

        // Test Case 4: nums=[1,2,4,4,3,3,0,9,2,3], k=3 → Expected: 2
        runTestCase(solution, new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3, 4);
    }

    private static void runTestCase(KDiffPairsInArray solution,
                                     int[] nums, int k, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + Arrays.toString(nums));
        System.out.println("  k      : " + k);
        int result = solution.findPairs(nums, k);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}