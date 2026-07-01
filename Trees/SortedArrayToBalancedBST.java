public class SortedArrayToBalancedBST {

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

    public TreeNode sortedArrayToBST(final int[] A) {
        return solve(A, 0, A.length - 1);
    }

    TreeNode solve(int[] A, int l, int r) {
        if (l > r)
            return null;
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = solve(A, l, mid - 1);
        node.right = solve(A, mid + 1, r);
        return node;
    }

    // Helper to print inorder (should match original sorted array)
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        SortedArrayToBalancedBST sol = new SortedArrayToBalancedBST();

        // Test 1: Expected inorder [1, 2, 3], root = 2
        TreeNode root1 = sol.sortedArrayToBST(new int[]{1, 2, 3});
        System.out.print("Root: " + root1.val + " | Inorder: ");
        inorder(root1); System.out.println();

        // Test 2: Expected inorder [1, 2, 3, 5, 10], root = 3
        TreeNode root2 = sol.sortedArrayToBST(new int[]{1, 2, 3, 5, 10});
        System.out.print("Root: " + root2.val + " | Inorder: ");
        inorder(root2); System.out.println();

        // Test 3: Single element → Expected root = 1
        TreeNode root3 = sol.sortedArrayToBST(new int[]{1});
        System.out.print("Root: " + root3.val + " | Inorder: ");
        inorder(root3); System.out.println();

        // Test 4: Two elements → Expected root = 1 or 2
        TreeNode root4 = sol.sortedArrayToBST(new int[]{1, 2});
        System.out.print("Root: " + root4.val + " | Inorder: ");
        inorder(root4); System.out.println();
    }
}
