package offer32_I;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            list.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right !=null) queue.addLast(node.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
public class offer32_I {
}
