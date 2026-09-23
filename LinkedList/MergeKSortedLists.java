public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        while (left != null) {
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while (right != null) {
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        return dummy.next;
    }

    public ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);
        return merge(left, right);
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
        MergeKSortedLists sol = new MergeKSortedLists();

        // Test 1: Expected [1, 1, 2, 3, 4, 4, 5, 6]
        ListNode[] lists1 = {
            build(new int[]{1, 4, 5}),
            build(new int[]{1, 3, 4}),
            build(new int[]{2, 6})
        };
        printList(sol.mergeKLists(lists1));

        // Test 2: Expected []
        printList(sol.mergeKLists(new ListNode[]{}));

        // Test 3: Expected []
        printList(sol.mergeKLists(new ListNode[]{null}));

        // Test 4: Single list → Expected [1, 2, 3]
        ListNode[] lists4 = { build(new int[]{1, 2, 3}) };
        printList(sol.mergeKLists(lists4));
    }
}
