package everyday;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */

/**
 *
 *

 */
public class No224 {


    //方法一：括号展开 + 栈
    //由于字符串除了数字与括号外，只有加号和减号两种运算符。因此，如果展开表达式中所有的括号，则得到的新表达式中，数字本身不会发生变化，只是每个数字前面的符号会发生变化。
    public int calculate(String s) {

        Deque<Integer> ops = new LinkedList<Integer>();

        ops.push(1);
        int sign = 1;

        int res = 0;
        int n = s.length();
        int i = 0;

        while (i < n){
            if (s.charAt(i) == ' '){
                i++;
            } else if (s.charAt(i) == '+'){
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-'){
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '('){
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }

}
