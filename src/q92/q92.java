package q92;

import util.ListNode;
import util.PrintUtil;

/**
 * 直接将待反转的区域进行反转
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 0;
        ListNode dumpy = new ListNode(0, head);
        head = dumpy;
        ListNode mainHead = null, mainTail = null;
        ListNode subHead = null, subTail = null;
        ListNode pre = null;

        while (true) {
            ListNode next = head == null ? null : head.next;
            if (count == left -1) {
                mainHead = head;
            } else if (count == left) {
                subHead = head;
            } else if (left < count && count < right) {
                head.next = pre;
            } else if (count == right) {
                head.next = pre;
                mainHead.next = head;
            } else if (count == right + 1) {
                mainTail = head;
                subHead.next = mainTail;
                break;
            }
            count++;
            pre = head;
            head = next;
        }
        return dumpy.next;
    }
}

/**
 * 插入法，每次将
 */
public class q92 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        head = solution.reverseBetween(head, 1, 5);
        PrintUtil.printListNode(head);
    }
}
