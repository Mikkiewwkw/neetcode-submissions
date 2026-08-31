class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, 0, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(int[] nums, int total, int target,  List<List<Integer>> res, List<Integer> cur, int i) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) return;
            cur.add(nums[j]);
            backtrack(nums, total + nums[j], target, res, cur, j);
            cur.remove(cur.size() - 1);
        }
    }
}
