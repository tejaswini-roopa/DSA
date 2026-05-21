import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        int res[] = new int[2];
        Arrays.sort(nums);
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (sum < target)
                i++;
            else
                j--;
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test Case 1: nums=[2,7,11,15], target=9 → Expected: [0,1]
        runTestCase(solution, new int[]{2, 7, 11, 15}, 9, 1);

        // Test Case 2: nums=[3,2,4], target=6 → Expected: [1,2]
        runTestCase(solution, new int[]{3, 2, 4}, 6, 2);

        // Test Case 3: nums=[3,3], target=6 → Expected: [0,1]
        runTestCase(solution, new int[]{3, 3}, 6, 3);

            }

    private static void runTestCase(TwoSum solution,
                                     int[] nums, int target, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + Arrays.toString(nums));
        System.out.println("  Target : " + target);
        int[] result = solution.twoSum(nums.clone(), target);
        System.out.println("  Output : " + Arrays.toString(result));
        System.out.println();
    }
}