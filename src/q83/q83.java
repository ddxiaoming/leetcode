package q83;

import util.ListNode;
import util.PrintUtil;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
public class q83 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = null;
        head = ListNode.createList(new int[]{1, 2, 3, 3, 4, 4, 5});
        head = solution.deleteDuplicates(head);
        PrintUtil.printListNode(head);

        head = ListNode.createList(new int[]{1, 1, 1, 2, 3, 3});
        head = solution.deleteDuplicates(head);
        PrintUtil.printListNode(head);
    }
}
