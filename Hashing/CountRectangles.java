import java.util.*;

public class CountRectangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int ans = 0;
        HashMap<Integer, HashSet<Integer>> hms = new HashMap<>();
        HashSet<Integer> h;
        for (int i = 0; i < n; i++) {
            if (hms.containsKey(A.get(i)))
                h = hms.get(A.get(i));
            else {
                h = new HashSet<>();
            }
            h.add(B.get(i));
            hms.put(A.get(i), h);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(i).equals(A.get(j)) || B.get(i).equals(B.get(j)))
                    continue;
                if (hms.get(A.get(i)).contains(B.get(j)) && hms.get(A.get(j)).contains(B.get(i)))
                    ans++;
            }
        }
        return ans / 2;
    }

    public static void main(String[] args) {
        CountRectangles solution = new CountRectangles();

        // Test Case 1: A=[1,1,2,2], B=[1,2,1,2] → Expected: 1
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
        ArrayList<Integer> B1 = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
        runTestCase(solution, A1, B1, 1);

        // Test Case 2: A=[1,1,2,2,3,3], B=[1,2,1,2,1,2] → Expected: 3
        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3));
        ArrayList<Integer> B2 = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 2));
        runTestCase(solution, A2, B2, 2);

        // Test Case 3: No rectangles possible → Expected: 0
        ArrayList<Integer> A3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        runTestCase(solution, A3, B3, 3);
    }

    private static void runTestCase(CountRectangles solution,
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