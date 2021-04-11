package bytedance;


import java.util.HashMap;
import java.util.Map;

/**
 *  无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 */
public class String1 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int temp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (0 <= i && s.charAt(i) != s.charAt(j)) //线性查找
                i--;
            temp = temp < j -i ? temp + 1 : j - i;// dp[j-i] -> dp[j]
            res = Math.max(res, temp);// max( dp[j-1], dp[j])
        }
        return  res;

    }
}
