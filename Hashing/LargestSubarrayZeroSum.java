import java.util.*;

public class LargestSubarrayZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0;
        int l = -1;
        int r = -1;
        int len = 0;
        for (int i = 0; i < n; i++) {
            sum += A.get(i);
            if (sum == 0) {
                l = 0;
                r = i;
                len = i + 1;
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            } else {
                if (i - hm.get(sum) > len) {
                    l = hm.get(sum) + 1;
                    r = i;
                    len = i - hm.get(sum);
                }
            }
        }
        if (l >= 0 && r >= 0) {
            for (int i = l; i <= r; i++) {
                res.add(A.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestSubarrayZeroSum solution = new LargestSubarrayZeroSum();

        // Test Case 1: [1,2,-2,4,-4] → Expected: [2,-2,4,-4]
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [1,-1,3,-3,2] → Expected: [1,-1,3,-3]
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(1, -1, 3, -3, 2));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [1,2,3] → Expected: []
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [0] → Expected: [0]
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(0));
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(LargestSubarrayZeroSum solution,
                                     ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        ArrayList<Integer> result = solution.lszero(new ArrayList<>(input));
        System.out.println("  Output : " + result);
        System.out.println();
    }
}