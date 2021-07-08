package q73;

import util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 空间复杂度为 O(m + n)的解法
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int rowLen = matrix.length, colLen = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            for (int i = 0; i < colLen; i++) matrix[row][i] = 0;
        }

        for (int col : cols) {
            for (int i = 0; i < rowLen; i++) matrix[i][col] = 0;
        }
    }
}

class Solution2 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int rowLen = matrix.length, colLen = matrix[0].length;
        boolean flag = false;//第一列是否被标记

        for (int i = 0; i < rowLen; i++) {
            //标记第一列
            if (matrix[i][0] == 0) {
                flag = true;
            }
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    break;
                }
            }
        }

        //从第零行第零列开始对矩阵进行置零操作
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        //对第0行进行置零操作
        if (matrix[0][0] == 0){
            for (int i = 0; i < colLen; i++) matrix[0][i] = 0;
        }

        //对第0列进行置零操作
        if (flag){
            for (int i = 0; i < rowLen; i++) matrix[i][0] = 0;
        }
    }
}
public class q73 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] matrix = null;

        matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);
        PrintUtil.printArray(matrix);

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix);
        PrintUtil.printArray(matrix);

        matrix = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        solution.setZeroes(matrix);
        PrintUtil.printArray(matrix);

    }
}
