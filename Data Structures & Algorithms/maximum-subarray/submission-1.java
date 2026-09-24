class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0], max = nums[0], len = nums.length;
        for (int i = 1 ; i < len; i++) {
            if (curSum < 0) curSum = 0;
            curSum += nums[i];
            max = Math.max(max, curSum);
        }
        return max;
    }
}
