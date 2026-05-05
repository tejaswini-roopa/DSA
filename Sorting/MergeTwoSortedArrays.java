import java.util.*;

public class MergeTwoSortedArrays {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        int m = A.size();
        int n = B.size();
        int p = 0;
        int q = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0; int j = 0;
        while (i < m && j < n) {
            if (A.get(i) < B.get(j)) {
                result.add(A.get(i));
                i++;
            } else {
                result.add(B.get(j));
                j++;
            }
        }
        while (i < m) {
            result.add(A.get(i));
            i++;
        }
        while (j < n) {
            result.add(B.get(j));
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays solution = new MergeTwoSortedArrays();

        // Test Case 1: A=[4,7,9], B=[2,11,19] → Expected: [2,4,7,9,11,19]
        List<Integer> A1 = Arrays.asList(4, 7, 9);
        List<Integer> B1 = Arrays.asList(2, 11, 19);
        runTestCase(solution, A1, B1, 1);

        // Test Case 2: A=[1], B=[2] → Expected: [1,2]
        List<Integer> A2 = Arrays.asList(1);
        List<Integer> B2 = Arrays.asList(2);
        runTestCase(solution, A2, B2, 2);

        // Test Case 3: A=[1,3,5], B=[2,4,6] → Expected: [1,2,3,4,5,6]
        List<Integer> A3 = Arrays.asList(1, 3, 5);
        List<Integer> B3 = Arrays.asList(2, 4, 6);
        runTestCase(solution, A3, B3, 3);

        // Test Case 4: A=[-5,-3,0], B=[-4,-1,2] → Expected: [-5,-4,-3,-1,0,2]
        List<Integer> A4 = Arrays.asList(-5, -3, 0);
        List<Integer> B4 = Arrays.asList(-4, -1, 2);
        runTestCase(solution, A4, B4, 4);
    }

    private static void runTestCase(MergeTwoSortedArrays solution,
                                     List<Integer> A, List<Integer> B,
                                     int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input A : " + A);
        System.out.println("  Input B : " + B);
        ArrayList<Integer> result = solution.solve(A, B);
        System.out.println("  Output  : " + result);
        System.out.println();
    }
}