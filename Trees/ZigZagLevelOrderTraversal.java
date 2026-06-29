import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

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

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean check = true;
        queue.offer(A);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            if (!check)
                Collections.reverse(list);
            ans.add(list);
            check = !check;
        }

        return ans;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal sol = new ZigZagLevelOrderTraversal();

        // Test 1: Expected [[3], [20, 9], [15, 7]]
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(sol.zigzagLevelOrder(root1));

        // Test 2: Single node → Expected [[1]]
        System.out.println(sol.zigzagLevelOrder(new TreeNode(1)));

        // Test 3: Expected [[1], [3, 2], [4, 5]]
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        System.out.println(sol.zigzagLevelOrder(root3));
    }
}
