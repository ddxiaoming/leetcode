package offer22;

import util.ListNode;

/**
 * 单指针
 * 两次循环
 */
class Solution1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode h = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 1; i < len - k + 1; i++) h = h.next;
        return h;
    }
}

/**
 * 快慢指针
 * 一次循环
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        // 快指针先走k步
        for (int i = 0 ; i < k; i++) fast = fast.next;
        // 快慢指针一起走，当快指针走到链表尾时，慢指针此时指向倒数第k个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
public class offer22 {
}
