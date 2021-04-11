package everyday;

/*
5. 最长回文子串 (回文串：从左往右读=从右往左读)
给你一个字符串 s，找到 s 中最长的回文子串。



示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
 */
public class No5 {

    //寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串。对于最长回文子串，就是这个意思：
   // 为什么要传入两个指针left和right呢？因为这样实现可以同时处理回文串长度为奇数和偶数的情况：
    /*
    for 0 <= i < len(s):
        # 找到以 s[i] 为中心的回文串
        palindrome(s, i, i)
        # 找到以 s[i] 和 s[i+1] 为中心的回文串
        palindrome(s, i, i + 1)
        更新答案
     */
    public String palindrome(String s, int left, int right){
        //防止数组越界
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            //向两边展开；
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //以s[i] 为中心的最最长回文子串
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        No5 solution  = new No5();
        System.out.println(solution.longestPalindrome(s));

    }
}