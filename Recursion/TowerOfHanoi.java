import java.util.*;

public class TowerOfHanoi {
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        return tower(A, 1, 3, 2);
    }

    ArrayList<ArrayList<Integer>> tower(int n, int start, int end, int helper) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (n == 1) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            res.add(start);
            res.add(end);
            ans.add(res);
            return ans;
        }
        ans.addAll(tower(n - 1, start, helper, end));
        ArrayList<Integer> middle = new ArrayList<>();
        middle.add(n);
        middle.add(start);
        middle.add(end);
        ans.add(middle);
        ans.addAll(tower(n - 1, helper, end, start));
        return ans;
    }

    public static void main(String[] args) {
        TowerOfHanoi solution = new TowerOfHanoi();

        // Test Case 1: A=1 → Expected: [[1,1,3]]
        runTestCase(solution, 1);

        // Test Case 2: A=2 → Expected: [[1,1,2],[2,1,3],[1,2,3]]
        runTestCase(solution, 2);

        // Test Case 3: A=3 → Expected: 7 moves
        runTestCase(solution, 3);
    }

    private static void runTestCase(TowerOfHanoi solution, int input) {
        System.out.println("Test Case: A = " + input);
        ArrayList<ArrayList<Integer>> result = solution.towerOfHanoi(input);
        System.out.println("  Total Moves : " + result.size());
        System.out.println("  Moves       :");
        for (ArrayList<Integer> move : result) {
            System.out.println("    Disk " + move.get(0) +
                    " : Rod " + move.get(1) +
                    " → Rod " + move.get(2));
        }
        System.out.println();
    }
}