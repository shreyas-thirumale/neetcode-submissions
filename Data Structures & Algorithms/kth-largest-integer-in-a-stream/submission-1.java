class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) {
            pq.poll();
        } 
        int ret = pq.peek();
        return ret;
    }
}
