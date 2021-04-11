package everyday;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class No1047 {
    public String removeDuplicates(String S) {

        StringBuffer stack = new StringBuffer();
        int n = S.length();

        int top = -1;
        for(int i = 0; i < n; i++){
            char str_i = S.charAt(i);
            if (0 <= top && stack.charAt(top) == str_i){
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(str_i);
                top++;
            }
        }
        return stack.toString();

    }

    public static void main(String[] args) {
        String S = "aaaaaaaa";
        No1047 no1047 = new No1047();
        System.out.println(no1047.removeDuplicates(S));
    }
}

