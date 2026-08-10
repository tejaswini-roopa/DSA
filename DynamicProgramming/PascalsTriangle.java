import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    int[][] dp;

    public List<List<Integer>> generate(int numRows) {
        dp = new int[numRows + 1][numRows + 1];

        for (int i = 0; i <= numRows; i++) {
            Arrays.fill(dp[i], -1);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(solve(i, j));
            }
            ans.add(row);
        }

        return ans;
    }

    private int solve(int i, int j) {
        if (j == 0 || j == i)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = solve(i - 1, j - 1) + solve(i - 1, j);
        return dp[i][j];
    }

    public static void main(String[] args) {

        // Test 1: Expected [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        PascalsTriangle sol1 = new PascalsTriangle();
        System.out.println(sol1.generate(5));

        // Test 2: Expected [[1]]
        PascalsTriangle sol2 = new PascalsTriangle();
        System.out.println(sol2.generate(1));

        // Test 3: Expected [[1],[1,1]]
        PascalsTriangle sol3 = new PascalsTriangle();
        System.out.println(sol3.generate(2));

        // Test 4: 6 rows
        PascalsTriangle sol4 = new PascalsTriangle();
        System.out.println(sol4.generate(6));
    }
}
