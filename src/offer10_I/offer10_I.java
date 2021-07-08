package offer10_I;

/**
 * 记忆化递归
 */
class Solution1 {
    private static final int mod = 1000000007;
    public int fib(int n) {
        //备忘录
        int[] f = new int[n + 1];
        return getFib(n, f);
    }
    private int getFib(int n, int[] f) {
        if (n == 0 || n == 1) {
            f[n] = n;
        } else if (f[n] == 0) {
            f[n] = ((getFib(n - 1, f) % mod) + (getFib(n - 2, f) % mod)) % mod;
        }
        return f[n];
    }
}

/**
 * 动态规划
 */
class Solution2 {
    private static final int mod = 1000000007;
    public int fib(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) dp[i] = i;
            else dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        }
        return dp[n];
    }
}

/**
 * 动态规划进一步优化空间复杂度
 */
class Solution {
    private static final int mod = 1000000007;
    public int fib(int n) {
        int a = 0, b = 1;
        if (n < 2) return n;
        //从 i = 2开始
        for (int i = 2; i <= n; i++) {
            int sum = (a % mod + b % mod) % mod;
            a = b;
            b = sum;
        }
        return b;
    }
}
public class offer10_I {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(43));
        System.out.println(solution.fib(44));
        System.out.println(solution.fib(100));
    }
}
