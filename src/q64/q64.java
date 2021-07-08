package q64;
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][grid[0].length + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = Integer.MAX_VALUE;
                else if (i == 1 && j == 1) dp[i][j] = grid[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
public class q64 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
