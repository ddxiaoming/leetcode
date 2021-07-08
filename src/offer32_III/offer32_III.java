package offer32_III;

import util.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        boolean reverse = false; // 是否要进行反转，偶数层要进行反转
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (reverse) tmp.addFirst(node.val);
                else tmp.addLast(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            reverse = !reverse;
            res.add(tmp);
        }
        return res;
    }
}
public class offer32_III {
}
