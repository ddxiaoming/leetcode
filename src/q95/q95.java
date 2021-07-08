package q95;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        //存放以当前节点为根节点的所有可行的二叉搜索树
        List<TreeNode> list = new ArrayList<>();
        //当前节点为null
        if (start > end) {
            list.add(null);
            return list;
        }
        //枚举所有可行的根节点
        for (int i = start; i <= end; i++) {
            //找到当前根节点的左子树
            List<TreeNode> leftTree = generate(start, i - 1);
            //找到当前根节点的右子树
            List<TreeNode> rightTree = generate(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right: rightTree) {
                    //为每一个可行的解创建一个根节点
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = left;
                    currentRoot.right = right;
                    list.add(currentRoot);
                }
            }
        }
        return list;
    }
}
public class q95 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(3));
    }
}
