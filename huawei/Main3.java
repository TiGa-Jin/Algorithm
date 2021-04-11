package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 一个数组表示的队列，里面全是小写字母，现在给出一共小写字母组成的字符串，需要移动游标，以最小的步数找到这个字符串
 * 游标的起始位置给出，游标每次能够向左或者向右移动一步，游标到达最左边，允许向左移动一步到达最右边；
 * 达到最右边，允许向右移动一步到达最左边
 *
 * 输入:
 * aemoyn
 * emo
 * 0
 *
 * 输出：
 * 3
 * 说明：游标初始位置为需要的a,向右移动两步找到m,再向右移1步找到o,总共移动3步
 */
public class Main3 {
    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String pattern = in.nextLine();
        int cur = in.nextInt();
         */
        String str ="aemoyn";
        String pattern = "emo";
        int cur = 0;
        System.out.println(solution(str,pattern,cur));

    }

    public static int solution(String str, String pattern, int cur){

        //记录每个字母在数组中出现的位置，可能有这种情况, a出现多次,所以用一个ArrayList去存出现的所以下标
        Map<Character, ArrayList<Integer>> map = new HashMap<>();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            ArrayList<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        //用一二维数组去存从一个下标i移动到j最少的移动次数
        int[][] steps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                steps[i][j] = Math.min(Math.abs(j - i), Math.min(n + j - i, n - j + i));
            }
        }
        int reslut = 0;
        for (char c: pattern.toCharArray()){
            int dest = 0, min = Integer.MAX_VALUE;
            for (int num : map.get(c)) {
                if (steps[cur][num] < min) {
                    dest = num;
                    min = steps[cur][num];
                }
            }
            reslut += min;
            cur = dest;
        }
        return reslut;

    }
}