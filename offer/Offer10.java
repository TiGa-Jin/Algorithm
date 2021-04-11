/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 */

package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer10 {
    public int fib1(int n) {
        if(n < 2){
            return n;
        }
        return fib1(n -1) + fib1(n -2);

    }
    public int fib2(int n) {
        int sum;
        int a = 0;
        int b = 1;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;

        }
        return a;

    }

    public int fib3(int n, Map<Integer, Integer> map) {
        int constant = 1000000007;
        if(n < 2){
            return n;
        }

        if(map.containsKey(n))
            return map.get(n);
        int first = fib3(n -1, map) % constant;
        map.put(n - 1, first);

        int second = fib3(n - 2, map) % constant;

        int result = (first + second)  % constant;

        map.put(n, first);

        return result;



    }

    public static void main(String[] args) {
        Offer10 offer10 = new Offer10();
        int fn1 = offer10.fib1(5);
        System.out.println(fn1);

        int fn2 = offer10.fib2(5);
        System.out.println(fn2);

        Map<Integer, Integer> map = new HashMap<>();
        int fn3 = offer10.fib3(5, map);
        System.out.println(fn3);
    }

}
