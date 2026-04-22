import java.util.*;

public class MaximumGcd {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int prefix_gcd[] = new int[n];
        int postfix_gcd[] = new int[n];
        prefix_gcd[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            prefix_gcd[i] = gcd(prefix_gcd[i - 1], A.get(i));
        }
        postfix_gcd[n - 1] = A.get(n - 1);
        for (int j = n - 2; j >= 1; j--) {
            postfix_gcd[j] = gcd(postfix_gcd[j + 1], A.get(j));
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max = Math.max(max, postfix_gcd[i + 1]);
            } else if (i == n - 1) {
                max = Math.max(max, prefix_gcd[i - 1]);
            } else {
                int currentGcd = gcd(prefix_gcd[i - 1], postfix_gcd[i + 1]);
                max = Math.max(max, currentGcd);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumGcd solution = new MaximumGcd();

        // Test Case 1: [12, 6, 3, 9] → Expected: 6
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(12, 6, 3, 9));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [2, 4, 6, 8] → Expected: 6
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        runTestCase(solution, testCase2, 2);