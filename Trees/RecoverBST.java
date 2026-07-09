public class RecoverBST {

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

    TreeNode prev;
    TreeNode second;
    TreeNode first;

    public void recoverTree(TreeNode root) {
        set(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void set(TreeNode root) {
        if (root == null) return;
        set(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        set(root.right);
    }

    // Helper to print inorder
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        // Test 1: [1,3,null,null,2] → Expected inorder: 1 2 3
        //     1
        //    /
        //   3
        //    \
        //     2
        RecoverBST sol1 = new RecoverBST();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        sol1.recoverTree(root1);
        inorder(root1); System.out.println();

        // Test 2: [3,1,4,null,null,2] → Expected inorder: 1 2 3 4
        //     3
        //    / \
        //   1   4
        //      /
        //     2
        RecoverBST sol2 = new RecoverBST();
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(2);
        sol2.recoverTree(root2);
        inorder(root2); System.out.println();

        // Test 3: Adjacent swap [2,3] → Expected inorder: 2 3
        RecoverBST sol3 = new RecoverBST();
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(2);
        sol3.recoverTree(root3);
        inorder(root3); System.out.println();
    }
}
