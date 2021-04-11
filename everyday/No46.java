package everyday;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 回溯算法
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class No46 {
    //记录所有的全排列结果
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        //记录[路径]
        LinkedList<Integer> track = new LinkedList<>();

        backtrack(nums, track);

        return res;

    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    public void backtrack(int[] nums, LinkedList<Integer> track){
        //触发结束条件
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return ;
        }

        for (int i = 0; i < nums.length; i++){
            //排除不合法的选择
            if(track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);

            //进入下一层决策树
            backtrack(nums, track);

            //取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        No46 no46 = new No46();
        List<List<Integer>> res = no46.permute(nums);
        for (List<Integer> i: res) {
            for (int j:i) {
                System.out.print(j);

            }
            System.out.println();

        }
    }

}
