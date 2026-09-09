public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();

        // Test 1: Expected 28
        System.out.println(sol.uniquePaths(3, 7));

        // Test 2: Expected 3
        System.out.println(sol.uniquePaths(3, 2));

        // Test 3: Expected 1
        System.out.println(sol.uniquePaths(1, 1));

        // Test 4: Expected 6
        System.out.println(sol.uniquePaths(3, 3));

        // Test 5: Expected 1
        System.out.println(sol.uniquePaths(1, 100));
    }
}
