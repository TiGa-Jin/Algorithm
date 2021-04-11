package everyday;

import java.util.Arrays;

/**
 * 打家劫舍
 *
 * 不能连着偷两家
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *偷窃到的最高金额 = 1 + 3 = 4 。

 */
public class No198 {

    private int[] memo;
    public int rob(int[] nums) {

        //return dp1(nums, 0);

        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp2(nums, 0);
    }

    // dp ，但是是存在重叠子问题的
    public int dp1(int[] nums, int start) {
        if (start >= nums.length)
            return 0;
        int res = Math.max(
                //不抢，去下一家
                dp1(nums, start + 1),
                //抢，去下下家
                nums[start] + dp1(nums, start + 2));
        return res;
    }

    // dp,带备忘录
    public int dp2(int[] nums, int start) {
        if (start >= nums.length)
            return 0;
        if (memo[start] != -1)
            return memo[start];
        //这就是自顶向下的动态规划解法
        int res = Math.max(
                //不抢，去下一家
                dp2(nums, start + 1),
                //抢，去下下家
                nums[start] + dp2(nums, start + 2));

        memo[start] = res;
        return res;
    }



    //这就是自底向下的动态规划解法
    int rob1(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    //状态转移只和dp[i]最近的两个状态有关，所以可以进一步优化
    int rob2(int[] nums) {
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        int dp_i_1 = 0, dp_i_2 = 0;
        // 记录 dp[i]
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }


    public static void main(String[] args) {
        No198 main = new No198();
        int[] nums = {2,7,9,3,1};
        System.out.println(main.rob(nums));
    }
}
