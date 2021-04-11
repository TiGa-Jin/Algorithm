package tencent;

import java.util.*;

public class Main{

    public int getRes(int n){
        int res = 1;
        if (n == 1)
            return res;
        for(int i = 2; i < n - 1; i++){
            res = res + i - 1;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Main sol = new Main();
        if (scan.hasNextLine()) {
            Integer n = scan.nextInt();
            int res = sol.getRes(n);
            System.out.println(res);
        }
    }

}