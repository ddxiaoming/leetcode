package q51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private final List<List<String>> res = new ArrayList<>();
    private final Set<Integer> rowSet = new HashSet<>();
    private final Set<Integer> colSet = new HashSet<>();
    private final Set<Integer> positiveSlashSet = new HashSet<>();
    private final Set<Integer> negativeSlashSet = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        //初始化棋盘的每一行
        for (int i = 0; i < n; i++) line.append('.');
        //初始化棋盘
        for (int i = 0; i < n; i++) board.add(line.toString());
        dfs(0, board, n);
        return res;
    }
    private void dfs (int row, List<String> board, int n) {
        //找到一个解
        if (row == n) {
            res.add(new ArrayList<>(board));
        }
        for (int col = 0; col < n; col++) {
            if (!rowSet.contains(row) && !colSet.contains(col) && !positiveSlashSet.contains(col - row) && !negativeSlashSet.contains(col + row)) {
                rowSet.add(row);
                colSet.add(col);
                positiveSlashSet.add(col - row);
                negativeSlashSet.add(col + row);
                putAQueen(row, col, board);
                dfs(row + 1, board, n);
                removeAQueen(row, col, board);
                negativeSlashSet.remove(col + row);
                positiveSlashSet.remove(col - row);
                colSet.remove(col);
                rowSet.remove(row);
            }
        }
    }
    //在棋盘上放置一个皇后
    private void putAQueen(int x, int y, List<String> board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.size(); i++) {
            if (y == i) sb.append('Q');
            else sb.append('.');
        }
        board.set(x,sb.toString());
    }

    //在棋盘上移除一个皇后
    private void removeAQueen(int x, int y, List<String> board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.size(); i++) {
            sb.append('.');
        }
        board.set(x,sb.toString());
    }
}
public class q51 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(9));
    }
}
