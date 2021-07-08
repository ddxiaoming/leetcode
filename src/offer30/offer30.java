package offer30;

import java.util.LinkedList;

class MinStack {

    private final LinkedList<Integer> mainStack;
    private final LinkedList<Integer> helperStack;
    public MinStack() {
        mainStack = new LinkedList<>();
        helperStack = new LinkedList<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (helperStack.size() == 0 || x < helperStack.peek()) {
            helperStack.push(x);
        } else {
            helperStack.push(helperStack.peek());
        }
    }

    public void pop() {
        mainStack.pop();
        helperStack.pop();
    }

    public int top() {
        return mainStack.size() > 0 ? mainStack.peek() : -1;
    }

    public int min() {
        return helperStack.size() > 0 ? helperStack.peek() : Integer.MIN_VALUE;
    }
}
public class offer30 {
}
