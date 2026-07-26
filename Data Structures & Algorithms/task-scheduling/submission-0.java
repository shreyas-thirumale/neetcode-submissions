class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        int time = 0;
        Queue<Pair> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            while (!q.isEmpty()) {
                Pair p = q.peek();
                if (time == p.nextTime) {
                    char c = p.character;
                    pq.offer(c);
                    q.poll();
                } else break;
            }
            if (!pq.isEmpty()) {
                char c = pq.poll();
                if (map.get(c) == 1) time++;
                else {
                    time++;
                    q.offer(new Pair(c, time + n));
                    map.put(c, map.get(c) - 1);
                }
            } else {
                Pair p = q.peek();
                if (time >= p.nextTime) {
                    char c = p.character;
                    pq.offer(c);
                    time++;
                    q.poll();
                } else {
                    time++;
                }
            }
        }
        return time;
    }
}

class Pair {
    char character;
    int nextTime;
    public Pair(char c, int time) {
        character = c;
        nextTime = time;
    }
}
