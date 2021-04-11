package basic.algorithm.sort;

/***
 * 希尔排序
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 *
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 * 希尔排序的运行时间达不到平方级别，使用递增序列 1, 4, 13, 40, ... 的希尔排序所需要的比较次数不会超过 N 的若干倍乘于递增序列的长度。后面介绍的高级排序算法只会比希尔排序快两倍左右。
 */
public class ShellSort {

    public int[] sort(int[] array){
        int N = array.length;
        int h = 1;
        while (h < N / 3){
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }
        while (1 <= h){
            for(int i = h; i < N; i++){
                for(int j = i; h <= j && (array[j] < array[j-h]); j -= h){
                    int tmp = array[j];
                    array[j] = array[j-h];
                    array[j-h] = tmp;
                }
                for (int num:array) {
                    System.out.print(num + "-");
                }
                System.out.println();

            }
            h = h / 3;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {5, 11, 7, 9, 2, 3, 12, 8, 6, 1, 4, 10};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
    }
}
