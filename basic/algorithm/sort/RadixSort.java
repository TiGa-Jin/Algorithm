package basic.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/***
 * 基数排序
 * 基数排序是一种很容易理解但是比较难实现（优化）的算法。
 * 基数排序也称为卡片排序，基数排序的原理就是多次利用计数排序（计数排序是一种特殊的桶排序），但是和前面的普通桶排序和计数排序有所区别的是，
 * 「基数排序并不是将一个整体分配到一个桶中」，而是将自身拆分成一个个组成的元素，每个元素分别顺序分配放入桶中、顺序收集，当从前往后或者从后往前每个位置都进行过这样顺序的分配、收集后，就获得了一个有序的数列。
 */
public class RadixSort {

    public int[] sort(int[] array) {

        List[] buckets=new ArrayList[10];

        for(int i = 0; i < buckets.length; i++){    //初始化
            buckets[i] = new ArrayList<Integer>();
        }

        //换到最大值
        int max = 0; // 假设都是正数

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        int divideNum = 1; // 1 10 100 1000 ....用来求对应位数字

        while (0 < max) { // max 和 num 控制，max为待排序的数组中最大的值的位数，比如3366的位数是4
            for (int num : array) {
                buckets[(num / divideNum) % 10].add(num); //分配，将对应位置的数字放到对应的bucket中, 0 1 2 3 ...9
            }

            divideNum *= 10;
            max /= 10; //

            int idx = 0;

            // 收集，重新捡起数据
            for (List<Integer> list : buckets) {
                for (int num : list) {
                    array[idx++] = num;
                }
                list.clear(); // 收集完需要做清空处理
            }

        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {3366, 994, 4399, 246};
        RadixSort radixSort = new RadixSort();
        int[] buckets = radixSort.sort(array);
        for (int num : array) {
            System.out.print(num + "-");
        }
    }
}

