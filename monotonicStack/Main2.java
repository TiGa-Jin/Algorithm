package monotonicStack;

import java.util.Stack;

/**
 * https://mp.weixin.qq.com/s/_b_QzXkL4e0y5241betVSg
 * 给你一个数组 T = [73, 74, 75, 71, 69, 72, 76, 73]，这个数组存放的是近几天的天气气温。\
 * 你返回一个数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0 。
 * 举例：给你 T = [73, 74, 75, 71, 69, 72, 76, 73]，你返回 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 解释：第一天 73 华氏度，第二天 74 华氏度，比 73 大，所以对于第一天，只要等一天就能等到一个更暖和的气温。后面的同理。
 */
public class Main2 {
    public int[] dailyTemperatures(int[] nums){
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Main2 main = new Main2();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = main.dailyTemperatures(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }
}
