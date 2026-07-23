class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] temp : edges) {
            int first = temp[0];
            int second = temp[1];
            if (map.containsKey(first)) {
                Set<Integer> set = map.get(first);
                set.add(second);
                map.put(first, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(second);
                map.put(first, set);
            }
            if (map.containsKey(second)) {
                Set<Integer> set = map.get(second);
                set.add(first);
                map.put(second, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(first);
                map.put(second, set);
            }
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                dfs(map, set, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(Map<Integer, Set<Integer>> map, Set<Integer> visited, int num) {
        if (visited.contains(num)) return;
        visited.add(num);
        if (map.containsKey(num)) {
            for (int val : map.get(num)) {
                dfs(map, visited, val);
            }
        }
        return;
    }
}
