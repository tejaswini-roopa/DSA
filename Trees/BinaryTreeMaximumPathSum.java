public class BinaryTreeMaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int curr = root.val + Math.max(left, 0) + Math.max(right, 0);

        ans = Math.max(ans, curr);

        return root.val + Math.max(0, Math.max(left, right));
    }

    public static void main(String[] args) {

        // Test 1: Expected 6
        //     1
        //    / \
        //   2   3
        BinaryTreeMaximumPathSum sol1 = new BinaryTreeMaximumPathSum();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(sol1.maxPathSum(root1));

        // Test 2: Expected 42
        //      -10
        //      /  \
        //     9   20
        //        /  \
        //       15   7
        BinaryTreeMaximumPathSum sol2 = new BinaryTreeMaximumPathSum();
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(sol2.maxPathSum(root2));

        // Test 3: All negative → Expected -3
        BinaryTreeMaximumPathSum sol3 = new BinaryTreeMaximumPathSum();
        TreeNode root3 = new TreeNode(-3);
        System.out.println(sol3.maxPathSum(root3));

        // Test 4: Single node → Expected 5
        BinaryTreeMaximumPathSum sol4 = new BinaryTreeMaximumPathSum();
        System.out.println(sol4.maxPathSum(new TreeNode(5)));
    }
}
