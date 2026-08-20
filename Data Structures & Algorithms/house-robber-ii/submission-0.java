class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        else if (nums.length == 2) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        int[] arr = new int[nums.length - 1];
        arr[0] = nums[0];
        arr[1] = Math.max(arr[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            arr[i] = Math.max(arr[i-2] + nums[i], arr[i-1]);
        }
        int first = arr[nums.length - 2];
        arr[0] = nums[1];
        arr[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length-1; i++) {
            arr[i] = Math.max(arr[i-2] + nums[i+1], arr[i-1]);
        }
        return Math.max(first, arr[nums.length - 2]);

    }
}
