import java.util.*;

class RainwaterTrapper {
    public int trap(final List<Integer> heights) {
        int n = heights.size();

        int[] maxPrefix = new int[n];
        int[] maxPostfix = new int[n];

        // Initialize first and last
        maxPrefix[0] = heights.get(0);
        maxPostfix[n - 1] = heights.get(n - 1);

        // Fill prefix max array (left to right)
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], heights.get(i));
        }

        // Fill postfix max array (right to left)
        for (int i = n - 2; i > 0; i--) {
            maxPostfix[i] = Math.max(maxPostfix[i + 1], heights.get(i));
        }

        // Calculate total trapped water
        int totalWater = 0;
        for (int i = 1; i < n - 1; i++) {
            int waterAtIndex = Math.min(maxPrefix[i - 1], maxPostfix[i + 1]) - heights.get(i);
            if (waterAtIndex > 0) {
                totalWater += waterAtIndex;
            }
        }

        return totalWater;
    }
}

public class TrappingRainWater {
    public static void main(String[] args) {
        RainwaterTrapper rainwaterTrapper = new RainwaterTrapper();

        // Test Case 1: [0,1,0,2,1,0,1,3,2,1,2,1] → Expected: 6
        List<Integer> testCase1 = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        runTestCase(rainwaterTrapper, testCase1, 1);

        // Test Case 2: [4,2,0,3,2,5] → Expected: 9
        List<Integer> testCase2 = Arrays.asList(4, 2, 0, 3, 2, 5);
        runTestCase(rainwaterTrapper, testCase2, 2);

        // Test Case 3: [1,0,1] → Expected: 1
        List<Integer> testCase3 = Arrays.asList(1, 0, 1);
        runTestCase(rainwaterTrapper, testCase3, 3);
    }

    private static void runTestCase(RainwaterTrapper trapper, List<Integer> heights, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + heights);
        int result = trapper.trap(heights);
        System.out.println("  Output : " + result + " units of water");
        System.out.println();
    }
}