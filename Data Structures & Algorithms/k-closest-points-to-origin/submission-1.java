class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] arr = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.x*a.x + a.y*a.y) - (b.x*b.x + b.y*b.y));
        for (int[] temp : points) {
            pq.offer(new Pair(temp[0], temp[1]));
        }
        for (int i = 0; i < arr.length; i++) {
            Pair obj = pq.poll();
            arr[i][0] = obj.x;
            arr[i][1] = obj.y;
        }
        return arr;
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
