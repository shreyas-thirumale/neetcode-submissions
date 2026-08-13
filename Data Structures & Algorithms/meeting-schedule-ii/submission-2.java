/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        int rooms = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval num : intervals) {
            int start = num.start;
            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(num.end);
            rooms = Math.max(pq.size(), rooms);
        }
        return rooms;
    }
}
