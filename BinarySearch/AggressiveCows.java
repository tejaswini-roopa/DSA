import java.util.*;

public class AggressiveCows {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        Collections.sort(A);
        int lo = 1;
        int hi = A.get(n - 1) - A.get(0);
        int ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(mid, A, n, B)) {
                ans = mid;
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return ans;
    }

    boolean isPossible(int distance, ArrayList<Integer> A, int n, int B) {
        int cnt = 1;
        int last_cow = A.get(0);
        for (int i = 1; i < n; i++) {
            if (A.get(i) - last_cow >= distance) {
                cnt++;
                last_cow = A.get(i);
                if (cnt == B)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AggressiveCows solution = new AggressiveCows();

        // Test Case 1: A=[1,2,3,4,5], B=3 → Expected: 2
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        runTestCase(solution, testCase1, 3, 1);

        // Test Case 2: A=[1,2], B=2 → Expected: 1
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(1, 2));
        runTestCase(solution, testCase2, 2, 2);

        // Test Case 3: A=[1,2,4,8,9], B=3 → Expected: 3
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 9));
        runTestCase(solution, testCase3, 3, 3);

        // Test Case 4: A=[0,3,4,7,10,9], B=4 → Expected: 3
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(0, 3, 4, 7, 10, 9));
        runTestCase(solution, testCase4, 4, 4);
    }

    private static void runTestCase(AggressiveCows solution,
                                     ArrayList<Integer> A, int B, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input A : " + A);
        System.out.println("  Input B : " + B);
        int result = solution.solve(new ArrayList<>(A), B);
        System.out.println("  Output  : " + result);
        System.out.println();
    }
}