package dptable;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */


public class Offer63 {
    //注意，只买卖一次
    public int maxProfit1(int[] prices) {

        int minprice = Integer.MAX_VALUE;
        int maxMoney = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minprice){
                minprice = prices[i]; //记录历史最低股价
            }else if(prices[i] - minprice > maxMoney){//如果当天股价减去历时最低股价高于最大收益，
                maxMoney = prices[i] - minprice;//卖出，跟新最大收益
            }
        }
        return maxMoney;
    }

    //状态转移方程
    // profit = max(profit, price - min(cost, price))
    //cost 为历史最低价格
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
