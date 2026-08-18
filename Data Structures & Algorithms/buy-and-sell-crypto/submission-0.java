class Solution {
    public int maxProfit(int[] prices) {
        int buyPos = 0;
        int sellPos = 1;
        int maxProfit = 0;
        int length = prices.length;
        int tempMaxProfit = 0;

        while (sellPos < length) {
            if (prices[sellPos] < prices[buyPos]) {
                buyPos = sellPos;
                sellPos += 1;
                tempMaxProfit = 0;
            } else {
               maxProfit = Math.max(maxProfit, tempMaxProfit + prices[sellPos] - prices[buyPos]);
               sellPos += 1;
            }
        }
        return maxProfit;
    }
}
