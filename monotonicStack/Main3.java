package monotonicStack;

import java.util.Stack;

public class Main3 {
/**
 *
 * https://mp.weixin.qq.com/s/_b_QzXkL4e0y5241betVSg
 *
 * 给你一个数组(循环的)，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1。不好用语言解释清楚，直接上一个例子：
 * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,4]。
 * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面比 3 大的数是4，填 4。
 *
 */

    //可以构造个双倍长度的数组构造出来，然后套用 Main1的算法模板
    //利用循环数组的技巧来模拟双倍长度的数组
    public int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] res = new int[n];//存放结果
        Stack<Integer> stack = new Stack<>();
        // 假装这个数组翻倍了
        for (int i = 2 * n - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]){
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }

        return res;
    }
    public static void main(String[] args) {
        Main3 main = new Main3();
        int[] nums = {2,1,2,4,3};
        int[] res = main.nextGreaterElement(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
