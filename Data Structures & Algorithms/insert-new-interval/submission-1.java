class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] arr = new int[1][2];
            arr[0][0] = newInterval[0];
            arr[0][1] = newInterval[1];
            return arr;
        }
        List<List<Integer>> list = new ArrayList<>();
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        for (int[] temp : intervals) {
            int start = temp[0];
            int end = temp[1];
            if (start <= currEnd) {
                currEnd = Math.max(currEnd, end);
            } else {
                List<Integer> e = new ArrayList<>();
                e.add(currStart);
                e.add(currEnd);
                list.add(e);
                currStart = start;
                currEnd = end;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(currStart);
        temp.add(currEnd);
        list.add(temp);
        temp = new ArrayList<>();
        temp.add(newInterval[0]);
        temp.add(newInterval[1]);
        list.add(temp);
        Collections.sort(list, (a,b) -> a.get(0) - b.get(0));
        currStart = list.get(0).get(0);
        currEnd = list.get(0).get(1);
        List<List<Integer>> prop = new ArrayList<>();
        for (List<Integer> rang : list) {
            int start = rang.get(0);
            int end = rang.get(1);
            if (start <= currEnd) {
                currEnd = Math.max(currEnd, end);
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(currStart);
                t.add(currEnd);
                prop.add(t);
                currStart = start;
                currEnd = end;
            }
        }
        temp = new ArrayList<>();
        temp.add(currStart);
        temp.add(currEnd);
        prop.add(temp);
        int[][] arr = new int[prop.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = prop.get(i).get(0);
            arr[i][1] = prop.get(i).get(1);
        }
        return arr;
    }
}
