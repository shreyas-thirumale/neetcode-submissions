class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int num : set) {
            int count = 1;
            int curr = num;
            if (set.contains(num - 1)) continue;
            else {
                while (set.contains(curr + 1)) {
                    count++;
                    curr++;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
