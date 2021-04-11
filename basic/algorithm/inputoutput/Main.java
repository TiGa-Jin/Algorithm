package basic.algorithm.inputoutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("输入数组长度n,换行，输入数组的n个值");

        System.out.println("第一种方法");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nNumArr1 = new int[n];
        int ni = 0;
        String nStrArrLine = scan.nextLine();
        String[] nStrArr = nStrArrLine.split(" ");
        while (ni < n){
            nNumArr1[ni] = new Integer(nStrArr[ni]);
            ni++;
        }
        for (int i = 0; i < n; i++){
            System.out.print(nNumArr1[i]);
            System.out.print(" ");
        }

        System.out.println("第二种方法");


        //方法2
        int[] nNumArr2 = new int[n];
        int nj = 0;
        while (nj < n){
            nNumArr2[nj] = scan.nextInt();
            nj++;
        }
        for (int i = 0; i < n; i++){
            System.out.print(nNumArr2[i]);
            System.out.print(" ");
        }


    }

}
