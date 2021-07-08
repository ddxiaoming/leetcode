package offer12;
class Solution {
    private static final int[] STEP_X = new int[]{1, -1, 0, 0};
    private static final int[] STEP_Y = new int[]{0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 找到一个符合条件的就直接返回true
                if (dfs(board, array, 0, i, j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, char[] word, int depth, int x, int y) {

        // 数组越界、递归深度大于word长度、当前元素不匹配
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || depth >= word.length || board[x][y] != word[depth]) {
            return false;
        }
        if (depth == word.length - 1) {
            return true;
        }
        char tmp = board[x][y];
        // 将board[x][y]置为结束标志'\0'，表示以访问过该元素
        board[x][y] = '\0';
        boolean res = dfs(board, word, depth + 1, x + STEP_X[0], y + STEP_Y[0]) ||
                dfs(board, word, depth + 1, x + STEP_X[1], y + STEP_Y[1]) ||
                dfs(board, word, depth + 1, x + STEP_X[2], y + STEP_Y[2]) ||
                dfs(board, word, depth + 1, x + STEP_X[3], y + STEP_Y[3]);

        board[x][y] = tmp;
        return res;
    }
}
public class offer12 {
    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}},"ABCCED"));
        System.out.println(new Solution().exist(new char[][]{{'A','B'}, {'C','D'}},"ABCD"));
        System.out.println(new Solution().exist(new char[][]{{'A','A'}},"AAA"));
    }
}
