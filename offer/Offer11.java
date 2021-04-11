/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 */


package offer;

public class Offer11 {

    public int minArray(int[] numbers) {
        int len = numbers.length;
        int i = 0;
        int j = len - 1;

        for(int k = 0; k < len; k++){

            if(numbers[i] > numbers[i+1]){
                return numbers[i+1];
            }else {
                i++;
                if(i==len-1)
                    break;
            }
        }
        return numbers[0];

    }
    public int minArray1(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(numbers[mid]<numbers[right]){ //后半部分肯定是有序的，分界点(最小值)在前半部分 [9(left),3(min),4(mid),5,6(right)]
                right = mid;
            } else if (numbers[mid] > numbers[right]){//前半部分肯定是有序的，分界点(最小值)在后半部分
                left = mid + 1;
            }else {
                right--;
            }
        }

        return numbers[left];

    }


    public static void main(String[] args) {

        int[] arrys1 = {3,4,5,1,2};
        int[] arrys2 = {1,2,3};
        int[] arrys3 = {3,2,1};

        Offer11 offer11 = new Offer11();

        System.out.println(offer11.minArray1(arrys1));
        System.out.println(offer11.minArray(arrys1));

        System.out.println(offer11.minArray1(arrys2));
        System.out.println(offer11.minArray(arrys2));

        System.out.println(offer11.minArray1(arrys3));
        System.out.println(offer11.minArray(arrys3));


    }
}
