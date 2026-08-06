class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : map.keySet()) {
            max = Math.max(max, map.get(num));
        }
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            arr.add(new ArrayList<>());
        }
        for (int num : map.keySet()) {
            int index = map.get(num);
            List<Integer> temp = arr.get(index);
            temp.add(num);
        }
        int i = arr.size() - 1;
        int[] ret = new int[k];
        int index = 0;
        while (k > 0) {
            if (arr.get(i).size() > 0) {
                for (int num : arr.get(i)) {
                    if (k == 0) break;
                    ret[index++] = num;
                    k--;
                }
                i--;
            } else {
                i--;
            }
        }
        return ret;
    }
}