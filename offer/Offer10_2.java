package offer;

public class Offer10_2 {

    public int numWays1(int n) {
        if(n < 2)
            return 1;
        return numWays1(n-1) + numWays1(n-2);

    }
    public int numWays2(int n) {
        int sum;
        int a = 1;
        int b = 1;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;

        }
        return a;

    }

    public static void main(String[] args) {
        Offer10_2 offer10_2 = new Offer10_2();
        System.out.println(offer10_2.numWays1(5));
        System.out.println(offer10_2.numWays2(5));

    }
}
