package offer27;

import util.TreeNode;

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = left;
        return root;
    }
}


public class offer27 {
}
