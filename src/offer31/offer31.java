package offer31;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
public class offer31 {
}
