package huawei;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 每个员工戴一顶有颜色得帽子员工(可能是部分也可能是全部员工)反馈还有其他多少员工和自己得帽子颜色相同；
 * 将这些信息放在info数组中，返回公司员工帽子的最少数量(即就是参加游戏的员工的最少数量)
 *
 * 输入一维颜色信息数组，每个数组韦每个员工(可能是部分也可能是全部员工）反馈的帽子颜色相同的帽子数量
 * 数组值得约束如下，info最大长度为1000，info[i]是[0, 999]范围内得数
 *
 * 例子：
 * 输入;
 *  [1,1,2]
 * 输出：
 * 5
 * 推理过程，假设第一个员工得的帽子为红色，那么他看到1个与自己颜色相同的帽子，那么红色的帽子有两个，假设第二个员工也是红色帽子，那么符合前面的假设，
 * 那第三个员工看到有两个人和他一样的帽子，则他不不可能也是红色，因此假设他为蓝色，因此蓝色一共有三个，
 *综上所述，最少一共有5人
 *
 */
public class Main2 {
    public static int solution(ArrayList<Integer> nums){

        Set<Integer> set = new HashSet<>();

        for (int num: nums){
            set.add(num);
        }
        int sum = 0;

        for (int num: set){
            sum += num + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.substring(1,line.length() - 1);

        String[] strs = line.split(",");

        ArrayList<Integer> nums = new ArrayList<>();
        int count  = 0;
        for (int i = 0; i < strs.length; i++) {
            if(!strs[i].isEmpty()){
                int num = Integer.parseInt(strs[i]);
                if (num == 0){//如果看没有人和自己一个颜色，那么自己是独一无二的一个人
                    count++;
                }else {//如果有n个人看到和自己一个颜色的有m个人，那么这种颜色就一共有m个人
                    nums.add(num);
                }
            }
        }
        System.out.println(count + solution(nums));
    }
}
