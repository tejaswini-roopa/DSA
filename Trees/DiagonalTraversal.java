import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        if (A == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(A);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            while (curr != null) {
                result.add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                curr = curr.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DiagonalTraversal sol = new DiagonalTraversal();

        // Test 1: Expected [1, 2, 3, 4, 5, 7, 6, 8, 9]
        //             1
        //           /   \
        //          4      2
        //         / \      \
        //        8   5      3
        //           / \    /
        //          9   7  6
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(8);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(3);
        root1.left.right.left = new TreeNode(9);
        root1.left.right.right = new TreeNode(7);
        root1.right.right.left = new TreeNode(6);
        System.out.println(sol.solve(root1));

        // Test 2: Expected [11, 12, 13, 20, 15, 17, 16, 1, 2, 22, 34]
        //              11
        //           /     \
        //          20      12
        //         / \       \
        //        1   15      13
        //           /  \     /
        //          2    17  16
        //           \   /
        //           22 34
        TreeNode root2 = new TreeNode(11);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(12);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(15);
        root2.right.right = new TreeNode(13);
        root2.left.right.left = new TreeNode(2);
        root2.left.right.right = new TreeNode(17);
        root2.right.right.left = new TreeNode(16);
        root2.left.right.left.right = new TreeNode(22);
        root2.left.right.right.left = new TreeNode(34);
        System.out.println(sol.solve(root2));

        // Test 3: null → Expected []
        System.out.println(sol.solve(null));

        // Test 4: Single node → Expected [1]
        System.out.println(sol.solve(new TreeNode(1)));
    }
}
