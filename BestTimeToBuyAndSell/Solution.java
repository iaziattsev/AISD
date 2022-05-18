package BestTimeToBuyAndSell;

public class Solution {
    public static int maxProfit(int[] prices) {
        int max = Integer.MAX_VALUE;
        int op = 0;
        int t = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < max){
                max = prices[i];
            }
            t = prices[i] - max;
            if(op < t){
                op = t;
            }
        }
        return op;
    }
}
