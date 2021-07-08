package q100;

import util.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null && p.val == q.val) {
            //如果两个节点不为空，并且值相等，那么继续比较左右孩子
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else {
            //只有当p与q均为空时，两个节点才相等
            return p == null && q == null;
        }
    }
}
public class q100 {
}
