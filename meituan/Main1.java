package meituan;

import java.util.LinkedList;
import java.util.List;


public class Main1 {

    int count = 0;//记录总数的全局变量

    public int permute(String str) {
        count = 1;
        //记录[路径]
        String track = "";

        backtrack(0,str, track);

        return count;

    }
    // 路径：记录在 track 中
    public void backtrack(int index,String str, String track){

        for (int i = index; i < str.length(); i++){

            //避免出现类似于aa这样重复的情况,比如字符串aab和aaba的结果应该是相等的
            if (track.contains(str.substring(i, i+1))){
                continue;
            }
            //做选择，即就是加入下一个合理的字符
            track = track + str.charAt(i);//+表示字符串拼接
            count = (count + 1 ) % 20210101;//增加选择的次数
            //进入下一层决策树
            backtrack(i + 1, str, track);
            //取消选择，即就是删除最后一个字符
            track = track.substring(0, track.length() -1);
        }
    }

    public static void main(String[] args) {
        String str1 = "";
        String str2 = "a";
        String str3 = "aab";
        String str4 = "aaba";
        String str5 = "aabc";

        Main1 solution = new Main1();

        int res = solution.permute(str1);
        System.out.println(res);

        res = solution.permute(str2);
        System.out.println(res);

        res = solution.permute(str3);
        System.out.println(res);

        res = solution.permute(str4);
        System.out.println(res);

        res = solution.permute(str5);
        System.out.println(res);

    }

}
