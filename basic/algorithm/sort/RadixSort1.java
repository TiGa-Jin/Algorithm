package basic.algorithm.sort;

public class RadixSort1 {
    public int[] sort(int[] array, int d){ //d表示最大的数有多少位

        int k = 0;
        int divideNum = 1; // 1 10 100 1000 ....用来求对应位数字
        int m =1; //循环控制

        int[][] temp = new int[10][array.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; // 数组order[i]用来表示该位是i的数的个数

        while (m <= d){ //d表示最大的数有多少位

            for(int i = 0; i < array.length; i++){
                int lsd = (array[i] / divideNum) % 10;
                temp[lsd][order[lsd]] = array[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++){
                if (order[i] != 0){
                    for (int j =0; j < order[i]; j++){
                        array[k++] = temp[i][j];
                    }
                    order[i] = 0;
                }
            }
            divideNum *= 10; // 1 10 100 1000 ....用来求对应位数字
            k = 0;
            m++;
        }
        return  array;
    }
    public static void main(String[] args) {
        int[] array = {3366, 994, 4399, 246};
        RadixSort1 radixSort1 = new RadixSort1();
        int[] buckets = radixSort1.sort(array, 4);
        for (int num : array) {
            System.out.print(num + "-");
        }
    }
}
