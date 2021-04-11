package huawei;

import java.util.*;


/**
 * 输入 ：不同球队及其比分
 * 输出：每个球队的得分(赢球得3分，打平得1分，输球得0分）按得分降序排列，相同分数情况下，按队名字典序排列
 *
 * 例子1：
 * 输入：
 *  a-b 3:0
 *  b-a 1:1
 * 输出：
 *  a 4,b 1
 *  解释：a-b 3:0。a积分+3,b积分+0;b-a 1:1,a积分+1,b积分+1,最终a总分4,b总分1
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        int count = Integer.parseInt(in.nextLine());//测试，先输入一共有多少场比赛

        while (count-- > 0) {

            String line = in.nextLine();
            String[] temp = line.split(" ");

            String[] teams = temp[0].split("-");
            String[] scoresStr = temp[1].split(":");

            int[] scores = new int[2];

            for (int i = 0; i < scores.length; i++) {
                scores[i] = Integer.parseInt(scoresStr[i]);
            }

            int point1 = scores[0] > scores[1] ? 3 : scores[0] == scores[1] ? 1 : 0;
            int point2 = scores[0] > scores[1] ? 0 : scores[0] == scores[1] ? 1 : 3;

            map.put(teams[0], map.getOrDefault(teams[0], 0) + point1);
            map.put(teams[1], map.getOrDefault(teams[1], 0) + point2);
        }

        List<Map.Entry<String, Integer>> results = new ArrayList<>();
        Collections.sort(results, (o1, o2) -> {
            int res = o2.getValue() - o1.getValue();
            if(res == 0){
                res = o2.getKey().compareTo(o1.getKey());
            }
            return res;
        });

        int n = results.size();

        for (int i = 0; i < n - 1; i++) {
            Map.Entry entry = results.get(i);
            System.out.print(entry.getKey() + " " + entry.getValue() + ",");
        }
        Map.Entry entry = results.get(n - 1);
        System.out.print(entry.getKey() + " " + entry.getValue());



    }
}
