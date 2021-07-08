package q89;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 格雷编码
 */

/**
 * 解法1. 暴力法
 */
class Solution1 {
    public List<Integer> grayCode(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int[] pow = new int[n + 1];
        pow[0] = 1;
        //初始化2^n数组
        for (int i = 1; i <= n; i++) pow[i] = pow[i - 1] << 1;
        int current = 0;
        while (ans.size() < pow[n]) {
            for (int i = 0; i < n; i++) {
                int next = current ^ pow[i];
                if (!map.containsKey(next)) {
                    map.put(next, 0);
                    ans.add(next);
                    current = next;
                    break;
                }
            }
        }
        return ans;
    }
}

/**
 * 解法2. 动态规划
 * 耗时8ms
 */
class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        //初始化n = 0 的解
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int addNum = 1 << i;
            //倒序遍历，求解最高位为1的解
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(addNum + ans.get(j));
            }
        }
        return ans;
    }
}

/**
 * 解法3. 公式法
 * 耗时5ms
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        int end = 1 << n;
        for (int i = 0; i < end; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}
public class q89 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(2));
    }
}
