class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) return mid;
            // left half is sorted
            else if (nums[l] <= nums[mid]) {
                // check if target can be in the sorted half
                if (target < nums[mid] && target >= nums[l]) r = mid - 1;
                else l = mid + 1;
            } else {  // right half is sorted
                // check if target can be in the sorted half
                if (target > nums[mid] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}