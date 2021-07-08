package q85;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int ans = 0;
        //将每一行的每一个元素及其上边的连续1的数量计算出来，存储到line数组中。
        //对于每一个line数组，它都是如84题一样的柱状图，因此可以用单调递增栈来解决。
        //同样，为了计算方便，line数组首尾均为0
        int[] line = new int[n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') line[j + 1] = 0;
                else line[j + 1] = line[j + 1] + 1;
            }
            //此时，一个line数组计算完毕，将其输入到84题的题解中
            ans = Math.max(ans, largestRectangleArea(line));
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        //heights在输入之前已经做了首尾添0的处理
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int bottom = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, bottom * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
public class q85 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle(new char[][]{}));
        System.out.println(solution.maximalRectangle(new char[][]{{'0', '0'}}));
        System.out.println(solution.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'},
                                                                  {'1', '0', '1', '1', '1'},
                                                                  {'1', '1', '1', '1', '1'},
                                                                  {'1', '0', '0', '1', '0'}}));
    }
}
