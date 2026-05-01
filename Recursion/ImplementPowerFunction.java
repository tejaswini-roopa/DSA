public class ImplementPowerFunction {
    public int pow(int A, int B, int C) {
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        long ans = pow(A, B / 2, C);
        ans = (ans * ans) % C;
        if (B % 2 == 0) {
            return (int) ((ans + C) % C);
        } else {
            return (int) (((ans * A) % C + C) % C);
        }
    }

    public static void main(String[] args) {
        ImplementPowerFunction solution = new ImplementPowerFunction();

        // Test Case 1: A=2, B=3, C=3 → Expected: 2 (2^3 % 3 = 8 % 3 = 2)
        runTestCase(solution, 2, 3, 3, 1);

        // Test Case 2: A=3, B=3, C=1 → Expected: 0 (3^3 % 1 = 27 % 1 = 0)
        runTestCase(solution, 3, 3, 1, 2);

        // Test Case 3: A=0, B=5, C=3 → Expected: 0
        runTestCase(solution, 0, 5, 3, 3);

        // Test Case 4: A=2, B=0, C=5 → Expected: 1 (anything^0 = 1)
        runTestCase(solution, 2, 0, 5, 4);

        // Test Case 5: A=-2, B=3, C=3 → Expected: 1 ((-2)^3 % 3 = -8 % 3 = 1)
        runTestCase(solution, -2, 3, 3, 5);
    }

    private static void runTestCase(ImplementPowerFunction solution,
                                     int A, int B, int C, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : A=" + A + ", B=" + B + ", C=" + C);
        int result = solution.pow(A, B, C);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}