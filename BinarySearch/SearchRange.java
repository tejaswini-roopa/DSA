import java.util.*;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int first_Position = -1;
        int last_Position = -1;
        int result[] = new int[2];

        // Find first position
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                first_Position = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else
                l = mid + 1;
        }

        // Find last position
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                last_Position = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else
                l = mid + 1;
        }

        result[0] = first_Position;
        result[1] = last_Position;
        return result;
    }

    public static void main(String[] args) {
        SearchRange solution = new SearchRange();

        // Test Case 1: nums=[5,7,7,8,8,10], target=8 → Expected: [3,4]
        runTestCase(solution, new int[]{5, 7, 7, 8, 8, 10}, 8, 1);

        // Test Case 2: nums=[5,7,7,8,8,10], target=6 → Expected: [-1,-1]
        runTestCase(solution, new int[]{5, 7, 7, 8, 8, 10}, 6, 2);

        // Test Case 3: nums=[], target=0 → Expected: [-1,-1]
        runTestCase(solution, new int[]{}, 0, 3);

        // Test Case 4: nums=[1], target=1 → Expected: [0,0]
        runTestCase(solution, new int[]{1}, 1, 4);
    }

    private static void runTestCase(SearchRange solution,
                                     int[] nums, int target, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + Arrays.toString(nums));
        System.out.println("  Target : " + target);
        int[] result = solution.searchRange(nums, target);
        System.out.println("  Output : " + Arrays.toString(result));
        System.out.println();
    }
}