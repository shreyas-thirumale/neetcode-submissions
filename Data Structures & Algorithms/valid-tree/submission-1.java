class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            int first = arr[0];
            int second = arr[1];
            map.put(first, map.getOrDefault(first, new HashSet<>()));
            map.put(second, map.getOrDefault(second, new HashSet<>()));
            map.get(first).add(second);
            map.get(second).add(first);
        }
        Set<Integer> path = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        if (dfs(0, -1, map, path, set) == false) return false;
        return set.size() == n;
    }
    private boolean dfs(int n, int par, Map<Integer, Set<Integer>> map, Set<Integer> path, Set<Integer> set) {
        if (path.contains(n)) return false;
        if (set.contains(n)) return true;
        path.add(n);
        if (map.containsKey(n)) {
            for (int num : map.get(n)) {
                if (num == par) continue;
                if (dfs(num, n, map, path, set) == false) return false;
            }
        }
        path.remove(n);
        set.add(n);
        return true;
    }
}
