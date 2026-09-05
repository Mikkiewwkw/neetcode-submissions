class Solution {
    public int rob(int[] nums) {
        if (nums.length <=1) return nums[0];
        int prevMax = nums[0];
        int curMax = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            int temp = curMax;
            curMax = Math.max(curMax, nums[i] + prevMax);
            prevMax = temp;
        }
        return curMax;
    }
}
