package everyday;

/**
 * /**
 *  * 打家劫舍
 *  *
 *  * 不能连着偷两家
 *  *
 *  * 示例 1：
 *  *
 *  * 输入：[2,3,2] //是循环数组
 *  * 输出：3
 *  * 解释：因为开头和结尾不能同时被抢。它们也是挨着的
 *  *偷窃到的最高金额 = 3 。
 *  情况一：如从第0家偷，只偷盗 n-2家
 *  情况二：如从第1家偷，只偷盗 n-1家
 *
 */
public class No198_1 {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        int dpi1 = 0;
        int dpi2 = 0;
        // 记录 dp[i]
        int dpi = 0;
        for (int i = end; i >= start ; i--) {
            dpi = Math.max(dpi1, nums[i] + dpi2);
            dpi2 = dpi1;
            dpi1 = dpi;
        }
        return dpi;
    }

    public static void main(String[] args) {
        No198_1 main = new No198_1();
        int[] nums = {2,7,9,3,1};
        System.out.println(main.rob(nums));
    }
}
