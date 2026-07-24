class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Integer[][] memo = new Integer[n][k+2];
        int result = dfs(flights, src, dst, k+1, memo);
        if (result == Integer.MAX_VALUE) return -1;
        return result;
        
    }
    private int dfs(int[][] flights, int curr, int dst, int steps, Integer[][] memo) {
        int min = Integer.MAX_VALUE;
        if (curr == dst) return 0;
        if (steps <= 0 && curr != dst) return Integer.MAX_VALUE;
        if (memo[curr][steps] != null) return memo[curr][steps];
        else {
            for (int[] arr : flights) {
                int from = arr[0];
                int to = arr[1];
                int price = arr[2];
                int temp = Integer.MAX_VALUE;
                if (from == curr) {
                    temp = dfs(flights, to, dst, steps-1, memo);
                    if (temp != Integer.MAX_VALUE) {
                        min = Math.min(temp + price, min);
                    }
                }
            }
        }
        memo[curr][steps] = min;
        return min;
    }
}