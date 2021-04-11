package alibaba;

import everyday.No92;

import java.util.ArrayList;
import java.util.List;
/*
一个长度为n的数组nums，你的初始位置为0，初始经验值为nums[0],你可以选择一次跳一步（到1）,或者一次跳两步（到2）,跳一步经验值加 nums[1] / 2 向上取整，跳两步的话经验值加nums[2]，之后依旧如此规则
这样跳到下标为n-1的位置，理想的经验最大值是多少？
 */
public class Main1 {

    public int getRes(int n, int[]arr){

        if (n == 1){
            return arr[0];
        }
        if (n == 2){
            return arr[0] + (int)Math.ceil(arr[1] / 2);
        }

        int[] dp = new int[n];

        dp[0]= arr[0];
        dp[1]= arr[0] + (int)Math.ceil(arr[1] / 2);
        for (int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1] + (int)Math.ceil(arr[i] / 2), dp[i-2] + arr[i]);
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {0,1,1,2,4};

        Main1 main = new Main1();
        System.out.print(main.getRes(n, arr));



    }


}
