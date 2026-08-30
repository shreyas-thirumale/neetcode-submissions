class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(
        int[] nums,
        int target,
        int start,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            current.add(nums[i]);
            dfs(nums, target - nums[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}