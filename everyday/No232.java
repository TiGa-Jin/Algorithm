package everyday;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false

 */
public class No232 {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();
    /** Initialize your data structure here. */
    public No232() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while ( !stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while ( !stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else
            return stack2.pop();

    }

    /** Get the front element. */
    public int peek() {
        int res ;
        if (!stack2.isEmpty()){
            res = stack2.pop();
            stack2.push(res);
            return res;
        }else {
            res = pop();
            stack2.push(res);
            return res;
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack2.isEmpty() && stack1.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        No232 no232 =new No232();
        no232.push(1);
        no232.push(2);

        int a = no232.peek();
        System.out.println(a);


        int b = no232.pop();
        System.out.println(b);

        System.out.println(no232.empty());
    }
}
