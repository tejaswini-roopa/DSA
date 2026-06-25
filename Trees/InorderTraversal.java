import java.util.ArrayList;

public class InorderTraversal {

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

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(A, list);
        return list;
    }

    void inorderTraversal(TreeNode A, ArrayList<Integer> list) {
        if (A == null)
            return;
        inorderTraversal(A.left, list);
        list.add(A.val);
        inorderTraversal(A.right, list);
    }

    public static void main(String[] args) {
        InorderTraversal sol = new InorderTraversal();

        // Test 1: Expected [1, 3, 2]
        //    1
        //     \
        //      2
        //     /
        //    3
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println(sol.inorderTraversal(root1));

        // Test 2: Expected [6, 1, 3, 2]
        //    1
        //   / \
        //  6   2
        //     /
        //    3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(3);
        System.out.println(sol.inorderTraversal(root2));

        // Test 3: Single node → Expected [1]
        System.out.println(sol.inorderTraversal(new TreeNode(1)));

        // Test 4: null → Expected []
        System.out.println(sol.inorderTraversal(null));
    }
}
