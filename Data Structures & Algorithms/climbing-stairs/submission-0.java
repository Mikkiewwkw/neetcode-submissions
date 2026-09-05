class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 1; i < n; i++) {
            int temp = prev1;
            prev1 = prev1 + prev2;
            prev2 = temp;
        }
        return prev1;
    }
}
