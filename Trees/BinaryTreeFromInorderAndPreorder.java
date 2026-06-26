import java.util.ArrayList;

public class BinaryTreeFromInorderAndPreorder {

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

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0 || B.size() == 0)
            return null;

        int rootValue = A.get(0);
        int rootIndex = B.indexOf(rootValue);

        ArrayList<Integer> leftInOrder = new ArrayList<>();
        ArrayList<Integer> rightInOrder = new ArrayList<>();
        for (int i = 0; i < rootIndex; i++)
            leftInOrder.add(B.get(i));
        for (int i = rootIndex + 1; i < B.size(); i++)
            rightInOrder.add(B.get(i));

        int leftSize = leftInOrder.size();
        ArrayList<Integer> leftPreOrder = new ArrayList<>();
        ArrayList<Integer> rightPreOrder = new ArrayList<>();
        for (int i = 1; i <= leftSize; i++)
            leftPreOrder.add(A.get(i));
        for (int i = leftSize + 1; i < A.size(); i++)
            rightPreOrder.add(A.get(i));

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }

    // Helper to print inorder for verification
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    static ArrayList<Integer> build(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr) list.add(val);
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeFromInorderAndPreorder sol = new BinaryTreeFromInorderAndPreorder();

        // Test 1: preorder=[1,2,3], inorder=[2,1,3] → Expected inorder: 2 1 3
        TreeNode root1 = sol.buildTree(build(new int[]{1, 2, 3}), build(new int[]{2, 1, 3}));
        inorder(root1); System.out.println();

        // Test 2: preorder=[1,6,2,3], inorder=[6,1,3,2] → Expected inorder: 6 1 3 2
        TreeNode root2 = sol.buildTree(build(new int[]{1, 6, 2, 3}), build(new int[]{6, 1, 3, 2}));
        inorder(root2); System.out.println();

        // Test 3: Single node
        TreeNode root3 = sol.buildTree(build(new int[]{1}), build(new int[]{1}));
        inorder(root3); System.out.println();
    }
}
