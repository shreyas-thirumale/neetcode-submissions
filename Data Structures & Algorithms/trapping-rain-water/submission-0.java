class Solution {
    public int trap(int[] height) {
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        while (left < right) {
            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);
            if (maxLeft < maxRight) {
                total += maxLeft - height[left];
                left++;
            } else {
                total += maxRight - height[right];
                right--;
            }
        }
        return total;
        
    }
}
