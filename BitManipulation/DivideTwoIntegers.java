import java.util.Scanner;

public class DivideTwoIntegers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        // Create object and call method
        Solution solution = new Solution();
        int result = solution.divide(dividend, divisor);

        // Print result
        System.out.println("Quotient: " + result);

        scanner.close();
    }
}

class Solution {

    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dividendLong = dividend;
        long divisorLong = divisor;

        // Determine sign
        int sign = 1;
        if (dividendLong < 0) sign = -sign;
        if (divisorLong < 0) sign = -sign;

        // Convert to positive
        dividendLong = Math.abs(dividendLong);
        divisorLong = Math.abs(divisorLong);

        long quotient = 0;

        // Bit manipulation
        for (int i = 31; i >= 0; i--) {
            if ((divisorLong << i) <= dividendLong) {
                dividendLong -= (divisorLong << i);
                quotient += (1L << i);
            }
        }

        // Apply sign
        if (sign < 0) {
            quotient = -quotient;
        }

        // Clamp to integer range
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) quotient;
    }
}