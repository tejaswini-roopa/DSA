import java.util.*;

public class KthSmallestPrice {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A, int B) {
        int min = A.get(0);
        int max = A.get(0);
        for (int num : A) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }
        int left = min;
        int right = max;
        int ans = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : A) {
                if (num <= mid)
                    count++;
            }
            if (count >= B) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KthSmallestPrice solution = new KthSmallestPrice();

        // Test Case 1: A=[2,1,4,3,2], k=3 → Expected: 2
        List<Integer> testCase1 = Arrays.asList(2, 1, 4, 3, 2);
        runTestCase(solution, testCase1, 3, 1);

        // Test Case 2: A=[1,2,3,4,5], k=2 → Expected: 2
        List<Integer> testCase2 = Arrays.asList(1, 2, 3, 4, 5);
        runTestCase(solution, testCase2, 2, 2);

        // Test Case 3: A=[5,5,5,5], k=3 → Expected: 5
        List<Integer> testCase3 = Arrays.asList(5, 5, 5, 5);
        runTestCase(solution, testCase3, 3, 3);

        // Test Case 4: A=[3,1,2,4,5], k=1 → Expected: 1
        List<Integer> testCase4 = Arrays.asList(3, 1, 2, 4, 5);
        runTestCase(solution, testCase4, 1, 4);
    }

    private static void runTestCase(KthSmallestPrice solution,
                                     List<Integer> A, int B, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input A : " + A);
        System.out.println("  Input k : " + B);
        int result = solution.solve(A, B);
        System.out.println("  Output  : " + result);
        System.out.println();
    }
}