package offer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。

 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Offer38 {

    List<String > res = new LinkedList<>();
    char[] ch;

    public String[] permutation(String s) {
        ch = s.toCharArray();
        backtrave(0);

        return res.toArray(new String[res.size()]);

    }

    public void backtrave(int i){
        if(ch.length - 1 == i){
            res.add(String.valueOf(ch)); //添加排列方案
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < ch.length; j++) {
            if(set.contains(ch[j])){
                continue;// 重复，因此剪枝
            }
            set.add(ch[j]);
            swap(j, i);
            backtrave(i + 1);
            swap(i, j);
        }


    }
    void swap(int a, int b) {
        char tmp = ch[a];
        ch[a] = ch[b];
        ch[b] = tmp;
    }

    /**
    给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

    换句话说，第一个字符串的排列之一是第二个字符串的子串。

    示例1:

    输入: s1 = "ab" s2 = "eidbaooo"
    输出: True
    解释: s2 包含 s1 的排列之一 ("ba")
    */

    /**
     * 其实我们并不需要生成字符串的所有排列，只需要将第一个字符串的各个字符及其个数用map存起来，然后在第二个字符串中取与s1等长的字符串，也用map存起来，然后对比两个map中相同的字符，它的个数是否相同，
     * 如果相同的话，就能说明第一个字符串的排列之一是第二个字符串的子串。
     *
     * 然后就是应用滑动窗口的思想，这里只要就是用到将窗口平移的手段，因为我们是要取与s1等长的字符串嘛，

     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        //初始化
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++; //记录s1的每个字符出现的个数
            map2[s2.charAt(i) - 'a']++;//记录s2的前s1.length()个字符，每个字符出现的个数
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(map1, map2)){
                return true;
            }
            //窗口整体向右移动一步，这里只要使用了平移的方法
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


    public static void main(String[] arg){

        Offer38 Offer38 = new Offer38();
        String s = "ab";
        String[] res = Offer38.permutation(s);
        for (String str: res){
            System.out.println(str);
        }

        String s1 = "ab";
        String s2 = "eidboaooo";
        System.out.println(Offer38.checkInclusion(s1, s2));



    }




}
