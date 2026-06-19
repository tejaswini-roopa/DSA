import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 0) return 0;
        if (n == 1) return A.get(0);

        ArrayList<Integer> nsl = findNsl(A);
        ArrayList<Integer> nsr = findNsr(A);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int start = nsl.get(i) == -1 ? 0 : nsl.get(i) + 1;
            int end = nsr.get(i) == n ? n - 1 : nsr.get(i) - 1;

            int area = A.get(i) * (end - start + 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private ArrayList<Integer> findNsl(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> left = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) left.add(-1);
            else left.add(st.peek());
            st.push(i);
        }
        return left;
    }

    private ArrayList<Integer> findNsr(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> right = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) right.set(i, n);
            else right.set(i, st.peek());
            st.push(i);
        }
        return right;
    }

    // Helper to build ArrayList
    static ArrayList<Integer> build(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr) list.add(val);
        return list;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();

        // Test 1: Expected 10
        System.out.println(sol.largestRectangleArea(build(new int[]{2, 1, 5, 6, 2, 3})));

        // Test 2: Expected 2
        System.out.println(sol.largestRectangleArea(build(new int[]{2})));

        // Test 3: All same height → Expected 6
        System.out.println(sol.largestRectangleArea(build(new int[]{2, 2, 2})));

        // Test 4: Increasing → Expected 6
        System.out.println(sol.largestRectangleArea(build(new int[]{1, 2, 3})));

        // Test 5: Decreasing → Expected 6
        System.out.println(sol.largestRectangleArea(build(new int[]{3, 2, 1})));
    }
}
