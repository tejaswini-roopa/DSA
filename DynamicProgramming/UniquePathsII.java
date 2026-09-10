import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(m, n, dp, obstacleGrid);
    }

    private int solve(int m, int n, int[][] dp, int[][] obstacleGrid) {
        if (m <= 0 || n <= 0)
            return 0;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if (dp[m][n] != -1)
            return dp[m][n];

        dp[m][n] = solve(m - 1, n, dp, obstacleGrid) + solve(m, n - 1, dp, obstacleGrid);
        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePathsII sol = new UniquePathsII();

        // Test 1: Expected 2
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        }));

        // Test 2: Expected 1
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{
            {0, 1},
            {0, 0}
        }));

        // Test 3: Start blocked → Expected 0
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{
            {1, 0},
            {0, 0}
        }));

        // Test 4: End blocked → Expected 0
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{
            {0, 0},
            {0, 1}
        }));

        // Test 5: No obstacles → Expected 6
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        }));
    }
}
