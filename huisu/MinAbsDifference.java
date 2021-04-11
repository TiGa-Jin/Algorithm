package huisu;

/*
求一个包含n个元素的数组中，是否存在x（x <= n)个数字之和恰好等于m
 */
public class MinAbsDifference {

    int count;
    int[] res = {0,0};//res[0]记录个数，res[1]记录数字之和

    public boolean minAbsDifference(int m, int[] nums){
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

    public static void main(String[] args) {
        int[] nums = {1,3,5,9,20};
        MinAbsDifference solu = new MinAbsDifference();
        System.out.println(solu.minAbsDifference(9,nums));

    }

}
