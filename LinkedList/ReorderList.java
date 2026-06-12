public class ReorderList {

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null)
            return A;

        // Find middle
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two halves
        ListNode head2 = slow.next;
        slow.next = null;

        // Reverse the second half
        head2 = ReverseLL(head2);

        // Merge alternatively
        ListNode head1 = A;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (head1 != null && head2 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        if (head1 != null) temp.next = head1;
        if (head2 != null) temp.next = head2;

        return dummyNode.next;
    }

    public ListNode ReverseLL(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode future = null;
        if (head != null) {
            future = head.next;
        }
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = future;
            if (future != null) {
                future = future.next;
            }
        }
        return prev;
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

    public static void main(String[] args) {
        ReorderList sol = new ReorderList();

        // Test 1: Expected [1, 5, 2, 4, 3]
        printList(sol.reorderList(build(new int[]{1, 2, 3, 4, 5})));

        // Test 2: Expected [1, 4, 2, 3]
        printList(sol.reorderList(build(new int[]{1, 2, 3, 4})));

        // Test 3: Single node → Expected [1]
        printList(sol.reorderList(build(new int[]{1})));

        // Test 4: Two nodes → Expected [1, 2]
        printList(sol.reorderList(build(new int[]{1, 2})));
    }
}
