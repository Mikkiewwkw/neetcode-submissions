class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // left half is sorted
            if (nums[l] <= nums[mid]) {
                if (nums[l] > nums[r]) l = mid + 1;
                else r = mid - 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}

// 4 5 6 1 2 3