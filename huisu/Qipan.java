package huisu;


import java.util.ArrayList;
import java.util.List;


/**
 * 有n xm 的一个棋盘，一个棋子在左下角的格子里，它只能向上走或者向右走，每一次只能走一格，求其走到右上角的所有不同的路径。
 *
 * 解决方法；回溯
 * 用0，1，字符串来表示走的路径，其中,最终0的个数是n-1,1的个数是m-1
 *
 */
public class Qipan {

    List<String> res;
    int upCount = 0; //向上走的次数
    int rightCount = 0; //向右走的次数
    int upLen = 0; //接收棋盘的行数
    int rightLen = 0; //接收棋盘的列数

    public List<String> getAll(int n, int m){
        res = new ArrayList<>();
        upLen = n;
        rightLen = m;
        String[] flag = {"0","1"};

        String str = "";//初始化
        backtrack(str,flag);
        return res;
    }
    public void backtrack(String s, String[] flag){

        //如果向上走的次数等upLen -1 且向右走的次数等于rightCount == rightLen - 1，表示走到了终点
        if((upCount == upLen -1) && (rightCount == rightLen - 1)){
            res.add(s);
            return;

        }

        //进行选择，0表示向上走，1 表示向右走
        //for 选择 in 选择列表
        for (int i = 0; i < 2; i++) {

            if(upCount > upLen -1 || rightCount > rightLen -1)
                continue;


            if(i==0){
                //做选择
                s = s + flag[i];
                upCount++;

                //递归进入下一层
                backtrack(s,flag);

                //撤销选择
                s = s.substring(0, s.length() - 1);
                upCount--;

            }
            if(i==1){
                //做选择
                s = s + flag[i];
                rightCount++;

                //递归进入下一层
                backtrack(s,flag);

                //撤销选择
                s = s.substring(0, s.length() - 1);
                rightCount--;

            }

        }

    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        Qipan Solution = new Qipan();
        List<String> res  = Solution.getAll(n, m);

        for (String s: res) {
            System.out.println(s);

        }
        System.out.println(res.size());
    }


}
