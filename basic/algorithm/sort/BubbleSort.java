package basic.algorithm.sort;

/***
 * 冒泡排序
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 *
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 */
public class BubbleSort {

    public int[] sort(int[] array) {
        int N = array.length;
        boolean isSorted = false;
        for (int i = N - 1; 0 < i && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (array[j + 1] < array[j]) {
                    isSorted = false;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array1= {5, 4, 1, 2, 3};
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sort(array1);
        for (int num:array1) {
            System.out.print(num + "-");
        }
    }
}
