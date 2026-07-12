class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        arr[0] = 1;
        arr[1] = 1;
        return helper(n, arr);
    }
    private int helper(int n, int[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = helper(n-2, arr) + helper(n-1, arr);
        return arr[n];
    }
}
