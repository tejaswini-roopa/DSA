import java.util.*;

public class BoringSubstring {
    public int solve(String A) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            int p = A.charAt(i) - 'a';
            if (p % 2 == 0) even.add(p);
            else
                odd.add(p);
        }
        if (even.isEmpty() || odd.isEmpty()) return 1;
        Collections.sort(even);
        Collections.sort(odd);
        if (Math.abs(even.get(0) - odd.get(odd.size() - 1)) > 1 ||
                Math.abs(odd.get(0) - even.get(even.size() - 1)) > 1) return 1;
        return 0;
    }

    public static void main(String[] args) {
        BoringSubstring solution = new BoringSubstring();

        // Test Case 1: "abcd" → Expected: 1 (can rearrange to "cadb")
        runTestCase(solution, "abcd", 1);

        // Test Case 2: "aab" → Expected: 0 (no valid arrangement)
        runTestCase(solution, "aab", 2);

        // Test Case 3: "a" → Expected: 1 (single char, no boring substring)
        runTestCase(solution, "a", 3);

        // Test Case 4: "az" → Expected: 1 (not consecutive)
        runTestCase(solution, "az", 4);

        // Test Case 5: "ab" → Expected: 0 (a and b are consecutive)
        runTestCase(solution, "ab", 5);
    }

    private static void runTestCase(BoringSubstring solution,
                                     String input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}