import java.util.*;

public class CountRightTriangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        long mod = 1000000007;
        long ans = 0;
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            xMap.put(A.get(i), xMap.getOrDefault(A.get(i), 0) + 1);
            yMap.put(B.get(i), yMap.getOrDefault(B.get(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            long x_count = xMap.get(A.get(i)) - 1;
            long y_count = yMap.get(B.get(i)) - 1;
            ans = (ans + (x_count * y_count) % mod) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        CountRightTriangles solution = new CountRightTriangles();

        // Test Case 1: A=[1,1,2], B=[1,2,1] → Expected: 1
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 1, 2));
        ArrayList<Integer> B1 = new ArrayList<>(Arrays.asList(1, 2, 1));
        runTestCase(solution, A1, B1, 1);

        // Test Case 2: A=[1,1,2,3,3], B=[1,2,1,2,1] → Expected: 6
        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3));
        ArrayList<Integer> B2 = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1));
        runTestCase(solution, A2, B2, 2);

        // Test Case 3: All unique x and y → Expected: 0
        ArrayList<Integer> A3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B3 = new ArrayList<>(Arrays.asList(4, 5, 6));
        runTestCase(solution, A3, B3, 3);

        // Test Case 4: A=[1,1,1], B=[1,2,3] → Expected: 0
        ArrayList<Integer> A4 = new ArrayList<>(Arrays.asList(1, 1, 1));
        ArrayList<Integer> B4 = new ArrayList<>(Arrays.asList(1, 2, 3));
        runTestCase(solution, A4, B4, 4);
    }

    private static void runTestCase(CountRightTriangles solution,
                                     ArrayList<Integer> A, ArrayList<Integer> B,
                                     int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input A : " + A);
        System.out.println("  Input B : " + B);
        int result = solution.solve(A, B);
        System.out.println("  Output  : " + result);
        System.out.println();
    }
}