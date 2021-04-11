package dptable;


/*
5. 最长回文子串 (回文串：从左往右读=从右往左读)
给你一个字符串 s，找到 s 中最长的回文子串。

*/

/**
 * 思路与算法
 *
 * 对于一个子串而言，如果它是回文串，并且长度大于 22，那么将它首尾的两个字母去除之后，它仍然是个回文串。
 * 例如对于字符串“ababa”，如果我们已经知道“bab” 是回文串，那么 “ababa” 一定是回文串，这是因为它的首尾两个字母都是“a”。
 *根据这样的思路，我们就可以用动态规划的方法解决本题。我们用 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串，（下文表示成 s[i:j]）是否为回文串：
 *          = true , 如果子串Si....Sj是回文串
 * P(i,j)
 *          = false, 其他情况，1,S[i,j]本身不是回文串，i > j 不合法
 *状态转移方程如下：
 P(i,j) = P(i+1,j−1)∧(Si == Sj)

 也就是说，只有 s[i+1:j-1]是回文串，并且 s的第 i 和 j 个字母相同时，s[i:j]才会是回文串。
 上文的所有讨论是建立在子串长度大于 2 的前提之上的，我们还需要考虑动态规划中的边界条件，
 即子串的长度为 1 或 2。对于长度为 1 的子串，它显然是个回文串；对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串。因此我们就可以写出动态规划的边界条件：
 P(i,i) = true
 P(i,i+1) = (Si == Si+1)

 */
public class No5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        String res = "";

        for (int l = 0; l < n; l++){
            for (int i = 0; i + 1 < n; i++) {
                int j = i + l;
                if(l == 0){
                    dp[i][j] = true;
                } else if (l == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j))  && dp[i + 1][j - 1];
                }

                if (dp[i][j] && l + 1 > res.length())
                    res = s.substring(i, i + j + 1);

            }
        }
        return res;
    }


}
