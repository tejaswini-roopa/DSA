import java.util.*;

public class InversionCount {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int m = 1000000007;
        long ans = sort(A, 0, n - 1);
        return (int) (ans % m);
    }

    public long sort(ArrayList<Integer> A, int s, int e) {
        if (s == e)
            return 0;
        int mid = (s + e) / 2;
        return sort(A, s, mid) + sort(A, mid + 1, e) + merge2SortedArrays(A, s, e);
    }

    public long merge2SortedArrays(ArrayList<Integer> A, int s, int e) {
        ArrayList<Integer> res = new ArrayList<>();
        int mid = (s + e) / 2;
        int i = s;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        while (i <= mid && j <= e) {
            if (A.get(i) <= A.get(j)) {
                res.add(A.get(i));
                k++;
                i++;
            } else {
                res.add(A.get(j));
                count += mid - i + 1;
                j++;
            }
        }
        while (i <= mid) {
            res.add(A.get(i));
            i++;
            k++;
        }
        while (j <= e) {
            res.add(A.get(j));
            j++;
            k++;
        }
        for (int p = s; p <= e; p++) {
            A.set(p, res.get(p - s));
        }
        return count;
    }

    public static void main(String[] args) {
        InversionCount solution = new InversionCount();

        // Test Case 1: [1,3,2] → Expected: 1
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(1, 3, 2));
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [3,4,1,2] → Expected: 4
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(3, 4, 1, 2));
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [5,4,3,2,1] → Expected: 10
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [1,2,3,4,5] → Expected: 0
        ArrayList<Integer> testCase4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(InversionCount solution,
                                     ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        int result = solution.solve(input);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}