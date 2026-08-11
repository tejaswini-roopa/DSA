public class UniqueBSTs {

    int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int ans = 0;
            for (int j = 0; j < i; j++) {
                ans += dp[j] * dp[i - j - 1];
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {

        // Test 1: Expected 5
        UniqueBSTs sol1 = new UniqueBSTs();
        System.out.println(sol1.numTrees(3));

        // Test 2: Expected 1
        UniqueBSTs sol2 = new UniqueBSTs();
        System.out.println(sol2.numTrees(1));

        // Test 3: Expected 2
        UniqueBSTs sol3 = new UniqueBSTs();
        System.out.println(sol3.numTrees(2));

        // Test 4: Expected 14
        UniqueBSTs sol4 = new UniqueBSTs();
        System.out.println(sol4.numTrees(4));

        // Test 5: Expected 1430
        UniqueBSTs sol5 = new UniqueBSTs();
        System.out.println(sol5.numTrees(10));
    }
}
