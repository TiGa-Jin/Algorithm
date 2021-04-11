package offer;

import java.util.*;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 */
public class Offer48 {

    //方法一：动态规划 + 哈希表
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int temp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);//通过访问哈希表 dic[s[j]] 获取最近的相同字符的索引 i。
            dic.put(s.charAt(j), j);//更新哈希表，： 遍历字符串 s 时，使用哈希表（记为 dic ）统计 各字符最后一次出现的索引位置 。
            temp = temp < j - i ? temp + 1 : j - i;// dp[j-i] -> dp[j]
            res = Math.max(res, temp);// max( dp[j-1], dp[j])
        }
        return  res;
    }

    //方法二： 动态规划 + 线性遍历
    public int lengthOfLongestSubstring2(String s) {
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

    public static void main(String[] args) {
        String str = "abcabcbb";
        Offer48 offer48= new Offer48();
        System.out.println(offer48.lengthOfLongestSubstring1(str));
        System.out.println(offer48.lengthOfLongestSubstring2(str));
    }


}
