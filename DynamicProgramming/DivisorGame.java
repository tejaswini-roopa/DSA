import java.util.Arrays;

public class DivisorGame {

    int[] dp;

    public boolean divisorGame(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    private boolean solve(int n) {
        if (n == 1)
            return false;
        if (dp[n] != -1)
            return dp[n] == 1;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                if (!solve(n - i)) {
                    dp[n] = 1;
                    return true;
                }
            }
        }
        dp[n] = 0;
        return false;
    }

    public static void main(String[] args) {
        DivisorGame sol = new DivisorGame();

        // Test 1: Expected true
        System.out.println(sol.divisorGame(2));

        // Test 2: Expected false
        sol = new DivisorGame();
        System.out.println(sol.divisorGame(3));

        // Test 3: Expected true
        sol = new DivisorGame();
        System.out.println(sol.divisorGame(4));

        // Test 4: Expected false
        sol = new DivisorGame();
        System.out.println(sol.divisorGame(1));

        // Test 5: Expected true
        sol = new DivisorGame();
        System.out.println(sol.divisorGame(6));
    }
}
