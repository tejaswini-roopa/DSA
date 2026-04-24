import java.util.*;

public class CountDivisors {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A.get(i));
        }
        int spf[] = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            spf[i] = i;
        }
        for (int j = 2; j * j <= max; j++) {
            if (spf[j] == j) {
                for (int k = j * j; k <= max; k += j) {
                    if (spf[k] == k)
                        spf[k] = j;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int n1 = A.get(i);
            int total = 1;
            while (n1 > 1) {
                int count = 0;
                int p = spf[n1];
                while (n1 % p == 0) {
                    count++;
                    n1 /= p;
                }
                total = total * (1 + count);
            }
            result.add(total);
        }
        return result;
    }

    public static void main(String[] args) {
        CountDivisors solution = new CountDivisors();

        // Test Case 1: [2, 3, 4, 5] → Expected: [2, 2, 3, 2]
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [8, 9, 10] → Expected: [4, 3, 4]
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(8, 9, 10));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [1, 6, 12] → Expected: [1, 4, 6]
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1, 6, 12));
        runTestCase(solution, testCase3, 3);
    }

    private static void runTestCase(CountDivisors solution, ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        ArrayList<Integer> result = solution.solve(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}