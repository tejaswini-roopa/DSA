public class PathSumIII {

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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return countPaths(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int countPaths(TreeNode root, long targetSum) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.val == targetSum)
            count++;
        count += countPaths(root.left, targetSum - root.val);
        count += countPaths(root.right, targetSum - root.val);
        return count;
    }

    public static void main(String[] args) {
        PathSumIII sol = new PathSumIII();

        // Test 1: Expected 3
        //         10
        //        /  \
        //       5   -3
        //      / \    \
        //     3   2   11
        //    / \   \
        //   3  -2   1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.right = new TreeNode(1);
        System.out.println(sol.pathSum(root1, 8));

        // Test 2: Expected 3
        //           5
        //          / \
        //         4   8
        //        /   / \
        //       11  13   4
        //      / \      / \
        //     7   2    5   1
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);
        System.out.println(sol.pathSum(root2, 22));

        // Test 3: null root → Expected 0
        System.out.println(sol.pathSum(null, 0));

        // Test 4: Single node matches → Expected 1
        System.out.println(sol.pathSum(new TreeNode(5), 5));
    }
}
