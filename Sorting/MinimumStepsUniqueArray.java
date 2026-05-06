import java.util.*;

public class MinimumStepsUniqueArray {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (A.get(i) <= A.get(i - 1)) {
                int newValue = A.get(i - 1) + 1;
                count += newValue - A.get(i);
                A.set(i, newValue);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumStepsUniqueArray solution = new MinimumStepsUniqueArray();

        // Test Case 1: [1,1,3] → Expected: 1
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 1, 3));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [2,4,5] → Expected: 0
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(2, 4, 5));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [1,1,1] → Expected: 3
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1, 1, 1));
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [3,2,1,2,1,7] → Expected: 6
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(3, 2, 1, 2, 1, 7));
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(MinimumStepsUniqueArray solution,
                                     ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}