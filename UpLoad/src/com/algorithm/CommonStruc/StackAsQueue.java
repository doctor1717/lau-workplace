package com.algorithm.CommonStruc;

import java.util.Stack;

public class StackAsQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        int len = stack1.size();
        for (int i = 0; i < len - 1 ; i++) {
            stack2.push(stack1.pop());
        }
        int re = stack1.pop();
        for (int i = 0; i < stack2.size(); i++) {
            stack1.push(stack2.pop());
        }

        return re;
    }
}
