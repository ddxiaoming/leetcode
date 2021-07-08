package offer36;
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
class Solution {
    private Node head = null;
    private Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void recur(Node root) {
        if (root == null) return;
        recur(root.left);
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
            root.left = pre;
        }
        // 递归结束之后，pre指向尾节点
        pre = root;
        recur(root.right);
    }
}
public class offer36 {
}
