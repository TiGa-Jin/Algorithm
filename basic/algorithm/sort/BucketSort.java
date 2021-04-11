package basic.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *桶排序的思想为：「将待排序的序列分到若干个桶中，每个桶内的元素再进行个别排序。」
 * {1, 8, 7, 44, 42, 46, 38, 34, 33, 17, 15, 16, 27, 28, 24}
 * 按照 array[i] / 10 划分为如下：
 *{1, 8, 7}, {17, 15, 16}, {27, 28, 24}, {38, 34, 33}, {44, 42, 46}
 * 当然桶排序选择的方案跟具体的数据有关系，桶排序是一个比较广泛的概念，计数排序是一种特殊的桶排序，基数排序也是建立在桶排序的基础上。
 * 在数据分布均匀且每个桶元素趋近一个时间复杂度能达到O(n)，但是如果数据范围较大且相对集中就不太适合使用桶排序。
 */
public class BucketSort {
    public List[] sort(int[] array){

        List[] buckets=new ArrayList[10];

        for(int i = 0; i < buckets.length; i++){    //初始化
            buckets[i] = new ArrayList<Integer>();
        }

        for(int i=0; i < array.length; i++){    //将待排序序列放入对应桶中
            int index = array[i] / 10;  //对应的桶号
            buckets[index].add(array[i]);
        }
        for(int i = 0; i < buckets.length; i++) { //每个桶内进行排序(使用系统自带快排)
            buckets[i].sort(null);
        }
        return buckets;
    }
    public static void main(String[] args) {
        int[] array = {1, 8, 7, 44, 42, 46, 38, 34, 33, 17, 15, 16, 27, 28, 24};
        BucketSort bucketSort = new BucketSort();
        List[] buckets = bucketSort.sort(array);
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + "-");
            }
        }
    }

}
