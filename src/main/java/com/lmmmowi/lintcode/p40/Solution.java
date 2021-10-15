package com.lmmmowi.lintcode.p40;

import java.util.Stack;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 40. 用栈实现队列[https://www.lintcode.com/problem/40/]
 */
public class Solution {

    class MyQueue {

        private Stack<Integer> writeStack;
        private Stack<Integer> readStack;

        public MyQueue() {
            this.writeStack = new Stack<>();
            this.readStack = new Stack<>();
        }

        public void push(int element) {
            while (!readStack.isEmpty()) {
                writeStack.push(readStack.pop());
            }
            writeStack.push(element);
        }

        public int pop() {
            top();
            return readStack.pop();
        }

        public int top() {
            while (!writeStack.isEmpty()) {
                readStack.push(writeStack.pop());
            }
            return readStack.peek();
        }
    }

}
