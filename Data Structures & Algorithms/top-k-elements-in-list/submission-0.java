class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int associated = Integer.MIN_VALUE;
        int[] arr = new int[k];
        int i = 0;
        while (k > 0) {
        int max = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    associated = key;
                }
            }
            arr[i] = associated;
            i++;
            k--;
            map.remove(associated);
        }
        return arr;
    }
}
