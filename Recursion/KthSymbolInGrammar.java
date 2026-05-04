import java.util.*;

public class KthSymbolInGrammar {
    public int solve(int A, int B) {
        if (A == 1 || B == 1)
            return 0;
        int res = solve(A - 1, (B + 1) / 2);
        if (B % 2 == 1) {
            return res;
        }
        return (1 - res);
    }

    public static void main(String[] args) {
        KthSymbolInGrammar solution = new KthSymbolInGrammar();

        // Test Case 1: A=2, B=1 → Expected: 0
        runTestCase(solution, 2, 1, 1);

        // Test Case 2: A=2, B=2 → Expected: 1
        runTestCase(solution, 2, 2, 2);

        // Test Case 3: A=3, B=1 → Expected: 0
        // Row 1: 0
        // Row 2: 01
        // Row 3: 0110
        runTestCase(solution, 3, 1, 3);

        // Test Case 4: A=3, B=3 → Expected: 1
        runTestCase(solution, 3, 3, 4);

        // Test Case 5: A=4, B=5 → Expected: 1
        // Row 4: 01101001
        runTestCase(solution, 4, 5, 5);
    }

    private static void runTestCase(KthSymbolInGrammar solution,
                                     int A, int B, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : A=" + A + ", B=" + B);
        int result = solution.solve(A, B);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}