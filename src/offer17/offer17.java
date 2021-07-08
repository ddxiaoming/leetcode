package offer17;

import java.util.ArrayList;
import java.util.List;

/**
 * 不考虑大数越界
 */
class Solution1 {
    public int[] printNumbers(int n) {
        int max = 0;
        for (int i = 0; i < n; i++) max = max * 10 + 9;
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i+1;
        }
        return res;
    }
}

/**
 * 考虑大数越界
 */
class Solution {
    private final List<String> res = new ArrayList<>();
    private final char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private char[] curNumbers;
    public List<String> printNumbers(int n) {
        curNumbers = new char[n];
        dfs(0, n, 0, false);
        return res;
    }

    /**
     * 递归DFS生成解
     * @param depth 当前递归深度
     * @param n n
     * @param offset n位数中第一个不为0的数
     * @param flag 是否已经找到 n位数中第一个不为0的数
     */
    private void dfs(int depth, int n, int offset, boolean flag) {
        // 终止条件，所有位（个、十、百、千等）上的数字都赋值完毕
        if (depth == n) {
            String s = new String(curNumbers).substring(offset);
            if (!s.equals("")) res.add(s);
            return;
        }
        for (char c : numbers) {
            curNumbers[depth] = c;
            // 当前字符不为0，尚未找到第一个不为0的数，令offset = depth，flag = true
            if (c != '0' && !flag) dfs(depth + 1, n, depth, true);
            // 当前字符为0，尚未找到第一个不为0的数，offset往后移
            else if (c == '0' && !flag) dfs(depth + 1, n, offset + 1, false);
            // 已经找到第一个不为0的数
            else dfs(depth + 1, n, offset, true);
        }
    }
}
public class offer17 {
    public static void main(String[] args) {
        System.out.println(new Solution().printNumbers(12));
    }
}
