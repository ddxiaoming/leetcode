package offer47;
class Solution1 {
    private int res = 0;
    private final int[][] dirs = new int[][]{{0, 1}, {1, 0}};

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        dfs(grid, 0, 0, grid[0][0], new boolean[grid.length][grid[0].length]);
        return res;
    }
    private void dfs(int[][] grid, int x, int y, int temp, boolean[][] visited) {
        // 找到一个解
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res = Math.max(temp, res);
            return;
        }
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            // 越界
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            if (!visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                temp += grid[nextX][nextY];
                dfs(grid, nextX, nextY, temp, visited);
                temp -= grid[nextX][nextY];
                visited[nextX][nextY] = false;
            }
        }
    }
}

/**
 * 动态规划
 */
class Solution {
    public int maxValue(int[][] grid) {
        int rowNum = grid.length, colNum = grid[0].length;
        int[][] dp = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j];
                else dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[rowNum - 1][colNum - 1];
    }
}


public class offer47 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue(new int[][]{{1, 2}, {1, 1}}));
        System.out.println(solution.maxValue(new int[][]{{0, 0}, {0, 0}}));
        System.out.println(solution.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
