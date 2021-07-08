package q52;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private int res = 0;
    private final Set<Integer> colSet = new HashSet<>();
    private final Set<Integer> positiveSlashSet = new HashSet<>();
    private final Set<Integer> negativeSlashSet = new HashSet<>();
    public int totalNQueens(int n) {
        dfs(0, n);
        return res;
    }
    private void dfs (int row, int n) {
        //找到一个解
        if (row == n) {
            res++;
        }
        for (int col = 0; col < n; col++) {
            if (!colSet.contains(col) && !positiveSlashSet.contains(col - row) && !negativeSlashSet.contains(col + row)) {
                colSet.add(col);
                positiveSlashSet.add(col - row);
                negativeSlashSet.add(col + row);
                dfs(row + 1, n);
                negativeSlashSet.remove(col + row);
                positiveSlashSet.remove(col - row);
                colSet.remove(col);
            }
        }
    }
}
public class q52 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(9));
    }
}
