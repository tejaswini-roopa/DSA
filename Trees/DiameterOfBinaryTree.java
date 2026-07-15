public class DiameterOfBinaryTree {

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

    static int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        getHeight(root);
        return diameter;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        diameter = Math.max(diameter, 2 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();

        // Test 1: Expected 3
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5

        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(sol.diameterOfBinaryTree(root1));

        // Test 2: Expected 1
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println(sol.diameterOfBinaryTree(root2));

        // Test 3: Single node → Expected 0
        System.out.println(sol.diameterOfBinaryTree(new TreeNode(1)));

        // Test 4: Linear tree → Expected 3
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);
        System.out.println(sol.diameterOfBinaryTree(root4));
    }
}
