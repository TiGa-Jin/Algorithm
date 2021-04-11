package monotonicStack;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * https://mp.weixin.qq.com/s/_b_QzXkL4e0y5241betVSg
 *
 * 给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1。不好用语言解释清楚，直接上一个例子：
 * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
 * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1。
 *
 *
 * 这个问题可以这样抽象思考：把数组的元素想象成并列站立的人，元素大小想象成人的身高。
 * 这些人面对你站成一列，如何求元素「2」的 Next Greater Number 呢？很简单，如果能够看到元素「2」，那么他后面可见的第一个人就是「2」的 Next Greater Number，
 * 因为比「2」小的元素身高不够，都被「2」挡住了，第一个露出来的就是答案。
 */
public class Main1 {
    public int[] nextGreaterElement(int[] nums){
        int[] res = new int[nums.length];// 存放答案的数组
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) { // 倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]){// 判定个子高矮
                stack.pop(); // 矮个起开，反正也被挡着了。。。
            }
            res[i] =  stack.empty() ? -1 : stack.peek();// 这个元素身后的第一个高个
            stack.push(nums[i]); // 进队，接受之后的身高判定吧！
        }
        return res;
    }

    public static void main(String[] args) {
        Main1 main = new Main1();
        int[] nums = {2,1,2,4,3};
        int[] res = main.nextGreaterElement(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
