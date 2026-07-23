class Solution {
    public int jump(int[] nums) {
        int currEnd = 0;
        int farthest = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (currEnd >= nums.length) return count;
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currEnd) {
                currEnd = farthest;
                count++;
            }
        }
        return count;
    }
}
