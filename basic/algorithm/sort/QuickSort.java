package basic.algorithm.sort;

//快排

/***
 * 快速排序
 * 1. 基本算法
 * 归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，将这两个子数组排序也就将整个数组排序了。
 *
 *
 */
public class QuickSort {
    public int[] sort(int[] nums) {
        QuickSort(0, nums.length - 1, nums);
        return nums;
    }

    public void QuickSort(int left, int right, int[] nums) {
        if (left < right) {
            int pivot = Partition(left, right, nums);
            QuickSort(left, pivot - 1, nums);
            QuickSort(pivot + 1, right, nums);
        }
    }

    /***
     *
     * 2. 切分
     * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，再从数组的右端向左扫描找到第一个小于它的元素，交换这两个元素。
     * 不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     */
    public int Partition(int left, int right, int[] nums) {
        int target = nums[right];
        int i = left;
        for (int j = left; j <= right; j++) {
            if (nums[j] < target) {
                swap(j, i, nums);
                i++;
            }
        }
        swap(i, right, nums);
        return i;
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        QuickSort1 quickSort = new QuickSort1();
        quickSort.sort(array);
        for (int num : array) {
            System.out.print(num + "-");
        }
    }
}