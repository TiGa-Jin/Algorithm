package offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前部分，所有偶数位于数组的后部分。
 */
public class Offer21 {

    // 首尾 双指针
    public int[] exchange1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if((nums[left] & 1) != 0){//是奇数
                left++;
                continue;
            }
            if((nums[right] & 1) != 1 ){//是偶数
                right++;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] =temp;
        }
        return nums;
    }

    //快慢双指针
    public int[] exchange2(int[] nums) {

      int low = 0;
      int fast = 0;
      int temp = 0;
      while (fast < nums.length){
          if((nums[fast] & 1) == 1){
              temp = nums[low];
              nums[low] = nums[fast];
              nums[fast] = temp;
              low++;
          }
          fast++;

      }
        return nums;
    }

    //快慢双指针 ，mycode
    public int[] exchange3(int[] nums) {

        if (nums.length < 2)
            return nums;

        int flag = 1;
        for (int i = 0; i < nums.length ; i++){
           if(nums[i] % 2 == 0){
               while (nums[flag] % 2 == 0 ){
                   flag++;
                   if (flag == nums.length)
                       return nums;
               }
               int temp = nums[i];
               nums[i] = nums[flag];
               nums[flag] = temp;
           }else {
               flag = i + 1;
           }
        }
        return nums;
    }


    public static void main(String[] args) {
        //int[] array = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        //int[] array = {2};
        //int[] array = {1,2,3,4};

        int[] array = {1,11,14};
        Offer21 offer21 = new Offer21();
        int[] res = offer21.exchange2(array);

        for (int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }

    }
}
