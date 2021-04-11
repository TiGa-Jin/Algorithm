package meituan;

public class Main2 {

    //计算f(n)
    //如 n 的因子有{1,a,b,c,n},那么f(n) = 1abcn;
    public String getSeq(int n){
        String str = "";
        for (int i = 1; i < n+1; i++) {
            if (n % i == 0){
                str = str + i;// + 表示拼接操作
            }
        }
        return str;
    }

    public int getRes(int len, String target, int[]nums){
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(getSeq(nums[i]).contains(target)){//如果该字符串包含target字串，则count++
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        Main2 sulotin = new Main2();
        int n = 5;
        String target = "13";//目标字串
        int[] nums = {13, 31, 10, 9, 20};
        System.out.println(sulotin.getRes(n,target,nums));
    }
}
