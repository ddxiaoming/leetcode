package q98;

import util.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        long val = root.val;
        if (min >= val || max <= val) return false;
        return isValidBST(root.left, min, val) && isValidBST(root.right, val, max);
    }
}
public class q98 {
}
