package offer18;

import util.ListNode;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 哑结点
        ListNode h = new ListNode(0, head);
        ListNode pre = h;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = head;
            head = head.next;
        }
        return h.next;
    }
}
public class offer18 {
    public static void main(String[] args) {

    }
}
