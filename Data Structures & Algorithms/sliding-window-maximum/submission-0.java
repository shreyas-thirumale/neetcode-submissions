class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int right = i + k - 1;
            if (right >= nums.length) break;
            int max = Integer.MIN_VALUE;
            for (int j = i; j <= right; j++) {
                max = Math.max(nums[j], max);
            }
            arr.add(max);
        }
        int[] ret = new int[arr.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }
}
