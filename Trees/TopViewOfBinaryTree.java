import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    static class Node {
        int data;
        Node left, right;
        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        if (root == null)
            return ans;

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            Node node = p.node;
            int distance = p.hd;

            if (!map.containsKey(distance)) {
                map.put(distance, node);
            }

            if (node.left != null)
                queue.offer(new Pair(node.left, distance - 1));
            if (node.right != null)
                queue.offer(new Pair(node.right, distance + 1));
        }

        for (Node node : map.values()) {
            ans.add(node.data);
        }
        return ans;
    }

    public static void main(String[] args) {
        TopViewOfBinaryTree sol = new TopViewOfBinaryTree();

        // Test 1: Expected [2, 1, 3]
        //    1
        //   / \
        //  2   3
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        System.out.println(sol.topView(root1));

        // Test 2: Expected [40, 20, 10, 30, 100]
        //         10
        //        /  \
        //       20   30
        //      / \   / \
        //     40  60 90 100
        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(40);
        root2.left.right = new Node(60);
        root2.right.left = new Node(90);
        root2.right.right = new Node(100);
        System.out.println(sol.topView(root2));

        // Test 3: Single node → Expected [1]
        System.out.println(sol.topView(new Node(1)));

        // Test 4: null → Expected []
        System.out.println(sol.topView(null));
    }
}
