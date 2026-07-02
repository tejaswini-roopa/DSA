public class LowestCommonAncestorBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        if (p.val == root.val || q.val == root.val)
            return root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else
                return curr;
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST sol = new LowestCommonAncestorBST();

        // Build BST: [6,2,8,0,4,7,9,null,null,3,5]
        //         6
        //       /   \
        //      2     8
        //     / \   / \
        //    0   4 7   9
        //       / \
        //      3   5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Test 1: p=2, q=8 → Expected 6
        System.out.println(sol.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);

        // Test 2: p=2, q=4 → Expected 2
        System.out.println(sol.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);

        // Test 3: [2,1], p=2, q=1 → Expected 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        System.out.println(sol.lowestCommonAncestor(root2, new TreeNode(2), new TreeNode(1)).val);

        // Test 4: p=0, q=5 → Expected 2
        System.out.println(sol.lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5)).val);
    }
}
