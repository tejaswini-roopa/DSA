public class RemoveNthNodeFromEnd {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    // Helper to build list
    static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int val : arr) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Helper to print list
    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd sol = new RemoveNthNodeFromEnd();

        // Test 1: Expected [1, 2, 3, 5]
        printList(sol.removeNthFromEnd(build(new int[]{1, 2, 3, 4, 5}), 2));

        // Test 2: Expected []
        printList(sol.removeNthFromEnd(build(new int[]{1}), 1));

        // Test 3: Expected [1]
        printList(sol.removeNthFromEnd(build(new int[]{1, 2}), 1));

        // Test 4: Remove head → Expected [2, 3, 4, 5]
        printList(sol.removeNthFromEnd(build(new int[]{1, 2, 3, 4, 5}), 5));
    }
}
