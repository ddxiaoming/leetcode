package q84;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 暴力解法
 */
class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int ans = 0, len = heights.length;
        for (int i = 0; i < len; i++) {
            int left = i, right = i;//左右边界
            int height = heights[i];
            //向左走找到左边界
            while (left > 0 && heights[left - 1] >= height) left--;

            //向右走找到右边界
            while (right < len - 1 && heights[right + 1] >= height) right++;

            //计算面积
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }
}

/**
 * 单调递增栈
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        //数组首尾添0，可以简便代码
        System.arraycopy(heights,0,tmp,1,heights.length);
        //单调栈中存放柱子的索引
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < tmp.length; i++) {
            //这里的!stack.isEmpty()只是为了将头部添加的0入栈
            //0入栈之后永远不会再出栈，因为出栈的条件是：当前元素严格小于栈顶元素，当栈顶元素是0时，不会有元素严格小于0
            //末尾添0保证了栈中所有高度的柱子都会出栈，被当作一个可行的高度计算一次
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int height = tmp[stack.pop()];
                //由于0永远不会出栈，所以stack.peek()永远不会报空指针异常
                int bottom = i - stack.peek() - 1;
                ans = Math.max(ans, bottom * height);
            }
            //经过上面的while循环之后，此时当前的柱子高度大于栈顶柱子的高度，符合单调递增栈的要求，将其入栈
            stack.push(i);
        }
        return ans;
    }
}

public class q84 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(solution.largestRectangleArea(new int[]{2,4}));
        System.out.println(solution.largestRectangleArea(new int[]{2,1,2}));
    }
}
