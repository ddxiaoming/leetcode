package offer07;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        // 构建中序遍历的索引树
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    /**
     * 递归构建
     * @param preorder 先序序列
     * @param inorder 中序序列
     * @param preLeft 当前子树的先序序列的左端点
     * @param preRight 当前子树的先序序列的右端点
     * @param inLeft 当前子树的中序序列的左端点
     * @param inRight 当前子树的中序序列的右端点
     * @return 构建的当前子树
     */
    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;//递归结束
        //构建根节点，先序遍历的第一个节点就是根节点
        int inRoot = indexMap.get(preorder[preLeft]);//根节点在中序遍历中的位置
        TreeNode root = new TreeNode(preorder[preLeft]);
        //中序遍历中，根节点的左边是左子树，右边是右子树
        int leftSubSize = inRoot - inLeft;
        int rightSubSize = inRight - inRoot;
        //递归构建左子树
        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftSubSize, inLeft, inRoot - 1);
        //递归构建右子树
        root.right = build(preorder, inorder, preRight - (rightSubSize - 1), preRight, inRoot + 1, inRight);
        return root;
    }
}
public class offer07 {
}
