class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            if (uniqueSet.contains(num)) {
                return true;
            } else {
                uniqueSet.add(num);
            }
        }
        return false;
    }
}