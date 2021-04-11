package offer;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class Offer67 {
    public int strToInt(String str) {
       char[] ch = str.trim().toCharArray();

       if(ch.length == 0)
           return 0;

       int res = 0;
       int bndry = Integer.MAX_VALUE / 10;

       int i = 1;
       int sign = 1;

       if(ch[0] == '-')
           sign = -1;

       else if (ch[0] != '+')
           i = 0;

        for (int j = i; j < ch.length; j++) {
            if (ch[j] > '9' || ch[j] <'0')
                break;

            //在每轮数字拼接前，判断 resres 在此轮拼接后是否超过 2147483647，若超过则加上符号位直接返回。
            //设数字拼接边界 bndry = 2147483647 // 10 = 214748364 则以下两种情况越界：

            //res > bndry, 情况一：执行拼接10×res ≥ 2147483650 越界
            //res == bndry, x > 7 ,情况二：拼接后是 2147483648 或 2147483649 越界

            if(res > bndry || (res == bndry && ch[j] > '7'))
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res * 10 + ch[j] - '0';

        }
        return sign * res;

    }

    public static void main(String[] args) {
        String str = "-2147483647";
        Offer67 offer67 = new Offer67();
        System.out.println(offer67.strToInt(str));
    }
}
