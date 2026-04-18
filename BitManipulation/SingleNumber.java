import java.util.*;

class SingleNumberFinder {
    public int singleNumber(final List<Integer> A) {
        int n = A.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= A.get(i);
        }
        return ans;
    }
}

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumberFinder finder = new SingleNumberFinder();

        // Test Case 1: [1,2,2,3,1] → Expected: 3
        List<Integer> testCase1 = Arrays.asList(1, 2, 2, 3, 1);
        runTestCase(finder, testCase1, 1);

        // Test Case 2: [4,1,2,1,2] → Expected: 4
        List<Integer> testCase2 = Arrays.asList(4, 1, 2, 1, 2);
        runTestCase(finder, testCase2, 2);

        // Test Case 3: [7] → Expected: 7
        List<Integer> testCase3 = Arrays.asList(7);
        runTestCase(finder, testCase3, 3);
    }

    private static void runTestCase(SingleNumberFinder finder, List<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = finder.singleNumber(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}