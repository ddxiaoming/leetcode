package offer34;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private final List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        getPath(root, target, new LinkedList<>());
        StringBuilder sb = new StringBuilder();
        sb.toString();
        return paths;
    }
    private void getPath(TreeNode root, int target, LinkedList<Integer> path) {
        if (root == null) return;
        // 更新目标值
        target = target - root.val;
        // 当前节点加入路径
        path.addLast(root.val);
        // 只有当前节点是叶子节点，且路径上的总和 = target，才能是一个合法的结果
        if (target == 0 && root.left == null && root.right == null) paths.add(new ArrayList<>(path));
        // 递归遍历左右子树
        getPath(root.left, target, path);
        getPath(root.right, target, path);
        // 回溯时，将当前节点从路径中移除
        path.removeLast();
    }
}
public class offer34 {
}
