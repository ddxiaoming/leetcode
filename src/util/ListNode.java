package util;
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
    public static ListNode createList(int[] values) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (int value : values) {
            current.next = new ListNode(value, null);
            current = current.next;
        }
        return head.next;
    }
}
