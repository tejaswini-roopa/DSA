import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {

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

    class Pair {
        TreeNode node;
        int distance;

        Pair(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public TreeNode getKey() {
            return node;
        }

        public int getValue() {
            return distance;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (A == null)
            return ans;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(A, 0));

        int minLevel = 0;
        int maxLevel = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            TreeNode node = p.getKey();
            int distance = p.getValue();

            ArrayList<Integer> list = map.get(distance);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(node.val);
            map.put(distance, list);

            if (node.left != null)
                q.offer(new Pair(node.left, distance - 1));
            if (node.right != null)
                q.offer(new Pair(node.right, distance + 1));

            minLevel = Math.min(minLevel, distance);
            maxLevel = Math.max(maxLevel, distance);
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal sol = new VerticalOrderTraversal();

        // Test 1:
        //       6
        //     /   \
        //    3     7
        //   / \     \
        //  2   5     9
        // Expected: [[2],[3],[6,5],[7],[9]]
        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(9);
        System.out.println(sol.verticalOrderTraversal(root1));

        // Test 2:
        //        1
        //      /   \
        //     2     3
        //    / \
        //   4   5
        // Expected: [[4],[2],[1,5],[3]]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println(sol.verticalOrderTraversal(root2));

        // Test 3: null → Expected []
        System.out.println(sol.verticalOrderTraversal(null));

        // Test 4: Single node → Expected [[1]]
        System.out.println(sol.verticalOrderTraversal(new TreeNode(1)));
    }
}
