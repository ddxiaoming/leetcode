package offer04;
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从左下角开始查找
        // 当前值小于目标值，往右走
        // 当前值大于目标值，往上走
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) j++;
            else i--;
        }
        return false;
    }
}
public class offer04 {
}
