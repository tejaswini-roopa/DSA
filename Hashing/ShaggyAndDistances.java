import java.util.*;

public class ShaggyAndDistances {
    public int solve(ArrayList<Integer> A) {
        int count = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(A.get(i))) {
                hm.put(A.get(i), i);
            } else {
                count = Math.min(i - hm.get(A.get(i)), count);
                hm.put(A.get(i), i);
            }
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public static void main(String[] args) {
        ShaggyAndDistances solution = new ShaggyAndDistances();

        // Test Case 1: [7,1,3,4,1,7] → Expected: 3
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(7, 1, 3, 4, 1, 7));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [1,1] → Expected: 1
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(1, 1));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [1,2,3] → Expected: -1 (no special pair)
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [1,2,1,2,1] → Expected: 2
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1));
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(ShaggyAndDistances solution,
                                     ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(new ArrayList<>(input));
        System.out.println("  Output : " + result);
        System.out.println();
    }
}