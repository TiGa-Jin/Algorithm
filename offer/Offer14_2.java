package offer;

import java.util.Map;

/**
 * 此题与 面试题14- I. 剪绳子 主体等价，唯一不同在于本题目涉及 “大数越界情况下的求余问题” 。
 */
public class Offer14_2 {
    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        int a = (n - b) / 3;
        int x = 3;

        long rem =remainder1(x, a-1, p);

        if (b == 0)
            return (int) ((rem * 3) % p);
        if (b == 1)
            return (int) ((rem * 4) % p);

        return (int) (rem * 6 % p); //b == 2
    }

    //求 (x^a) % p —— 循环求余法
    public long remainder1(int x, int a, int p){
        long rem = 1;
        for(int i = 0; i < a; i++){
            rem = (rem * x) % p;
        }
        return rem;
    }

    //求 (x^a) % p —— 快速幂求余
    public long remainder2(int x, int a, int p){
        long rem = 1;
        while (0 < a){
            if(a % 2 == 1)
                rem =(rem * x) % p;
            x = (x * x) % p;

            a /= 2;
        }
        return rem;
    }



}
