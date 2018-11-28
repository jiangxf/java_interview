package com.freetymekiyan.algorithms.level.easy;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * <p>
 * pop() -- Removes the element from in front of queue.
 * <p>
 * peek() -- Get the front element.
 * <p>
 * empty() -- Return whether the queue is empty.
 * <p>
 * Notes:
 * <p>
 * * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is
 * empty operations are valid.
 * <p>
 * * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a stack.
 * <p>
 * * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty
 * queue).
 * <p>
 * Tags: Stack, Design
 * <p>
 * Similar Problems: (E) Implement Stack using Queues
 */
public class ImplementingQueueWithStacks {

    class MyQueue {

        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();


        // Push element x to the back of queue.
        public void push(int x) {
            input.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            peek();
            output.pop();
        }

        // Get the front element.
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty())
                    output.push(input.pop());
            }
            return output.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
