package basic.algorithm.sort;

public class MergeSort1 {

    public int[] sort(int[]array){
        mergeSort(array, 0, array.length-1);
        return array;
    }

    public void mergeSort(int[] array, int left, int right) {
        int mid=(left + right) / 2;
        if(left < right)
        {
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int l, int mid, int r) {
        int lIndex = l;
        int rIndex = mid + 1;
        int[] temp = new int[r-l+1];
        int tempIndex = 0;
        while (lIndex <= mid && rIndex <= r) {//先左右比较合并
            if(array[lIndex] <= array[rIndex])
            {
                temp[tempIndex++] = array[lIndex++];
            }
            else {
                temp[tempIndex++] = array[rIndex++];
            }
        }
        while(lIndex <= mid)//当一个越界后剩余按序列添加即可
        {
            temp[tempIndex++] = array[lIndex++];

        }
        while(rIndex <= r)
        {
            temp[tempIndex++] = array[rIndex++];
        }

        for(int i = 0; i < tempIndex; i++)
        {
            array[l+i] = temp[i];
        }

    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        int[] res = new MergeSort1().sort(nums);
        for (int num:res) {
            System.out.print(num + "-");
        }
    }
}
