package basic.algorithm.sort;

import java.util.Arrays;

/***
 * 堆排序
 * 对于堆排序，首先是建立在堆的基础上，堆是一棵完全二叉树，还要先认识下大根堆和小根堆，完全二叉树中所有节点均大于(或小于)它的孩子节点，所以这里就分为两种情况：
 * 1、如果所有节点「大于」孩子节点值，那么这个堆叫做「大根堆」，堆的最大值在根节点。
 * 2、如果所有节点「小于」孩子节点值，那么这个堆叫做「小根堆」，堆的最小值在根节点。
 * 在一个堆中，位置k 的结点的父结点的位置为 k/2，而它的两个子结点的位置则分别为2k 和2k+1
 */
public class HeapSort {

    public void swap(int[] arr,int m,int n)
    {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    //下移交换 把当前节点有效变换成一个堆(小根)
    public void shiftDown(int[] arr,int index,int len){//0 号位置不用
        int leftchild = index * 2 + 1;//左孩子
        int rightchild = index * 2 + 2;//右孩子
        if(len <= leftchild)
            return;
        else if(rightchild < len && arr[rightchild] < arr[index] && arr[rightchild] < arr[leftchild]) {//右孩子在范围内并且应该交换
            swap(arr, index, rightchild);//交换节点值
            shiftDown(arr, rightchild, len);//可能会对孩子节点的堆有影响，向下重构
        }
        else if(arr[leftchild] < arr[index]){//交换左孩子
            swap(arr, index, leftchild);
            shiftDown(arr, leftchild, len);
        }
    }
    //将数组创建成堆
    public void creatHeap(int arr[]) {
        for(int i = arr.length / 2; 0 <= i; i--) {
            shiftDown(arr, i, arr.length);
        }
    }
    public int[] sort(int arr[]) {
        System.out.println("原始数组为：" + Arrays.toString(arr));
        int[] val = new int[arr.length]; //临时储存结果
        //step1建堆
        creatHeap(arr);
        System.out.println("建堆后的序列为：" + Arrays.toString(arr));
        //step2 进行n次取值建堆，每次取堆顶元素放到val数组中，最终结果即为一个递增排序的序列
        for(int i = 0;i < arr.length; i++) {
            val[i] = arr[0];//将堆顶放入结果中
            arr[0] = arr[arr.length-1-i];//删除堆顶元素，将末尾元素放到堆顶
            shiftDown(arr, 0, arr.length - i);//将这个堆调整为合法的小根堆，注意(逻辑上的)长度有变化
        }
        //数值克隆复制
        for(int i = 0;i < arr.length; i++) {
            arr[i] = val[i];
        }
        System.out.println("堆排序后的序列为:" + Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);
        for (int num:array) {
            System.out.print(num + "-");
        }

    }
}
