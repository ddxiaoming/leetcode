package offer28;

import util.TreeNode;

import java.util.*;

class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!deque.isEmpty()) {
                list.add(deque.removeFirst());
            }
            if (!isSymmetric(list)) return false;
            for (TreeNode tree : list) {
                if (tree != null) {
                    deque.addFirst(tree.left);
                    deque.addFirst(tree.right);
                }
            }
        }
        return true;
    }

    private boolean isSymmetric(List<TreeNode> values) {
        int size = values.size();
        for (int i = 0; i <= size / 2; i++) {
            TreeNode left = values.get(i);
            TreeNode right = values.get(size - 1 - i);
            if (!((left == null && right == null) || (left != null && right != null && left.val == right.val))) {
                return false;
            }

        }
        return true;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
public class offer28 {
}
