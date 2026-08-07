import java.util.Arrays;

public class CountingBits {

    int[] dp;

    public int[] countBits(int n) {
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i <= n; i++) {
            solve(i, dp);
        }
        return dp;
    }

    private int solve(int n, int[] dp) {
        if (n == 0)
            return dp[0] = 0;
        if (n == 1)
            return dp[1] = 1;
        if (dp[n] != -1)
            return dp[n];

        dp[n] = solve(n / 2, dp) + (n % 2);
        return dp[n];
    }

    public static void main(String[] args) {
        CountingBits sol = new CountingBits();

        // Test 1: Expected [0, 1, 1]
        System.out.println(Arrays.toString(sol.countBits(2)));

        // Test 2: Expected [0, 1, 1, 2, 1, 2]
        sol = new CountingBits();
        System.out.println(Arrays.toString(sol.countBits(5)));

        // Test 3: Expected [0]
        sol = new CountingBits();
        System.out.println(Arrays.toString(sol.countBits(0)));

        // Test 4: Expected [0, 1, 1, 2, 1, 2, 2, 3, 1, 2]
        sol = new CountingBits();
        System.out.println(Arrays.toString(sol.countBits(9)));
    }
}
