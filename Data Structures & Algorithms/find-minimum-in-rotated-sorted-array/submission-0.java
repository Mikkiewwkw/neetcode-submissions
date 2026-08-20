class Solution {
    public int findMin(int[] nums) {
       int l = 0;
       int r = nums.length - 1;
       int res = nums[l];

       while (l <= r) {
        if (nums[l] < nums[r]) {
            res = Math.min(res, nums[l]);
            break;
        }
        int mid = l + (r - l) / 2;
        res = Math.min(res, nums[mid]);
        if (nums[mid] < nums[l]) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
       }
       return res;

    }
}
