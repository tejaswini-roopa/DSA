public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int B = amount;
        int[][] dp = new int[n + 1][B + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= B; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = solve(coins, amount, dp, n);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int[] A, int B, int[][] dp, int n) {
        if (B == 0)
            return 0;
        if (n <= 0)
            return Integer.MAX_VALUE;
        if (dp[n][B] != -1)
            return dp[n][B];

        int notTake = solve(A, B, dp, n - 1);
        int take = Integer.MAX_VALUE;

        if (A[n - 1] <= B) {
            int res = solve(A, B - A[n - 1], dp, n);
            if (res != Integer.MAX_VALUE)
                take = 1 + res;
        }

        dp[n][B] = Math.min(take, notTake);
        return dp[n][B];
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();

        // Test 1: Expected 3
        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 11));

        // Test 2: Expected -1
        System.out.println(sol.coinChange(new int[]{2}, 3));

        // Test 3: Expected 0
        System.out.println(sol.coinChange(new int[]{1}, 0));

        // Test 4: Expected 2
        System.out.println(sol.coinChange(new int[]{1, 5, 6, 9}, 11));

        // Test 5: Large amount → Expected 20
        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 100));
    }
}
