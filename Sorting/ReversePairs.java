import java.util.*;

public class ReversePairs {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int c = 1000000007;
        return (int) (reversePair(A, 0, n - 1) % c);
    }

    long reversePair(ArrayList<Integer> A, int start, int end) {
        if (start >= end)
            return 0;
        int mid = (start + end) / 2;
        long count = 0;
        count += reversePair(A, start, mid);
        count += reversePair(A, mid + 1, end);
        int y = mid + 1;
        int x = start;
        while (x <= mid && y <= end) {
            long p = A.get(x);
            long q = 2 * (long) A.get(y);
            if (p > q) {
                count += (mid - x + 1);
                y++;
            } else {
                x++;
            }
        }
        merge(A, start, mid, end);
        return count;
    }

    private void merge(ArrayList<Integer> A, int start, int mid, int end) {
        ArrayList<Integer> A1 = new ArrayList<>();
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (A.get(i) <= A.get(j)) {
                A1.add(A.get(i));
                i++;
            } else {
                A1.add(A.get(j));
                j++;
            }
        }
        while (i <= mid) {
            A1.add(A.get(i));
            i++;
        }
        while (j <= end) {
            A1.add(A.get(j));
            j++;
        }
        for (int l = start; l <= end; l++) {
            A.set(l, A1.get(l - start));
        }
    }

    public static void main(String[] args) {
        ReversePairs solution = new ReversePairs();

        // Test Case 1: [1,3,2,3,1] → Expected: 2
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 1));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [4,1,2] → Expected: 1
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(4, 1, 2));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [6,3,1] → Expected: 3
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(6, 3, 1));
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [1,2,3] → Expected: 0
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(1, 2, 3));
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(ReversePairs solution,
                                     ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(new ArrayList<>(input));
        System.out.println("  Output : " + result);
        System.out.println();
    }
}