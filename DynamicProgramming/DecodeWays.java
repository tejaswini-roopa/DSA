import java.util.Arrays;

public class DecodeWays {

    int[] dp;

    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(s, n);
    }

    private int solve(String s, int n) {
        if (n == 0)
            return 1;
        if (dp[n] != -1)
            return dp[n];

        int ans = 0;

        if (s.charAt(n - 1) != '0') {
            ans += solve(s, n - 1);
        }

        if (n >= 2) {
            int num = (s.charAt(n - 2) - '0') * 10
                    + (s.charAt(n - 1) - '0');
            if (num >= 10 && num <= 26) {
                ans += solve(s, n - 2);
            }
        }

        dp[n] = ans;
        return dp[n];
    }

    public static void main(String[] args) {

        // Test 1: Expected 2
        DecodeWays sol1 = new DecodeWays();
        System.out.println(sol1.numDecodings("12"));

        // Test 2: Expected 3
        DecodeWays sol2 = new DecodeWays();
        System.out.println(sol2.numDecodings("226"));

        // Test 3: Expected 0
        DecodeWays sol3 = new DecodeWays();
        System.out.println(sol3.numDecodings("06"));

        // Test 4: Single digit → Expected 1
        DecodeWays sol4 = new DecodeWays();
        System.out.println(sol4.numDecodings("1"));

        // Test 5: All zeros → Expected 0
        DecodeWays sol5 = new DecodeWays();
        System.out.println(sol5.numDecodings("100"));
    }
}
