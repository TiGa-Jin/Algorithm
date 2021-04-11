package everyday;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */


public class No300 {
    /**
     *
     *动态规划
     * 思路与算法
     *      定义dp[i],为考虑了前i个元素的最长上升子序列长度，
     *      我们从小到大计算dp数组的值，dp[0]=1, 在计算dp[i]之前，我们已经计算出了dp[0]到dp[i-1]的所有值
     *      则状态转移方程为：
     *          dp[i] = max(dp[j]) + 1,其中 0 <= j < i 且 nums[j] < nums[i]
     **/
    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int maxSubLen = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxSubLen = Math.max(maxSubLen, dp[i]);
        }
        return maxSubLen;

    }
}
