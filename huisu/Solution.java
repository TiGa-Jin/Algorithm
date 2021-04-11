package huisu;

import java.util.LinkedList;

public class Solution {
    int[] res = {0,0};
    int count = 0;
    public boolean minAbsDifference(int n, int m, int[] nums){
        backtrack(0, m, nums);
        if(count > 0){
            return true;
        }else {
            return false;
        }
    }
    public void backtrack(int i, int m, int[] nums){
        //触发结束条件
        if(res[0] <= nums.length &&  res[1] == m){
            count++;
            return ;
        }
        for (int j = i; j < nums.length; j++){
            if (res[0] > 3)
                continue;
            //做选择
            res[0] = res[0] + 1;
            res[1] = res[1] + nums[j];
            //进入下一层决策树
            backtrack(j + 1, m, nums);
            //撤销选择
            res[0] = res[0] - 1;
            res[1] = res[1] - nums[j];
        }

    }



    public int solution(int start,int end, int[]nums){
        if(start == end){
            return nums[start];
        }

        int numArr = end - start + 1;
        int[] frontSums = new int[numArr];
        for (int i = start; i < numArr ; i++) {
            frontSums[i] = frontSums[i] + nums[i];
        }
        int min = Integer.MAX_VALUE;

        int[] res = new int[numArr];
        int flag = 0;
        for (int i = 0; i < numArr ; i++) {
            res[i] =  (frontSums[end - start] - frontSums[i]) -  frontSums[i];
            if (Math.abs(res[i]) < Math.abs(min)){
                min = res[i];
                flag = i;
            }
        }
        if (min == 0){
            if (solution(start, flag, nums)>solution(flag, end, nums)){
                return frontSums[flag] + solution(start, flag, nums);
            }else {
                return frontSums[end]-frontSums[flag] + solution(flag, end, nums);
            }
        }
        else if (min > 0){
            return frontSums[flag] + solution(start, flag, nums);
        }else{
            return frontSums[end]-frontSums[flag] + solution(flag, end, nums);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        int m = 220;
        //int[] nums = {100, 100, 120};
        int[] nums = {100, 100, 120};
       // int[] nums = {100, 100, 120};
        Solution solution = new Solution();
        System.out.print(solution.minAbsDifference(n,m,nums));

        int[] array = {6,2,3,4,5,5};
        System.out.print(solution.solution(0,6,array));

    }

}
