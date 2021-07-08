package offer54;

import util.TreeNode;

class Solution {
    private int res;
    private int counter = 1;
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }
    public void inOrder(TreeNode root, int k) {
        if (root == null || counter > k) return;
        inOrder(root.right, k);
        if (counter++ == k) res = root.val;
        inOrder(root.left, k);
    }
}
public class offer54 {
    public static void main(String[] args) {

    }
}
