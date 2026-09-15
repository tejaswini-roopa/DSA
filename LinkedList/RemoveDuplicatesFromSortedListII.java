public class RemoveDuplicatesFromSortedListII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int dup = curr.val;
                while (curr != null && curr.val == dup)
                    curr = curr.next;
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
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
        RemoveDuplicatesFromSortedListII sol = new RemoveDuplicatesFromSortedListII();

        // Test 1: Expected [1, 2, 5]
        printList(sol.deleteDuplicates(build(new int[]{1, 2, 3, 3, 4, 4, 5})));

        // Test 2: Expected [2, 3]
        printList(sol.deleteDuplicates(build(new int[]{1, 1, 1, 2, 3})));

        // Test 3: All duplicates → Expected []
        printList(sol.deleteDuplicates(build(new int[]{1, 1, 2, 2})));

        // Test 4: No duplicates → Expected [1, 2, 3]
        printList(sol.deleteDuplicates(build(new int[]{1, 2, 3})));

        // Test 5: Single node → Expected [1]
        printList(sol.deleteDuplicates(build(new int[]{1})));
    }
}
