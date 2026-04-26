import java.util.*;

public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        int[] primes = new int[A + 1];
        for (int i = 2; i <= A; i++) {
            primes[i] = 1;
        }
        for (int i = 2; i * i <= A; i++) {
            if (primes[i] == 1) {
                for (int j = i * i; j <= A; j += i) {
                    primes[j] = 0;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= A / 2; i++) {
            if (primes[i] == 1 && primes[A - i] == 1) {
                result.add(i);
                result.add(A - i);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrimeSum solution = new PrimeSum();

        // Test Case 1: 4 → Expected: [2, 2]
        runTestCase(solution, 4, 1);

        // Test Case 2: 10 → Expected: [3, 7]
        runTestCase(solution, 10, 2);

        // Test Case 3: 20 → Expected: [3, 17]
        runTestCase(solution, 20, 3);

        // Test Case 4: 100 → Expected: [3, 97]
        runTestCase(solution, 100, 4);
    }

    private static void runTestCase(PrimeSum solution, int input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        ArrayList<Integer> result = solution.primesum(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}