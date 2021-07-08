package q59;
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int num = 0;
        while (true) {
            //向右走
            for (int i = left; i <= right; i++) ans[left][i] = ++num;
            if (++up > down) break;
            //向下走
            for (int i = up; i <= down; i++) ans[i][right] = ++num;
            if (--right < left) break;
            //向左走
            for (int i = right; i >= left; i--) ans[down][i] = ++num;
            if (--down < up) break;
            //向上走
            for (int i = down; i >= up; i--) ans[i][left] = ++num;
            if (++left > right) break;
        }
        return ans;
    }
}

public class q59 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ans = solution.generateMatrix(3);
        printArray(ans);
        System.out.println();
        ans = solution.generateMatrix(2);
        printArray(ans);
        System.out.println();
        ans = solution.generateMatrix(1);
        printArray(ans);
        System.out.println();
        ans = solution.generateMatrix(6);
        printArray(ans);
    }
    private static void printArray(int[][] array) {
        for (int[] a : array) {
            for (int i : a) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
