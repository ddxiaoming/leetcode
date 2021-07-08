package offer35;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 方法一. HashMap
 */
class Solution1 {
    public Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> hashMap = new HashMap<>();
        while (current != null) {
            hashMap.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node node = hashMap.get(current);
            node.next = hashMap.get(current.next);
            node.random = hashMap.get(current.random);
            current = current.next;
        }
        return hashMap.get(head);
    }
}

/**
 * 方法二. 合并、拆分链表
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node current = head;
        // 1. 合并链表
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        current = head;
        // 2. 构建新链表的random指针
        while (current != null) {
            Node nexOld = current.next.next;
            Node nextNew = nexOld == null ? null : nexOld.next;
            current.next.random = current.random;

            current.next.next = nextNew;
            current = nexOld;
        }
        return head.next;
    }
}
public class offer35 {
}
