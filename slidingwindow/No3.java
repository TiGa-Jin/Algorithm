package slidingwindow;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
import java.util.*;
public class No3 {

    public int lengthOfLongestSubstring1(String s) {
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
    //滑动窗口
    public int lengthOfLongestSubstring2(String s) {

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int rigth = 0;
        int res = 0;

        while (rigth < s.length()){

            Character c = s.charAt(rigth);
            rigth++;
            //进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1){ //当window.get(c)值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动left缩小窗口了嘛。
                Character d = s.charAt(left);
                left ++;
                //进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, rigth - left);//这里和之前不一样，要在收缩窗口完成后更新res，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复嘛。
        }
        return res;

    }

    public static void main(String[] args) {
        No3 solution = new No3();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring1(s));
        System.out.println(solution.lengthOfLongestSubstring2(s));
    }
}
