package everyday;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class No338 {

    //方法一：直接计算,时间复杂度k * num ，出返回的数组长度外，空间复杂度为常数
    public int[] countBits1(int num) {
        int[] res = new  int[num+1];
        for(int i = 0; i <= num; i++){
            res[i] = hammingWeight(i);
        }
        return res;

    }
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0){
            sum += n & 1;
            n >>>= 1;
        }
        return sum;
    }

    //方法二：动态规划——最高有效位

    //为了判断一个正整数是不是2整数次幂，可以利用方法一中提到的按位与运算的性质。如果正整数 y 是 2的整数次幂，则 y的二进制表示中只有最高位是 1，其余都是0，因此 y&(y-1)=0
    //比如8（1000）& 7(0111) 的结果为 0
    //

    public int[] countBits2(int num) {
        int[] res = new  int[num+1];
        int higtBit = 0;
        for (int i = 1; i <= num; i++){
            if((i & (i - 1)) == 0){
                higtBit = i;
            }
            res[i] = res[i - higtBit] + 1;
        }

        return res;

    }

    //方法三：动态规划——最低有效位
    //对于正整数x，将其二进制表示右移一位，等价于将其二进制表示的最低位去掉，得到的数【x/2】(向下取整)。
    //如果res[【x/2】]已知，就可以得到res[x]的值
        //如果x 是偶数：res[x] = res[【x/2】]
        //如果x 是奇数：res[x] = res[【x/2】] + 1
    public int[] countBits3(int num) {
        int[] res = new  int[num+1];
        for (int i = 1; i <= num; i++){
           res[i] = res[ i >> 1] + (i & 1);//如果x 是偶数，(i & 1)为0，反之为1
        }
        return res;

    }

    //方法四：动态规划——最低设置位
    //定义正整数 x 的「最低设置位」为 x 的二进制表示中的最低的 1 所在位。例如，1010 的二进制表示是 1010。其最低设置位为 2，对应的二进制表示是 10
    //令 y = x &(x-1)，则 y 为将 x 的最低设置位从 1 变成 0 之后的数。如二进制数1010 & 1001 = 1000（十进制10 & 9 = 8）显然 0 <= y < x, res[x] = res[y] + 1,
    //因此对于任意正整数x, res[x] = res[x &(x-1)] + 1,
    public int[] countBits4(int num) {
        int[] res = new  int[num+1];
        for (int i = 1; i <= num; i++){
            res[i] = res[i & (i-1)] + 1;
        }
        return res;

    }



    public static void main(String[] args) {
        int s = 5;
        No338 no338 = new No338();

        int[] res1 = no338.countBits1(s);
        for (int i =0; i < res1.length; i++){
            System.out.print(res1[i]);
        }
        System.out.println("");

        int[] res2 = no338.countBits2(s);
        for (int i =0; i < res2.length; i++){
            System.out.print(res2[i]);
        }
        System.out.println("");

        int[] res3 = no338.countBits3(s);
        for (int i =0; i < res3.length; i++){
            System.out.print(res3[i]);
        }
        System.out.println("");

        int[] res4 = no338.countBits4(s);
        for (int i =0; i < res4.length; i++){
            System.out.print(res4[i]);
        }



    }

}
