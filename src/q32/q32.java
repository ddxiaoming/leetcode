package q32;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//-1代表当前的最长有效子串是从-1之后开始的
        int len = s.length();
        int maxCount = 0, count = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                //栈底始终存放最后一个不匹配的右括号的下标
                if (stack.empty()) stack.push(i);
                //现在栈顶存放的要么是最后一个不匹配的左括号的下标，要么是最后一个不匹配的右括号的下标
                count = i- stack.peek();
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}
public class q32 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses( "(())(((()()(())"));
    }
}
