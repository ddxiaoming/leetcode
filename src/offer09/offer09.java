package offer09;

import java.util.Stack;

class CQueue {

    //pushStack负责进
    private final Stack<Integer> pushStack;
    //popStack负责出
    private final Stack<Integer> popStack;

    public CQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if (popStack.isEmpty()) return -1;
        return popStack.pop();
    }
}
public class offer09 {
}
