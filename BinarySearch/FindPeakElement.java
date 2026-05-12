import java.util.*;

public class FindPeakElement {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            int left = (m == 0) ? Integer.MIN_VALUE : A.get(m - 1);
            int right = (m == n - 1) ? Integer.MIN_VALUE : A.get(m + 1);

            if (A.get(m) >= left && A.get(m) >= right) {
                return A.get(m);
            } else if (A.get(m) >= left) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();

        // Test Case 1: [1,2,3,4,5] → Expected: 5
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [5,17,100,11] → Expected: 100
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [1] → Expected: 1
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1));
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [3,1] → Expected: 3
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(3, 1));
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(FindPeakElement solution,
                                     ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}