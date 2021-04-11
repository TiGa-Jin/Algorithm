package slidingwindow;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 例1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

 *呵呵，这个所谓的字母异位词，不就是排列吗，搞个高端的说法就能糊弄人了吗？
 * 相当于，输入一个串S，一个串T，找到S中所有T的排列，返回它们的起始索引。
 * 对比Leetcode567题一样的，跟寻找字符串的排列一样，只是找到一个合法异位词（排列）之后将起始索引加入res即可。
 */
import java.util.*;
public class No438 {


    //滑动窗口
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length())
            return res;

        //把数组当中字典来用，下标表示a-z的第i个字符，值表示该字符出现的个数。默认为0，表示不存在该字符；
        int[] need = new int[26];
        int[] window = new  int[26];

        int unCount = 0;//记录有多少个不一样的字符
        Character a = 'a';
        for (int i = 0; i < p.length(); i++) {
            if (need[p.charAt(i) - a] == 0)
                unCount++;
            need[p.charAt(i) - a] = need[p.charAt(i) - a] + 1;

        }

        int right = 0;
        int left = 0;
        int valid = 0;

        while (right < s.length()){
            Character c = s.charAt(right);

            right++;

            if(need[c - a] > 0){
                window[c - a] = window[c - a] + 1;
                if (window[c - a] == need[c - a]){
                    valid++;
                }

            }

            while (right - left >= p.length()){

                if (valid == unCount) {
                    res.add(left);
                }

                Character d = s.charAt(left);

                left++;

                if (need[d - a] > 0){
                    if (window[d - a] == need[d - a]){
                        valid--;
                    }
                    window[d - a] = window[d - a] -1;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        No438 solution = new No438();
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = solution.findAnagrams(s, p);

        for (Integer i:res) {
            System.out.println(i);
        }
    }
}
