package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 有n x m 的一个矩阵，一个棋子在左下角的格子里，它只能向下走或者向右走，每一次只能走一格，求其走到右下角的所有不同的路径。
 *
 * 解决方法；回溯
 *
 *
 */
public class Qipan1 {

    List<LinkedList<Integer>> res;

    int downCount = 0; //向下走的次数
    int rightCount = 0; //向右走的次数

    int downLen = 0; //接收棋盘的行数
    int rightLen = 0; //接收棋盘的列数

    public List<LinkedList<Integer>> solution(int n, int m, int[][] nums){
        res = new ArrayList<>();
        downLen = n;
        rightLen = m;
        LinkedList<Integer> track = new LinkedList<>();//初始化
        backtrack(track, nums);
        return res;
    }

    public void backtrack(LinkedList<Integer> track, int[][] nums){

        //如果向下走的次数等downLen -1 且向右走的次数等于rightCount == rightLen - 1，表示走到了终点
        if((downCount == downLen - 1) && (rightCount == rightLen - 1)){
            track.add(nums[downLen - 1][rightLen - 1]);
            res.add(new LinkedList<>(track));
            track.removeLast();
            return;

        }
        //进行选择，0表示向下走，1表示向右走
        //for 选择 in 选择列表
        for (int i = 0; i < 2; i++) {
            //越界跳出
            if(downCount > downLen -1 || rightCount > rightLen -1){
                continue;
            }

            if(i == 0){ //向下走
                //做选择
                track.add(nums[downCount][rightCount]);
                downCount++;

                //递归进入下一层
                backtrack(track, nums);

                //撤销选择
                track.removeLast();
                downCount--;
            }else {//向右走

                //做选择
                track.add(nums[downCount][rightCount]);
                rightCount++;

                //递归进入下一层
                backtrack(track, nums);

                //撤销选择
                track.removeLast();
                rightCount--;
            }
        }
    }


    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] nums = {{1,2,3},{1,2,3},{1,2,3}};
        Qipan1 main = new Qipan1();
        List<LinkedList<Integer>> res = main.solution(n, m, nums);

        for (LinkedList<Integer> s: res) {
          for (int i = 0; i < s.size() - 1; i++){
              System.out.print(s.get(i));
              System.out.print("->");
          }
          System.out.print(s.getLast());
          System.out.println();
        }
        System.out.println(res.size());
    }


}
