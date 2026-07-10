class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int curr = temperatures[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > curr) {
                    arr[i] = j - i;
                    break;
                } else arr[i] = 0;
            }
        }
        return arr;
    }
}
