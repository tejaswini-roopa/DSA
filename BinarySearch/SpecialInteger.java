import java.util.*;

public class SpecialInteger {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int l = 0;
        int h = n;
        int ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(A, mid, B)) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return ans;
    }

    boolean isPossible(ArrayList<Integer> A, int mid, int B) {
        if (mid == 0) return true;
        int n = A.size();
        long sum = 0;
        for (int i = 0; i < mid; i++) {
            sum += A.get(i);
        }
        if (sum > B)
            return false;
        for (int j = mid; j < n; j++) {
            sum += A.get(j);
            sum -= A.get(j - mid);
            if (sum > B)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SpecialInteger solution = new SpecialInteger();

        // Test Case 1: A=[1,2,3,4,5], B=10 → Expected: 2
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        runTestCase(solution, testCase1, 10, 1);

        // Test Case 2: A=[5,17,100,11], B=130 → Expected: 3
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        runTestCase(solution, testCase2, 130, 2);

        // Test Case 3: A=[1,1,1,1,1], B=5 → Expected: 5
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        runTestCase(solution, testCase3, 5, 3);

        // Test Case 4: A=[10,20,30], B=5 → Expected: 0
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(10, 20, 30));
        runTestCase(solution, testCase4, 5, 4);
    }

    private static void runTestCase(SpecialInteger solution,
                                     ArrayList<Integer> A, int B, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input A : " + A);
        System.out.println("  Input B : " + B);
        int result = solution.solve(A, B);
        System.out.println("  Output  : " + result);
        System.out.println();
    }
}