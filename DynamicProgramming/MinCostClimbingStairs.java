public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return solve(cost, dp, n);
    }

    int solve(int[] cost, int[] dp, int n) {
        if (n == 0 || n == 1)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        int oneLess = solve(cost, dp, n - 1) + cost[n - 1];
        int twoLess = solve(cost, dp, n - 2) + cost[n - 2];

        dp[n] = Math.min(oneLess, twoLess);
        return dp[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs sol = new MinCostClimbingStairs();

        // Test 1: Expected 15
        System.out.println(sol.minCostClimbingStairs(new int[]{10, 15, 20}));

        // Test 2: Expected 6
        System.out.println(sol.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

        // Test 3: Two steps → Expected 0
        System.out.println(sol.minCostClimbingStairs(new int[]{0, 0}));

        // Test 4: Expected 1
        System.out.println(sol.minCostClimbingStairs(new int[]{1, 2, 3}));
    }
}
