class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            int l = heights[left];
            int r = heights[right];
            int curr = Math.min(l, r) * (right - left);
            max = Math.max(curr, max);
            if (l < r) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
