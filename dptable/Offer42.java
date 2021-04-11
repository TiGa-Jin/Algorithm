package dptable;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Offer42 {

    //dp table
    //找出状态转移方程
    //dp[i-1] > 0 时， dp[i] = dp[i−1] + nums[i] ;
    // dp[i - 1] <= 0 时,执行 dp[i] = nums[i];
    //初始状态： dp[0]=nums[0]，即以 nums[0] 结尾的连续子数组最大和为 nums[0]。

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);

        }
        return max;

    }
}
