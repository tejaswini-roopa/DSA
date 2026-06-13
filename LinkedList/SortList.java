public class SortList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode head1 = head;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return mergedSortedLists(head1, head2);
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergedSortedLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
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
        SortList sol = new SortList();

        // Test 1: Expected [1, 2, 3, 4]
        printList(sol.sortList(build(new int[]{4, 2, 1, 3})));

        // Test 2: Expected [-1, 0, 3, 4, 5]
        printList(sol.sortList(build(new int[]{-1, 5, 3, 4, 0})));

        // Test 3: Empty list → Expected []
        printList(sol.sortList(null));

        // Test 4: Single node → Expected [1]
        printList(sol.sortList(build(new int[]{1})));

        // Test 5: Already sorted → Expected [1, 2, 3]
        printList(sol.sortList(build(new int[]{1, 2, 3})));
    }
}
