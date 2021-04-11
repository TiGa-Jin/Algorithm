/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package offer;

import java.util.HashSet;
import java.util.Set;

public class Offer03 {

    public int funct1(int[] nums){

        Set<Integer> set = new HashSet<Integer>();

        int repeat = -1;

        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }

    public int funct2(int[] nums){
        int repeat = -1;
        for(int i =0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1)
                return repeat;
        }
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if(nums[i] == nums[nums[i]]) {
                    repeat = nums[i];
                    return repeat;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;

            }
        }
        return repeat;
    }
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        Offer03 offer03 = new Offer03();

        int num1 = offer03.funct1(nums);
        int num2 = offer03.funct2(nums);

        System.out.println(num1);
        System.out.println(num2);
    }
}
