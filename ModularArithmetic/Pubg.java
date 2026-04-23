import java.util.*;

public class Pubg {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int solve(ArrayList<Integer> A) {
        int res = 0;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            res = gcd(res, A.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Pubg solution = new Pubg();

        // Test Case 1: [6, 4] → Expected: 2
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(6, 4));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [2, 3, 4] → Expected: 1
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(2, 3, 4));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [4, 6, 8] → Expected: 2
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(4, 6, 8));
        runTestCase(solution, testCase3, 3);
    }

    private static void runTestCase(Pubg solution, ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}