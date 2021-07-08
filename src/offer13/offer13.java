package offer13;

/**
 * 深度优先搜索
 */
class Solution {
    private static final int[] X = {0, 0, 1, -1};
    private static final int[] Y = {1, -1, 0, 0};
    private int ans = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        dfs(m, n, k, visited, 0, 0);
        return ans;
    }
    private void dfs(int m, int n, int k, boolean[][] visited, int x, int y) {
        ans++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + X[i];
            int nextY = y + Y[i];
            if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && sum(nextX) + sum(nextY) <= k && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                // 深搜不需要回溯
                dfs(m, n, k, visited, nextX, nextY);
            }
        }
    }
    private int sum(int m) {
        int ans = 0;
        while (m != 0) {
            ans += m % 10;
            m = m / 10;
        }
        return ans;
    }
}
public class offer13 {
    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
        System.out.println(new Solution().movingCount(3, 1, 0));
        System.out.println(new Solution().movingCount(16, 8, 4));
        System.out.println(new Solution().movingCount(11, 8, 16));
    }
}
