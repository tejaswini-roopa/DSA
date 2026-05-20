import java.util.*;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i < j) {
            ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test Case 1: [1,8,6,2,5,4,8,3,7] → Expected: 49
        runTestCase(solution, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 1);

        // Test Case 2: [1,1] → Expected: 1
        runTestCase(solution, new int[]{1, 1}, 2);

        // Test Case 3: [4,3,2,1,4] → Expected: 16
        runTestCase(solution, new int[]{4, 3, 2, 1, 4}, 3);

        // Test Case 4: [1,2,1] → Expected: 2
        runTestCase(solution, new int[]{1, 2, 1}, 4);
    }

    private static void runTestCase(ContainerWithMostWater solution,
                                     int[] height, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + Arrays.toString(height));
        int result = solution.maxArea(height);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}