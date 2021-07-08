package offer32_II;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.addFirst(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                tmp.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
public class offer32_II {
}
