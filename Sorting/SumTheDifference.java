import java.util.*;

public class SumTheDifference {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int Mod = 1000 * 1000 * 1000 + 7;
        long minus = 0, plus = 0;
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            minus += (val * pow(2, A.size() - 1 - i, Mod)) % Mod;
            minus %= Mod;

            plus += (val * pow(2, i, Mod)) % Mod;
            plus %= Mod;
        }
        return (int) ((plus - minus + Mod) % Mod);
    }

    public long pow(long x, int y, int k) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }

    public static void main(String[] args) {
        SumTheDifference solution = new SumTheDifference();

        // Test Case 1: [1,2] → Expected: 1
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 2));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [3,5,10] → Expected: 21
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(3, 5, 10));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [1] → Expected: 0
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1));
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [1,2,3] → Expected: 6
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(1, 2, 3));
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(SumTheDifference solution,
                                     ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(new ArrayList<>(input));
        System.out.println("  Output : " + result);
        System.out.println();
    }
}