package q63;
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1 || (i == 1 && j == 1)) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
public class q63 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0 ,0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }
}
