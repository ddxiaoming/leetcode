package q61;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (len == 0) return head;
        k = len - k % len;
        if (k == len) return head;
        node = head;
        for (int i = 1; i < k ; i++) {
            node = node.next;
        }
        ListNode start = node.next;
        node.next = null;
        node = start;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        return start;
    }
}
public class q61 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = createList(5);
        printList(list);
        ListNode rotateList = solution.rotateRight(createList(5), 6);
        printList(rotateList);
    }
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    private static ListNode createList(int n) {
        ListNode head = null;
        ListNode node = null;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                head = new ListNode(i, null);
                node = head;
            } else {
                node.next = new ListNode(i, null);
                node = node.next;
            }
        }
        return head;
    }
}
