/*
Description
As the title described, you should only use two stacks to implement a queue's actions.
The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
Both pop and top methods should return the value of first element.

Example
For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2

Challenge
implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.

Tags Expand 
LintCode Copyright Stack Queue
*/

/**
 * ջ�������ݽṹ�� �Ƚ���� �ģ����������� �Ƚ��ȳ� ��.
 * ����Stack��˵�����ǽ����ݴ���һ��ջ֮����ȡ��������˳���ǵ������ġ�
 * ��ô���Ǳ�����뵽���Ƿ����ͨ������ջ��ʵ�� Queue ������ݽṹ��
 * ���ӵ�һ��ջ������ ȫ��ȡ���� Ȼ���ٴ� push ���ڶ���ջ�
 * ʵ����һ�η�ת˳����������ȡ���������ݱ���˳����ˡ�Ҳ���Ƕ��е� FIFO.
 * <p>
 * ������������õ�������ջ: stackPush �� stackPop.
 * ÿ����Ҫ����������Ԫ�ص�ʱ�����Ƕ��� stackPush ���� push ��Ԫ�أ�
 * ����Ҫȡ��Ԫ�ص�ʱ��
 * ���ǿ� stackPop �Ƿ�Ϊ�գ�����ǿգ�ֱ�� pop ��Ԫ�ؼ��ɡ�
 * ���Ϊ�գ����ǽ� stackPush �е�ȫ��Ԫ�� pop ������Ȼ���� push �� stackPop �У�Ȼ��� stackPop ��ȡԪ�ؼ��ɡ�
 * <p>
 * ע�����������
 * 1. ÿ�ν� stackPush �е�Ԫ�ص�������ʱ�򣬱���ȫ�����������У�
 * 2. ÿ�ν��� pop ������Ԫ�ص��� stackPop ��ʱ��stackPop ����Ϊ�ա�
 * <p>
 * �ο����£�https://leetcode.com/articles/implement-queue-using-stacks/
 */
class MyQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackPush.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // �ǵ���Ҫ�ж� stackPop �Ƿ�Ϊ��
        // �� stackPush �е� �������� pop������Ȼ�� push��stackPop �У�ʵ��˳��ķ�ת
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * Get the front element.
     */
    public int top() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}