public class PalindromeLinkedList {

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public int lPalin(ListNode A) {
        ListNode mid = getMid(A);

        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseLinkedList(head2);

        ListNode start1 = A;
        ListNode start2 = head2;

        while (start1 != null && start2 != null) {
            if (start1.val != start2.val) return 0;
            start1 = start1.next;
            start2 = start2.next;
        }
        return 1;
    }

    private static ListNode getMid(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseLinkedList(ListNode A) {
        ListNode curr = A;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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
        PalindromeLinkedList sol = new PalindromeLinkedList();

        // Test 1: [1, 2, 2, 1] → Expected 1
        System.out.println(sol.lPalin(build(new int[]{1, 2, 2, 1})));

        // Test 2: [1, 3, 2] → Expected 0
        System.out.println(sol.lPalin(build(new int[]{1, 3, 2})));

        // Test 3: Single node → Expected 1
        System.out.println(sol.lPalin(build(new int[]{1})));

        // Test 4: [1, 2, 1] odd palindrome → Expected 1
        System.out.println(sol.lPalin(build(new int[]{1, 2, 1})));

        // Test 5: [1, 2] → Expected 0
        System.out.println(sol.lPalin(build(new int[]{1, 2})));
    }
}
