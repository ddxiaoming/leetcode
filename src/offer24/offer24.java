package offer24;

import com.sun.security.jgss.GSSUtil;
import util.ListNode;
import util.PrintUtil;

/**
 * 迭代解法
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

/**
 * 递归解法
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}

public class offer24 {
    public static void main(String[] args) {
        ListNode list = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        ListNode head = solution.reverseList(list);
        PrintUtil.printListNode(head);
    }
}
