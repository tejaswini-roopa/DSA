import java.util.ArrayList;
import java.util.Arrays;

public class UnboundedKnapsack {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int n = B.size();
        int[][] dp = new int[n + 1][A + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return cal(A, B, C, dp, n);
    }

    private int cal(int A, ArrayList<Integer> B, ArrayList<Integer> C, int[][] dp, int n) {
        if (n == 0)
            return 0;
        if (dp[n][A] != -1)
            return dp[n][A];

        int notTake = cal(A, B, C, dp, n - 1);
        int take = 0;

        if (C.get(n - 1) <= A) {
            take = B.get(n - 1) + cal(A - C.get(n - 1), B, C, dp, n);
        }

        dp[n][A] = Math.max(take, notTake);
        return dp[n][A];
    }

    // Helper to build ArrayList
    static ArrayList<Integer> build(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr) list.add(val);
        return list;
    }

    public static void main(String[] args) {
        UnboundedKnapsack sol = new UnboundedKnapsack();

        // Test 1: Expected 5
        System.out.println(sol.solve(10, build(new int[]{5}), build(new int[]{10})));

        // Test 2: Expected 14
        System.out.println(sol.solve(10, build(new int[]{6, 7}), build(new int[]{5, 5})));

        // Test 3: Expected 10
        System.out.println(sol.solve(10, build(new int[]{1, 6}), build(new int[]{1, 5})));

        // Test 4: Weight too heavy → Expected 0
        System.out.println(sol.solve(3, build(new int[]{10}), build(new int[]{5})));
    }
}
