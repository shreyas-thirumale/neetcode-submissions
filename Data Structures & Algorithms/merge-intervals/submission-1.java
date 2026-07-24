class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        List<List<Integer>> list = new ArrayList<>();
        for (int[] temp : intervals) {
            int start = temp[0];
            int end = temp[1];
            if (start <= currEnd) {
                currEnd = Math.max(currEnd, end);
            } else {
                List<Integer> toAdd = new ArrayList<>();
                toAdd.add(currStart);
                toAdd.add(currEnd);
                list.add(toAdd);
                currStart = start;
                currEnd = end;
            }
        }
        List<Integer> t = new ArrayList<>();
        t.add(currStart);
        t.add(currEnd);
        list.add(t);
        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arr[i][0] = list.get(i).get(0);
            arr[i][1] = list.get(i).get(1);
        }
        return arr;
    }
}
