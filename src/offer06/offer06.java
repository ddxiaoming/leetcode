package offer06;

import util.ListNode;

class Solution1 {
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        int[] ans = new int[length];
        int i = length - 1;
        while (head != null) {
            ans[i--] = head.val;
            head = head.next;
        }
        return ans;
    }
}

/**
 * 递归
 */
class Solution {
    private int[] ans;
    private int index = 0;
    public int[] reversePrint(ListNode head) {
        recursion(head, 0);
        return ans;
    }
    private void recursion(ListNode head, int length) {
        if (head == null) {
            //把数组的初始化推迟到递归出口（因为递归出口处已经可以知道链表的长度了）
            ans = new int[length];
            return;
        }
        recursion(head.next, length + 1);
        ans[index++] = head.val;
    }
}
public class offer06 {
    public static void main(String[] args) {

    }
}
