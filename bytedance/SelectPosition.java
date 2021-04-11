package bytedance;

import java.util.Scanner;

/**
 * 有一个N个座位的圆环。位置有人坐，标志位1，没人坐，表示0，选一个位置，使得你的座位距离你最近的一个人的距离尽可能远;求这个距离，
 * 相邻位置表示距离为 1
 * 注：座位上至少有一个人，至少有一个空座位
 */
public class SelectPosition {

    //循环遍历
    //记录数组中0连续出现的次数 + 1，最大的数除以2 就是要求的
    public int getMaxDistance(int nums, int array[]){
        int max = 1;
        int j = 0;
        int temp = 1;
        for (int i = 0; i < nums * 2; i++) {
            if (array[j] == 0){
                temp++;
                j = (j + 1) % nums;
                continue;
            }
            else {
                max = Math.max(max, temp / 2);
                temp = 1;
                j = (j + 1) % nums;
            }
        }
        return max;
    }


    public static void main(String[] args) {
//        Scanner in1 = new Scanner(System.in);
//        int num = 0;
//        num = in1.nextInt();
//
//        int [] nums =new int[num];
//        int i = 0;
//        while (i < num){
//            nums[i] = in1.nextInt();
//            System.out.println(nums[i]);
//            i++;
//
//        }
        int num = 8;
        int[] nums = {1, 1, 0, 0, 0, 1, 0, 0};
        SelectPosition test = new SelectPosition();
        System.out.println();
        System.out.println(test.getMaxDistance(num, nums));
    }

}
