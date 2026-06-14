public class FlattenLinkedList {

    static class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    ListNode flatten(ListNode root) {
        if (root == null || root.right == null)
            return root;
        ListNode head1 = root;
        ListNode mid = getMid(head1);
        ListNode head2 = mid.right;
        mid.right = null;
        head1 = flatten(head1);
        head2 = flatten(head2);
        return merge(head1, head2);
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.right == null)
            return head;
        // BUG FIX: was (== null) should be (!= null)
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.down = head1;
                head1 = head1.down;
            } else {
                temp.down = head2;
                head2 = head2.down;
            }
            temp = temp.down;
        }
        if (head1 != null) temp.down = head1;
        if (head2 != null) temp.down = head2;
        return dummy.down;
    }

    // Helper to print flattened list (via down pointers)
    static void printFlat(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.down != null) sb.append(", ");
            head = head.down;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        FlattenLinkedList sol = new FlattenLinkedList();

        // Test 1:
        // 3 -> 4 -> 20 -> 20 -> 30
        // |    |    |     |     |
        // 7    11   22    20    31
        // |               |     |
        // 7               28    39
        // |               |
        // 8               39
        // Expected: [3, 4, 7, 7, 8, 11, 20, 20, 20, 22, 28, 30, 31, 39, 39]
        ListNode n1 = new ListNode(3);  n1.down = new ListNode(7);  n1.down.down = new ListNode(7); n1.down.down.down = new ListNode(8);
        ListNode n2 = new ListNode(4);  n2.down = new ListNode(11);
        ListNode n3 = new ListNode(20); n3.down = new ListNode(22);
        ListNode n4 = new ListNode(20); n4.down = new ListNode(20); n4.down.down = new ListNode(28); n4.down.down.down = new ListNode(39);
        ListNode n5 = new ListNode(30); n5.down = new ListNode(31); n5.down.down = new ListNode(39);
        n1.right = n2; n2.right = n3; n3.right = n4; n4.right = n5;
        printFlat(sol.flatten(n1));

        // Test 2:
        // 2 -> 4
        // |    |
        // 7    11
        // |
        // 7
        // Expected: [2, 4, 7, 7, 11]
        ListNode m1 = new ListNode(2); m1.down = new ListNode(7); m1.down.down = new ListNode(7);
        ListNode m2 = new ListNode(4); m2.down = new ListNode(11);
        m1.right = m2;
        printFlat(sol.flatten(m1));
    }
}
