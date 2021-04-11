package dptable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck ，每种硬币的数量无限，再给一个总金额 target ，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 */
public class Coin {
    // coins 中是可选硬币⾯值，amount 是⽬标⾦额
    public int coinChange(int[] coins, int target){
        Map<Integer, Integer> map = new HashMap<>();
        return dp3(coins, target);

    }
    //暴力递归
    public int dp1(int[] coins, int target){
        if(target == 0)
            return 0;
        if (target < 0)
            return -1;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int sub = dp1(coins,target - coins[i]);
            if (sub == -1)
                continue;
            res = Math.min(res, 1 + sub);
        }
        return res != Integer.MAX_VALUE ? res: -1;
    }
    //带备忘录递归
    public int dp2(Map<Integer, Integer> map, int[] coins, int target){

        //查备忘录
        if(map.getOrDefault(target, -1) > 0){
            return map.getOrDefault(target,-1);
        }

        if(target == 0)
            return 0;
        if (target < 0)
            return -1;

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int sub = dp2(map, coins,target - coins[i]);

            if (sub == -1)
                continue;

            res = Math.min(res, 1 + sub);
        }
        map.put(target, res != Integer.MAX_VALUE ? res: -1);

        return map.getOrDefault(target, -1);
    }
    //dp数组迭代
    public int dp3(int[] coins, int target){

        // 数组⼤⼩为 target + 1，target amount + 1
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);

        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                // ⼦问题⽆解，跳过
                if (i - coins[j] < 0)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return (dp[target] == target + 1) ? -1 : dp[target];
    }
    public static void main(String[] args) {
        Coin main = new Coin();
        int[] coins = {1, 2, 5};
        int target = 11;
        System.out.println(main.coinChange(coins, target));
    }
}
