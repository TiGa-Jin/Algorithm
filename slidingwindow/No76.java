package slidingwindow;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"

 *
 */
import java.util.*;


public class No76 {

    //滑动窗口
    /**
     * 滑动窗口算法的思路是这样：
     *
     * 1、我们在字符串S中使用双指针中的左右指针技巧，初始化left = right = 0，把索引左闭右开区间[left, right)称为一个「窗口」。
     *
     * 2、我们先不断地增加right指针扩大窗口[left, right)，直到窗口中的字符串符合要求（包含了T中的所有字符）。
     *
     * 3、此时，我们停止增加right，转而不断增加left指针缩小窗口[left, right)，直到窗口中的字符串不再符合要求（不包含T中的所有字符了）。同时，每次增加left，我们都要更新一轮结果。
     *
     * 4、重复第 2 和第 3 步，直到right到达字符串S的尽头
     *
     * 第 2 步相当于在寻找一个「可行解」，然后第 3 步在优化这个「可行解」，最终找到最优解，也就是最短的覆盖子串。左右指针轮流前进，窗口大小增增减减，窗口不断向右滑动，这就是「滑动窗口」这个名字的来历。
     */

    //滑动窗口求解Leetcode76
    public String minWindow(String s, String t) {

        Map<Character, Integer>  need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        //初始化need
        for (int i = 0; i < t.length(); i++) {
            need.put(ct[i],need.getOrDefault(ct[i],0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        //记录最小覆盖字串的起始索引和长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()){
            //c 是将移入窗口的字符
            Character c = cs[right];

            //右移窗口
            right++;

            //进行窗口更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c) == need.get(c)){
                    valid++;//记录窗口内与need中有多少个字符匹配了
                }
            }

            //判断左侧窗口是否要收缩
            while (valid == need.size()){
                //跟新最小覆盖字串
                if((right - left -1) < len){
                    start = left;
                    len = right - left;
                }

                //d是要移除的字符串；
                Character d = cs[left];

                //左移窗口
                left++;

                //进行窗口的一系列更新
                if (need.containsKey(d)){
                    if (window.get(d) == need.get(d)){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "-" : s.substring(start, start+len);


    }


    public static void main(String[] args) {
        No76 sulotion = new No76();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(sulotion.minWindow(s,t));
    }


}
