package search;

public class BinarySearch {


    //单纯的二分查找,返回下标，没有返回-1
    public int binarySearch(int[] nums, int target){
        int right = nums.length -1 ; //在闭区间 [left, right]上找
        int left = 0;
        while (left <= right){//结束条件[right + 1, right]
            int mid = left + (right -  left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid -1;
        }
        return -1;
    }

    //选择左侧边界的二分查找
    //比如intn[] nums = {1,2,2,2,3}
    //单纯的二分查找2，返回的数组下标为2的值，那么我们如果要找其左边界，也就是返回数组下标为1的那个2，当然找到数组下标为2的那个2后，再向前线性搜索也是可以的，时间复杂度就高，没有利用二分查找的优势了。

    //返回目标值的左侧边界的下标，没有返回-1
    public int leftBound(int[] nums, int target){
        if (nums.length == 0)
            return -1;
        int right = nums.length -1; //注意，//在闭区间 [left, right]上找
        int left = 0;

        //搜索区间 [left, right]
        while (left <= right){ //注意，结束条件[right + 1, right]
            int mid = left + (right - left) /2;
            if(nums[mid] == target)
                right = mid - 1; //注意,不要返回,收缩右侧边界为[left, mid - 1]
            else if (nums[mid] < target)
                left = mid + 1;//注意,搜索区间变为[mid + 1, right]
            else if (nums[mid] > target)
                right = mid - 1; //注意,搜索区间变为[left, mid - 1]
        }
        //检查出界情况，target ⽐所有数都⼤
        if (left >= nums.length )
            return -1;

        return nums[left] == target ? left : -1;
    }
    //返回目标值的右侧边界的下标，没有返回-1
    public int rigthBound(int[] nums, int target){

        if (nums.length == 0)
            return -1;
        int right = nums.length -1; //注意，//在闭区间 [left, right]上找
        int left = 0;

        //搜索区间 [left, right]
        while (left <= right){ //注意
            int mid = left + (right - left) /2;
            if(nums[mid] == target)
                left = mid + 1; //注意,不要返回,收缩右侧边界为[mid + 1, right]
            else if (nums[mid] < target)
                left = mid + 1;//注意,搜索区间变为[mid + 1, right]
            else if (nums[mid] > target)
                right = mid - 1; //注意,搜索区间变为[left, mid - 1]
        }
        //检查出界情况
        if (right < 0)
            return -1;
        return nums[right] == target ? right : -1;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,2,2,5,6};
        int target = 2;
        BinarySearch sulotion = new BinarySearch();
        System.out.println(sulotion.binarySearch(nums1,target));
        System.out.println(sulotion.binarySearch(nums2,target));

        int[] nums3 = {1,2,2,2,5,6};
        target = 2;

        System.out.println(sulotion.leftBound(nums3,target));//输出最左边2的下标

        System.out.println(sulotion.rigthBound(nums3,target));//输出最右边2的下标

    }
}
