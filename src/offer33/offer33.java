package offer33;
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 递归判断从 i 到 j 的数组是否满足二叉搜索树后序遍历的条件。
     * 即左子树所有节点小于根节点，右子树所有节点大于根节点。
     */
    private boolean verifyPostorder(int[] postorder, int i, int j) {

        if (i >= j) return true;

        int right = i;// 右子树起始位置

        // 验证左子树所有节点小于根节点
        while(postorder[right] < postorder[j]) right++;

        // 验证右子树所有节点大于根节点
        int p = right;
        while(postorder[p] > postorder[j]) p++;

        // 验证当前树，并递归验证左右子树
        return p == j && verifyPostorder(postorder, i, right - 1) && verifyPostorder(postorder, right, j - 1);
    }
}
public class offer33 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(new int[] {4, 6, 7, 5}));
    }
}
