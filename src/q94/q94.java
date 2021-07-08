package q94;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
    private void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }
}
public class q94 {
    public static void main(String[] args) {
        
    }
}
