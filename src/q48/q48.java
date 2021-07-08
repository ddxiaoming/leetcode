package q48;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //两次翻转即可得到答案

        //第一次水平翻转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, n - 1 -i, j, matrix);
            }
        }

        //第二次沿对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(i, j, j, i, matrix);
            }
        }
        //for (int i = 0; i < n; i++) System.out.println(Arrays.toString(matrix[i]));
    }
    private void swap(int x1, int y1, int x2, int y2, int[][] matrix) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
public class q48 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][]{{5, 1, 9, 11},
                                    {2, 4, 8, 10},
                                    {13, 3, 6, 7},
                                    {15,14,12,16}});
    }

}
