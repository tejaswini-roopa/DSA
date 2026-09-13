public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;

            first.next = second.next;
            second.next = first;
            temp.next = second;
            temp = first;
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
        SwapNodesInPairs sol = new SwapNodesInPairs();

        // Test 1: Expected [2, 1, 4, 3]
        printList(sol.swapPairs(build(new int[]{1, 2, 3, 4})));

        // Test 2: Expected []
        printList(sol.swapPairs(null));

        // Test 3: Expected [1]
        printList(sol.swapPairs(build(new int[]{1})));

        // Test 4: Expected [2, 1, 3]
        printList(sol.swapPairs(build(new int[]{1, 2, 3})));
    }
}
