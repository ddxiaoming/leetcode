package q99;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //对于一个二叉搜索树，其中序遍历的值是递增序列
        inorder(root, list);
        int x = -1, y = -1;
        //找到需要交换的两个值，赋值给x,y
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                if (x == -1) {
                    x = list.get(i);
                }
                y = list.get(i + 1);
            }
        }
        //恢复二叉搜索树
        recover(root, x, y, false, false);
    }
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    private void recover(TreeNode node, int x, int y, boolean flag1, boolean flag2) {
        if (node == null) return;
        if (node.val == x) {
            node.val = y;
            flag1 = true;
        } else if (node.val == y) {
            node.val = x;
            flag2 = true;
        }
        //已经交换完毕，剪枝
        if (flag1 && flag2) return;
        recover(node.left, x, y, flag1, flag2);
        recover(node.right, x, y, flag1, flag2);
    }
}
public class q99 {

}
