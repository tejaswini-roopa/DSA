import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(dp, word1, word2, m, n);
    }

    private int solve(int[][] dp, String word1, String word2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (dp[m][n] != -1)
            return dp[m][n];

        if (word1.charAt(m - 1) == word2.charAt(n - 1))
            dp[m][n] = solve(dp, word1, word2, m - 1, n - 1);
        else {
            int replace = solve(dp, word1, word2, m - 1, n - 1);
            int delete  = solve(dp, word1, word2, m - 1, n);
            int insert  = solve(dp, word1, word2, m, n - 1);
            dp[m][n] = 1 + Math.min(replace, Math.min(delete, insert));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance sol = new EditDistance();

        // Test 1: Expected 3
        System.out.println(sol.minDistance("horse", "ros"));

        // Test 2: Expected 5
        System.out.println(sol.minDistance("intention", "execution"));

        // Test 3: Empty word1 → Expected 3
        System.out.println(sol.minDistance("", "abc"));

        // Test 4: Empty word2 → Expected 3
        System.out.println(sol.minDistance("abc", ""));

        // Test 5: Same strings → Expected 0
        System.out.println(sol.minDistance("abc", "abc"));
    }
}
