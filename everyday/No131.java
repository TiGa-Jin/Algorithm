package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
class No131 {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        //初始化并设置字符s的第i个字符到第j个字符的字符串是不是为为回文字符串。
        //状态转移方程：
            // f(i, j) = true when j <= i
            // f(i, j) = f(i+1, j-1)  otherwise
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {//如果字符s的第i个字符到第j个字符的字符串是回文
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    //双指针判断一个字符的第i个字符到第j个字符的子串是不是回文串
    public boolean isHuiWen(String str, int i, int j){
        int left = i;
        int right = j;
        char[] charStr = str.toCharArray();
        while (left < right){
            if(charStr[left] != charStr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        No131 solution = new No131();
        List<List<String>> res = solution.partition(str);
        for (List<String> ans:res
        ) {
            System.out.println(ans);

        }

        String str1 = "aba";
        System.out.println(solution.isHuiWen(str1, 0, str1.length() - 1));


    }
}