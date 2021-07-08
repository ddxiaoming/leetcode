package q74;

/**
 * 二分法
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / n, j = mid % n;
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
public class q74 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix;
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 36}};
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix(matrix, 13));
        System.out.println(solution.searchMatrix(matrix, 37));

        matrix = new int[][]{{1},{3}};
        System.out.println(solution.searchMatrix(matrix, 1));
    }
}
