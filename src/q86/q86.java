package q86;

import util.ListNode;
import util.PrintUtil;

class Solution {
    public ListNode partition(ListNode head, int x) {
        //该链表用来存储小于x的值
        ListNode smallDumpy = new ListNode(0, null);
        ListNode small = smallDumpy;
        //该链表用来存储大于等于x的值
        ListNode largeDumpy = new ListNode(0, null);
        ListNode large = largeDumpy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        //将small与large两个链表连接到一起
        small.next = largeDumpy.next;
        large.next = null;
        return smallDumpy.next;
    }
}
public class q86 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createList(new int[]{1, 4, 3, 0, 2, 5, 2});
        head = solution.partition(head, 3);
        PrintUtil.printListNode(head);

        head = ListNode.createList(new int[]{2, 1});
        head = solution.partition(head, 2);
        PrintUtil.printListNode(head);
    }
}
