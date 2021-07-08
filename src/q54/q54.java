package q54;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, up = 0, down = m-1;
        while (true) {
            //向右走
            for (int i = left; i <= right; i++) res.add(matrix[up][i]);
            if (++up > down) break;//此时表示向下走走不动了
            //向下走
            for (int i = up; i <= down; i++) res.add(matrix[i][right]);
            if (--right < left) break;//此时表示向左走走不动了
            //向左走
            for (int i = right; i >= left; i--) res.add(matrix[down][i]);
            if (--down < up) break;//此时表示向上走走不动了
            //向上走
            for (int i = down; i >= up; i--) res.add(matrix[i][left]);
            if (++left > right) break;//此时表示向上走走不动了
        }
        return res;
    }
}

//class Solution {
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//        int m = matrix.length, n = matrix[0].length;
//        //上下左右四个边界
//        int left = 0, right = n - 1, up = 0, down = m - 1;
//        while (left <= right && up <= down) {
//            //向右走
//            for (int j = left; j <= right; j++) res.add(matrix[up][j]);
//
//            //向下走
//            for (int j = up + 1; j <= down; j++) res.add(matrix[j][right]);
//
//            if (left == right || up == down) break;
//            //向左走
//            for (int j = right - 1; j > left; j--) res.add(matrix[down][j]);
//
//            //向上走
//            for (int j = down; j > up; j--) res.add(matrix[j][left]);
//
//            //更新边界
//            left++;right--;up++;down--;
//        }
//        return res;
//    }
//}
public class q54 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(solution.spiralOrder(new int[][]{{3},{2},{3}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
