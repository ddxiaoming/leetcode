package q62;

/**
 * 方法1. 动态规划法
 */
class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) dp[i][j] = 1;
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}

/**
 * 方法2. 组合数学法
 */
class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
public class q62 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.uniquePaths(3, 2));
        System.out.println(solution.uniquePaths(7, 3));
        System.out.println(solution.uniquePaths(3, 3));
        System.out.println(solution.uniquePaths(10, 10));
        System.out.println(solution.uniquePaths(13, 23));
    }
}
