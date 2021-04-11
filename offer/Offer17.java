package offer;

public class Offer17 {
    public int[] printNumbers(int n) {

        int num = 1;
        while (n != 0){
            num = num * 10;
            n--;
        }
        int[] res = new int[num];
        for(int i = 0; i < num -1; i++){
            res[i] = i + 1;

        }
        return res;
    }
}
