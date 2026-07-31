class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, nums, 0, new ArrayList<>());
        return list;
    }
    private void helper(List<List<Integer>> list, int[] nums, int i, List<Integer> sub) {
        if (i >= nums.length) {
            List<Integer> add = new ArrayList<>(sub);
            list.add(add);
            return;
        }
        sub.add(nums[i]);
        helper(list, nums, i+1, sub);
        sub.remove(sub.size() - 1);
        helper(list, nums, i+1, sub);
    }
}
