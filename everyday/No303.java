package everyday;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 *实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 */


/**
 * 方法一：前缀和
 */
public class No303 {

    int[] sums;
    public No303(int[] nums){
        int len = nums.length;
        sums = new int[len + 1];
        for(int i = 0; i < len; i++){
            sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sunRange(int i, int j){
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        No303 no303 = new No303(nums);
        System.out.println(no303.sunRange(0, 2));
        System.out.println(no303.sunRange(2, 5));
        System.out.println(no303.sunRange(0, 5));


    }

}
