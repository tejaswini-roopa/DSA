import java.util.Arrays;

public class LongestPalindromicSubsequence {

    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(s, 0, n - 1);
    }

    private int solve(String s, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + solve(s, i + 1, j - 1);
        } else {
            dp[i][j] = Math.max(solve(s, i + 1, j), solve(s, i, j - 1));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {

        // Test 1: Expected 4
        LongestPalindromicSubsequence sol1 = new LongestPalindromicSubsequence();
        System.out.println(sol1.longestPalindromeSubseq("bbbab"));

        // Test 2: Expected 2
        LongestPalindromicSubsequence sol2 = new LongestPalindromicSubsequence();
        System.out.println(sol2.longestPalindromeSubseq("cbbd"));

        // Test 3: Single char → Expected 1
        LongestPalindromicSubsequence sol3 = new LongestPalindromicSubsequence();
        System.out.println(sol3.longestPalindromeSubseq("a"));

        // Test 4: Already palindrome → Expected 5
        LongestPalindromicSubsequence sol4 = new LongestPalindromicSubsequence();
        System.out.println(sol4.longestPalindromeSubseq("racecar"));

        // Test 5: No repeats → Expected 1
        LongestPalindromicSubsequence sol5 = new LongestPalindromicSubsequence();
        System.out.println(sol5.longestPalindromeSubseq("abcd"));
    }
}
