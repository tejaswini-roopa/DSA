import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(dp, text1, text2, m, n);
    }

    private int solve(int[][] dp, String text1, String text2, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            dp[m][n] = 1 + solve(dp, text1, text2, m - 1, n - 1);
        } else {
            dp[m][n] = Math.max(solve(dp, text1, text2, m - 1, n), solve(dp, text1, text2, m, n - 1));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();

        // Test 1: Expected 3
        System.out.println(sol.longestCommonSubsequence("abcde", "ace"));

        // Test 2: Expected 3
        System.out.println(sol.longestCommonSubsequence("abc", "abc"));

        // Test 3: Expected 0
        System.out.println(sol.longestCommonSubsequence("abc", "def"));

        // Test 4: Expected 1
        System.out.println(sol.longestCommonSubsequence("a", "a"));

        // Test 5: Expected 0
        System.out.println(sol.longestCommonSubsequence("a", "b"));
    }
}
