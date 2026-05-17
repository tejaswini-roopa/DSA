public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        long MOD = 1000000007;
        long left = Math.min(a, b);
        long right = (long) n * Math.min(a, b);

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = function(a, b, mid);
            if (count >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left % MOD);
    }

    private long function(int a, int b, long mid) {
        long lcm = (long) a * b / gcd(a, b);
        long count = mid / a + mid / b - mid / lcm;
        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        NthMagicalNumber solution = new NthMagicalNumber();

        // Test Case 1: n=1, a=2, b=3 → Expected: 2
        runTestCase(solution, 1, 2, 3, 1);

        // Test Case 2: n=4, a=2, b=3 → Expected: 6
        runTestCase(solution, 4, 2, 3, 2);

        // Test Case 3: n=5, a=2, b=4 → Expected: 10
        runTestCase(solution, 5, 2, 4, 3);

        // Test Case 4: n=3, a=6, b=4 → Expected: 8
        runTestCase(solution, 3, 6, 4, 4);
    }

    private static void runTestCase(NthMagicalNumber solution,
                                     int n, int a, int b, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : n=" + n + ", a=" + a + ", b=" + b);
        int result = solution.nthMagicalNumber(n, a, b);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}