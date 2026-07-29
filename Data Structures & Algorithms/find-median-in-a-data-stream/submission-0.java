class MedianFinder {
    PriorityQueue<Integer> pq;
    List<Integer> list;
    
    public MedianFinder() {
        pq = new PriorityQueue<>();
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        pq.offer(num);
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int size = pq.size();
        int i = 0;
        if (size % 2 == 1) {
            for (int num : list) {
                if (i == (size / 2)) {
                    return num;
                }
                i++;
            }
        } else {
            int first = 0;
            int second = 0;
            for (int num : list) {
                if (i == (size / 2)) first = num;
                else if (i == (size / 2) - 1) second = num;
                i++;
            }
            return (double) (first + second) / (double) 2;
        }
        return 0;
    }
    
}
