package slidingwindow;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 注意哦，输入的s1是可以包含重复字符的，所以这个题难度不小。
 */
public class No567 {

    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        //初始化
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(map1, map2)){
                return true;
            }
            //窗口整体向右移动一步
            map2[s2.charAt(i + s1.length())- 'a']++;
            map2[s2.charAt(i) - 'a']--;
        }
        if (match(map1, map2))
            return true;
        else
            return false;

    }
    public boolean match(int[] map1, int[] map2){
        for (int i = 0; i < 26; i++) {
            if(map1[i] != map2[i])
                return false;
        }
        return true;
    }

    //滑动窗口法
    public boolean checkInclusion2(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        //把数组当中字典来用，下标表示a-z的第i个字符，值表示该字符出现的个数。默认为0，表示不存在该字符；
        int[] need = new int[26];
        int[] window = new int[26];

        Character a ='a';

        //初始化s1中的字符及其数量,
        int unCount = 0;//记录s1中不同的字符数,
        for (int i = 0; i < s1.length(); i++) {
            if (need[s1.charAt(i) - a] ==  0){
                unCount++;
            }
            need[s1.charAt(i) - a] = need[s1.charAt(i) - a] + 1;
        }

        int left = 0;
        int right = 0;
        int valid = 0;


        while (right < s2.length()){

            Character c = s2.charAt(right);
            right++;

            //进行窗口更新
            if(need[c - a] > 0){//如果need中存在这个字符
                window[c - a] = window[c - a] + 1; //窗口中该字符的数量加1
                if(window[c - a] == need[c - a])//如果窗口中该字符的数量=need中该字符的数量，则匹配的字符的数量加1
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()){

                if (valid == unCount)
                    return true;
                Character d = s2.charAt(left);

                left++;

                if (need[d - a] > 0){
                    if (window[d -a] == need[d - a])
                        valid--;
                    window[d - a] = window[d - a] - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No567 sulotion = new No567();
        String  s1= "abcdxabcde" ,s2 = "abcdeabcdx";
        System.out.println(sulotion.checkInclusion1(s1, s2));
        System.out.println(sulotion.checkInclusion2(s1, s2));
    }
}
