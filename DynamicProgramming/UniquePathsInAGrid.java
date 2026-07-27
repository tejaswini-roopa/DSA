import java.util.ArrayList;
import java.util.Arrays;

public class UniquePathsInAGrid {

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(A, dp, m - 1, n - 1);
    }

    int solve(ArrayList<ArrayList<Integer>> A, int[][] dp, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        if (A.get(m).get(n) == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (dp[m][n] != -1)
            return dp[m][n];
        dp[m][n] = solve(A, dp, m - 1, n) + solve(A, dp, m, n - 1);
        return dp[m][n];
    }

    // Helper to build grid
    static ArrayList<ArrayList<Integer>> build(int[][] arr) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        for (int[] row : arr) {
            ArrayList<Integer> r = new ArrayList<>();
            for (int val : row) r.add(val);
            grid.add(r);
        }
        return grid;
    }

    public static void main(String[] args) {
        UniquePathsInAGrid sol = new UniquePathsInAGrid();

        // Test 1: Expected 2
        System.out.println(sol.uniquePathsWithObstacles(build(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        })));

        // Test 2: Expected 0
        System.out.println(sol.uniquePathsWithObstacles(build(new int[][]{
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 0}
        })));

        // Test 3: No obstacles → Expected 6
        System.out.println(sol.uniquePathsWithObstacles(build(new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        })));

        // Test 4: Start blocked → Expected 0
        System.out.println(sol.uniquePathsWithObstacles(build(new int[][]{
            {1, 0},
            {0, 0}
        })));
    }
}
