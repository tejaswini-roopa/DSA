import java.util.ArrayList;

public class ZeroOneKnapsack {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int m = A.size();
        int[][] dp = new int[m + 1][C + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(A, B, dp, m, C);
    }

    private int solve(ArrayList<Integer> A, ArrayList<Integer> B, int[][] dp, int m, int C) {
        if (m == 0)
            return 0;
        if (dp[m][C] != -1)
            return dp[m][C];

        int notTake = solve(A, B, dp, m - 1, C);
        int take = 0;

        if (B.get(m - 1) <= C) {
            take = A.get(m - 1) + solve(A, B, dp, m - 1, C - B.get(m - 1));
        }

        dp[m][C] = Math.max(take, notTake);
        return dp[m][C];
    }

    // Helper to build ArrayList
    static ArrayList<Integer> build(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr) list.add(val);
        return list;
    }

    public static void main(String[] args) {
        ZeroOneKnapsack sol = new ZeroOneKnapsack();

        // Test 1: Expected 220
        System.out.println(sol.solve(build(new int[]{60, 100, 120}), build(new int[]{10, 20, 30}), 50));

        // Test 2: Expected 0
        System.out.println(sol.solve(build(new int[]{10, 20, 30, 40}), build(new int[]{12, 13, 15, 19}), 10));

        // Test 3: Single item fits → Expected 10
        System.out.println(sol.solve(build(new int[]{10}), build(new int[]{5}), 5));

        // Test 4: All items fit → Expected 60
        System.out.println(sol.solve(build(new int[]{10, 20, 30}), build(new int[]{1, 2, 3}), 10));
    }
}
