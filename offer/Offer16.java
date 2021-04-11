package offer;

public class Offer16 {

    public double myPow1(double x, int n) {

        if (x == 0)
            return 0;

        if (n < 0){
            x = 1.0 / x;
            n = -n;
        }

        if(n == 0)
            return 1;
        double pow = 1.0;
        for(int i = 0; i < n; i++) {
            pow = pow * x;
        }

        return pow;
    }

    //快速幂解析（二进制角度）
    public double myPow2(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1.0 / x;
            b = -b;
        }
        while (b != 0) {
            if ((b & 1) == 1)
                res *= x;
            x *= x;
            b >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer16 offer16 = new Offer16();
        System.out.println(offer16.myPow1(2.0,-2));
        System.out.println(offer16.myPow2(2.0,-2));

        int n = 9;
        while ( n != 0){
            System.out.println(n);
            n >>>= 1;
        }
    }
}
