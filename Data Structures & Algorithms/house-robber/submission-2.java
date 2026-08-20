class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[1], arr[0]);
        for (int i = 2; i < nums.length; i++) {
            arr[i] = Math.max(arr[i-2] + nums[i], arr[i-1]);
        }
        return arr[nums.length - 1];
    }
}
