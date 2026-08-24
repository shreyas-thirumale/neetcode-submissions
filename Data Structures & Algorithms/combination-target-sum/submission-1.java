class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, target, temp, list, 0);
        return list;
        
    }
    private void dfs(int[] nums, int target, List<Integer> list, List<List<Integer>> ret, int i) {
        if (target < 0) return;
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            dfs(nums, target - nums[j], list, ret, j);
            list.remove(list.size() - 1);
        }
    }

}
