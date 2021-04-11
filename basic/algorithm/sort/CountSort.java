package basic.algorithm.sort;

/**
 * 计数排序是一种特殊的桶排序，每个桶的大小为1，每个桶不再用List表示，而通常用一个值来计数。
 *
 * 在「设计具体算法的时候」，先找到最小值min，再找最大值max。然后创建这个区间大小的数组，从min的位置开始计数，这样就可以最大程度地压缩空间，提高空间的使用效率。
 * 序列{10001, 10005, 10004, 10002, 10001, 10004}
 * min = 10001, max = 10005, 数组大小 = 10005 - 10001 + 1 = 5
 */
public class CountSort {

    public int[] sort(int[] array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
            if(max < array[i]){
                max = array[i];
            }
        }
        int[] count = new int[max - min + 1];
        for(int i = 0; i < array.length; i++){
            count[array[i] - min]++;
        }
        //排序取值
        int index = 0;
        for(int i =0; i < count.length; i++){
            while (count[i]-- > 0){
                array[index++] = i + min; // 有minc才是真正值
            }
        }

        return array;
    }
    public static void main(String[] args) {
        int[] array = {10001, 10005, 10004, 10002, 10001, 10004};
        CountSort countSort = new CountSort();
        countSort.sort(array);
        for (int num:array) {
            System.out.print(num + "-");
        }
    }

}
