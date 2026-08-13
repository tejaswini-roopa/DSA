import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleRow {

    int[][] dp;

    public List<Integer> getRow(int rowIndex) {
        dp = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i <= rowIndex; i++) {
            Arrays.fill(dp[i], -1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(solve(rowIndex, i));
        }
        return ans;
    }

    private int solve(int rowIndex, int colIndex) {
        if (colIndex == 0 || colIndex == rowIndex)
            return 1;
        if (dp[rowIndex][colIndex] != -1)
            return dp[rowIndex][colIndex];

        dp[rowIndex][colIndex] = solve(rowIndex - 1, colIndex - 1) + solve(rowIndex - 1, colIndex);
        return dp[rowIndex][colIndex];
    }

    public static void main(String[] args) {

        // Test 1: Expected [1, 3, 3, 1]
        PascalsTriangleRow sol1 = new PascalsTriangleRow();
        System.out.println(sol1.getRow(3));

        // Test 2: Expected [1]
        PascalsTriangleRow sol2 = new PascalsTriangleRow();
        System.out.println(sol2.getRow(0));

        // Test 3: Expected [1, 1]
        PascalsTriangleRow sol3 = new PascalsTriangleRow();
        System.out.println(sol3.getRow(1));

        // Test 4: Expected [1, 4, 6, 4, 1]
        PascalsTriangleRow sol4 = new PascalsTriangleRow();
        System.out.println(sol4.getRow(4));
    }
}
