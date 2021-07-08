package q82;

import util.ListNode;
import util.PrintUtil;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //哑节点
        ListNode dummy = new ListNode(0, head);
        //前驱节点，记录循环时最后一个不重复的元素
        ListNode pre = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) { //发现当前元素出现了重复
                ListNode temp = head;

                //循环，将指针跳出当前重复的元素
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;

                pre.next = head;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
public class q82 {
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
