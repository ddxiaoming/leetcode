package offer29;
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            // 判断left < right && top < bottom是为了防止最终只剩下一行或一列的时候重复遍历添加。
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    res[index++] = matrix[bottom][i];
                }
                for (int row = bottom; row > top; row--) {
                    res[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
public class offer29 {
}
