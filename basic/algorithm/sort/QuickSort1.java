package basic.algorithm.sort;

/***
 * 快速排序
 * 快速排序是对冒泡排序的一种改进，采用递归分治的方法进行求解。而快排相比冒泡是一种不稳定排序，时间复杂度最坏是O(n^2)，平均时间复杂度为O(nlogn)，最好情况的时间复杂度为O(nlogn)。
 * 对于快排来说，「基本思想」是这样的：
 *  快排需要将序列变成两个部分，就是「序列左边全部小于一个数」，「序列右边全部大于一个数」，然后利用递归的思想再将左序列当成一个完整的序列再进行排序，同样把序列的右侧也当成一个完整的序列进行排序。
 *  其中这个数在这个序列中是可以随机取的，可以取最左边，可以取最右边，当然也可以取随机数。但是「通常」不优化情况下，我们取最左边的那个数。
 *
 *  快速排序
 * 1. 基本算法
 * 归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，将这两个子数组排序也就将整个数组排序了。
 */
public class QuickSort1 {

    public int[] sort(int[] array){
        quickSort (array, 0, array.length-1);
        return array;
    }

    public void quickSort(int [] array,int left,int right)
    {
        int low = left;
        int high = right;
        //下面两句的顺序一定不能混，否则会产生数组越界！！！very important！！！
        if(low > high)//作为判断是否截止条件
            return;
        int k = array[low];//额外空间k，取最左侧的一个作为衡量标准，最后要求左侧都比它小，右侧都比它大。

        while(low < high)//这一轮要求把得到的数组的左侧小于a[low],右侧大于a[low]。
        {
            while(low < high && array[high] >= k)//在k的右侧找到第一个小于k的停止
            {
                high--;
            }
            //这样就找到第一个比它小的了
            array[low] = array[high]; //放到左侧下标为low位置

            while(low < high && array[low] <= k)//在数组下标为low往右，找到第一个大于k的，放到其右侧array[high]位置
            {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = k;//赋值然后左右递归分治求之
        quickSort(array, left, low-1);
        quickSort(array, low+1, right);
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        QuickSort1 quickSort1 = new QuickSort1();
        quickSort1.sort(array);
        for (int num:array) {
            System.out.print(num + "-");
        }
    }
}