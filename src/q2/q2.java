package q2;

import util.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0, null);
        ListNode res = head;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            res.next = new ListNode(sum % 10, null);
            res = res.next;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) res.next = new ListNode(carry, null);
        return head.next;
    }
}
public class q2 {
}
