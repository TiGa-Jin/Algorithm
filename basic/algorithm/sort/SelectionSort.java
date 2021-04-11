package basic.algorithm.sort;

/***
 *
 * 选择排序
 * 从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
 * 选择排序需要 N^2/2 次比较和 N 次交换，它的运行时间与输入无关，这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
 */
public class SelectionSort<T> {

    public int[] sort(int[] array){
        int N = array.length;
        for(int i = 0; i < N - 1; i++){
            int min = i;
            for(int j = i + 1; j < N; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] array = {5, 4, 1, 2, 3};
        SelectionSort selectionSort= new SelectionSort();
        selectionSort.sort(array);
        for (int num:array) {
            System.out.print(num + "-");
        }
    }

}