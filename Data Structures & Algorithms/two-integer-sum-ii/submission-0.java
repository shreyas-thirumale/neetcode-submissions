class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (map.containsKey(num)) {
                arr[0] = map.get(num);
                arr[1] = i+1;
                return arr;
            } else {
                map.put(target - num, i+1);
            }
        }
        return arr;
    }
}
