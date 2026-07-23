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
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = 0;
        for (Interval obj : intervals) {
            int start = obj.start;
            int end = obj.end;
            while (!q.isEmpty() && start >= q.peek()) {
                q.poll();
            }
            q.offer(end);
            max = Math.max(q.size(), max);
        }
        return max;
    }
}
