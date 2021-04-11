package everyday;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 */
public class No132 {


    public int minCut(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];

        //初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        //初始化并设置字符s的第i个字符到第j个字符的字符串是不是为为回文字符串。
        //状态转移方程：
        // f(i, j) = true when j <= i
        // f(i, j) = f(i+1, j-1)  otherwise
        for (int i = n -1; 0 <= i; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        //g[i]表示字符串前缀s[0~i]的最少分割次数，要想得到g[i]的值，可以考虑枚举s[0~i]分割出的最后一个回文字符串
        //转移状态方程 g[i] = min{f[j]} + 1, 其中0 <= j < i; s[j+1 ~ i]是一个回文字符串
        //即枚举最后一个回文字符串的起始位置 j + 1, 保证s[j+1 ~ i]是一个回文串，那么g[i] 就可以从g[j]转移而来，+1是额外的分割次数
        //上面的状态转移方程没有考虑这样一种情况，即s[0 ~ i]本身就是回文串，此时不需要进行任何分割。即g[i] = 0
        int[] g = new int[n];
        Arrays.fill(g, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if(f[0][i])
                g[i] = 0;//即s[0 ~ i]本身就是回文串，此时不需要进行任何分割。即g[i] = 0
            else{
                for (int j = 0; j < i; j++) {
                    if(f[j + 1][i])
                        g[i] = Math.min(g[i], g[j] + 1);//转移状态方程 g[i] = min{f[j]} + 1, 其中0 <= j < i; s[j+1 ~ i]是一个回文字符串
                }
            }
        }
        return g[n - 1];

    }
    public static void main(String[] args) {

        No132 solution = new No132();

        String str1 = "aaba";
        System.out.println(solution.minCut(str1));


    }
}
