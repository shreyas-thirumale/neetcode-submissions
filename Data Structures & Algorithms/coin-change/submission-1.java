class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount+1);
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minAmount;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    arr[i] = Math.min(arr[i], 1 + arr[i-coin]);
                    minAmount = arr[i];
                }
            }
        }
        return arr[amount] > amount ? -1 : arr[amount];
    }
}