public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null)
            return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListCycleII sol = new LinkedListCycleII();

        // Test 1: [3,2,0,-4], cycle at index 1 → Expected node with val 2
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // cycle at index 1
        System.out.println(sol.detectCycle(head1).val); // 2

        // Test 2: [1,2], cycle at index 0 → Expected node with val 1
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // cycle at index 0
        System.out.println(sol.detectCycle(head2).val); // 1

        // Test 3: [1], no cycle → Expected null
        ListNode head3 = new ListNode(1);
        System.out.println(sol.detectCycle(head3)); // null

        // Test 4: empty list → Expected null
        System.out.println(sol.detectCycle(null)); // null
    }
}
