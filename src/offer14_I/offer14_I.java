package offer14_I;

/**
 * 暴力法。超时
 */
class Solution1 {
    private int ans = 1;
    public int cuttingRope(int n) {
        dfs(n, 1, 0);
        return ans;
    }
    private void dfs(int remain, int currentAns, int depth) {
        if (remain == 0) {
            if (depth >= 2) ans = Math.max(currentAns, ans);
            return;
        }
        for (int i = 1; i <= remain; i++) {
            dfs(remain - i, currentAns * i, depth + 1);
        }
    }
}

/**
 * 动态规划
 */
class Solution{
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        // 对于长度为i的绳子
        for (int i = 3; i <= n; i++) {
            // 先砍掉长度j
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
public class offer14_I {
    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(3));
        System.out.println(new Solution().cuttingRope(100));
    }
}
