class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set =new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int val = 0;
        while (set.contains(val)) {
            val++;
        }
        return val;
        
    }
}
