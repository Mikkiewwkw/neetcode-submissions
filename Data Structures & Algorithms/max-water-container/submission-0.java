class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, area = 0;
        while (l < r) {
            area = Math.max(area, (r - l) * Math.min(heights[l], heights[r]));
            if (heights[l] <= heights[r]) l++;
            else r--;
        }
        return area;
    }
}