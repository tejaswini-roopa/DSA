public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (n == 2)
            return 2;
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        return solve(n, dp);
    }

    int solve(int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();

        // Test 1: Expected 2
        System.out.println(sol.climbStairs(2));

        // Test 2: Expected 3
        System.out.println(sol.climbStairs(3));

        // Test 3: Expected 1
        System.out.println(sol.climbStairs(1));

        // Test 4: Expected 8
        System.out.println(sol.climbStairs(5));

        // Test 5: Expected 1836311903
        System.out.println(sol.climbStairs(45));
    }
}
