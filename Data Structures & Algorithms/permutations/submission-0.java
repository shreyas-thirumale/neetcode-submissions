class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        backtrack(nums, list, temp, set);
        return list;
        
    }
    private void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> curr, Set<Integer> set) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) continue;
                curr.add(nums[i]);
                set.add(nums[i]);
                backtrack(nums, ret, curr, set);
                curr.remove(curr.size() - 1);
                set.remove(nums[i]);
            }
        }
        
    }  
}