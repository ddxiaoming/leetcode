package offer26;

import util.TreeNode;

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        boolean b1 = recur(A, B);
        boolean b2 = isSubStructure(A.left, B);
        boolean b3 = isSubStructure(A.right, B);
        return b1 || b2 || b3;
    }
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
public class offer26 {
    public static void main(String[] args) {
        int i = 10;
    }
}
