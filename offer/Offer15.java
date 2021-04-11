package offer;

/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *

 */
public class Offer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0){
            sum += n & 1;
            n = n >>1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int s = 9;
        Offer15 offer15 = new Offer15();
        System.out.println(offer15.hammingWeight(s));
        System.out.println(s >>1);
    }
}
