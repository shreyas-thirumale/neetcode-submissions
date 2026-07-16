class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxval = 0;
        for (int i = 0; i < piles.length; i++) {
            maxval = Math.max(maxval, piles[i]);
        }
        int left = 1;
        int right = maxval;
        int smallest = maxval;
        while (left < right) {
            boolean works = false;
            int mid = (left + right) / 2;
            int tempCount = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] % mid != 0) tempCount += (piles[i] / mid) + 1;
                else tempCount += (piles[i] / mid);
            }
            if (tempCount > h) {
                works = false;
                left = mid + 1;
            } else {
                works = true;
                smallest = Math.min(smallest, mid);
                right = mid;
            }
        }
        return smallest;
    }
}
