package offer55_II;

import util.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = dfs(root.right);
        if (rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}
public class offer55_II {
}
