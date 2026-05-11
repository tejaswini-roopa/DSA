import java.util.*;

public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int n = A.size();
        int l = 0;
        int h = n - 1;
        int ans = n;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (A.get(mid) > B) {
                h = mid - 1;
                ans = Math.min(ans, mid);
            } else if (A.get(mid) < B) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SortedInsertPosition solution = new SortedInsertPosition();

        // Test Case 1: A=[1,3,5,6], B=5 → Expected: 2 (found at index 2)
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        runTestCase(solution, testCase1, 5, 1);

        // Test Case 2: A=[1,4,9], B=3 → Expected: 1 (insert at index 1)
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(1, 4, 9));
        runTestCase(solution, testCase2, 3, 2);

        // Test Case 3: A=[1,3,5,6], B=7 → Expected: 4 (insert at end)
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        runTestCase(solution, testCase3, 7, 3);

        // Test Case 4: A=[1,3,5,6], B=0 → Expected: 0 (insert at beginning)
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        runTestCase(solution, testCase4, 0, 4);
    }

    private static void runTestCase(SortedInsertPosition solution,
                                     ArrayList<Integer> A, int B, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input A : " + A);
        System.out.println("  Input B : " + B);
        int result = solution.searchInsert(A, B);
        System.out.println("  Output  : " + result);
        System.out.println();
    }
}