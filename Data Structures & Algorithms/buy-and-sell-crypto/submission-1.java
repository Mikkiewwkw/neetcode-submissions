class Solution {
    public int maxProfit(int[] prices) {
        int buyPos = 0, sellPos = 1;
        int maxProfit = 0;
        int length = prices.length;

        while (sellPos < length) {
            if (prices[sellPos] < prices[buyPos]) {
                buyPos = sellPos;
            } else {
               maxProfit = Math.max(maxProfit, prices[sellPos] - prices[buyPos]);
            }
            sellPos += 1;
        }
        return maxProfit;
    }
}
