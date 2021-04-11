package huisu;

import java.util.LinkedList;
import java.util.List;

//输入：一个字符串，有重复元素，重复元素的作用不同
//输入：所有子串(不含有重复元素,包括空串)
//例子1：aac的所有子串：“ ”，“a”,“a”,“c”,“ac”,“ac”,一共有6个
//例子2：abc的所有子串：“ ”，“a”,“b”,“c”,“ac”,”ab",“bc”,“abc"
public class Main {

    int count = 1;//记录总数的全局变量

    public int permute(String str) {
        //记录[路径]
        String track = "";

        backtrack(0,str, track);

        return count;

    }
    // 路径：记录在 track 中
    public void backtrack(int index, String str, String track){

        for (int i = index; i < str.length(); i++){
            if (track.contains(str.substring(i,i+1))){//忽略重复字符
                continue;
            }
            //做选择
            track = track + str.charAt(i);
            count = (count + 1 ) % 20210101;
            //进入下一层决策树
            backtrack(i + 1, str, track);
            //取消选择
            track = track.substring(0, track.length() -1);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        Main solution = new Main();
        int res = solution.permute(str);
        System.out.println(res);

    }

}
