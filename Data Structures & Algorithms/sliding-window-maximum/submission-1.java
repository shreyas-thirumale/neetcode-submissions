class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deck = new ArrayDeque<>();
        int[] ret = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!deck.isEmpty() && deck.peekFirst() <= i - k) {
                deck.removeFirst();
            }
            while (!deck.isEmpty() && nums[deck.peekLast()] <= nums[i]) {
                deck.removeLast();
            }
            deck.addLast(i);
            if (i >= k - 1) {
                ret[idx] = nums[deck.peekFirst()];
                idx++;
            }

        }

        return ret;
    }
}
