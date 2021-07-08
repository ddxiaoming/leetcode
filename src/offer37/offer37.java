package offer37;

import sun.reflect.generics.tree.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        // 删除最后一个“,”
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if ("[]".equals(data)) return null;
//
//        // 去除首尾中括号"[]"
//        data = data.substring(1, data.length() - 1);
//        String[] values = data.split(",");
//        List<TreeNode> treeNodes = new ArrayList<>();
//
//        // 将树的节点添加到列表中
//        for (String value : values) {
//            if ("null".equals(value)) treeNodes.add(null);
//            else treeNodes.add(new TreeNode(Integer.parseInt(value)));
//        }
//        int treeSize = treeNodes.size();
//        int nullNum = 0;
//        for (int i = 0; i < treeSize; i++) {
//            TreeNode treeNode = treeNodes.get(i);
//            // 跳过null值,统计null节点的个数
//            if (treeNode == null) {
//                nullNum++;
//                continue;
//            }
//            int left = (i - nullNum) * 2 + 1;
//            int right = (i - nullNum) * 2 + 2;
//            treeNode.left = left < treeSize ? treeNodes.get(left) : null;
//            treeNode.right = right < treeSize? treeNodes.get(right) : null;
//        }
//        return treeNodes.get(0);
//    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;

        // 去除首尾中括号"[]"
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");
        int size = values.length;
        Deque<TreeNode> queue = new LinkedList<>();
        // 构建根节点，并将其假如队列中
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        // i指向下一层，即i始终指向当前节点的左右子节点
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < size && !"null".equals(values[i])) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(values[i]));
                node.left = treeNode;
                queue.add(treeNode);
            }
            i++;
            if (i < size && !"null".equals(values[i])) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(values[i]));
                node.right = treeNode;
                queue.add(treeNode);
            }
            i++;
        }
        return root;
    }
}
public class offer37 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.serialize(codec.deserialize("[5,2,3,null,null,2,4,3,1]")));
    }
}
