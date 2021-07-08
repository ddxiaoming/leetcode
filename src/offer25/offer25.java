package offer25;

import util.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 合并后的链表
        ListNode merge = new ListNode(0, null);
        ListNode head = merge;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) head.next = l1;
        else head.next = l2;
        return merge.next;
    }
}
public class offer25 {
}
