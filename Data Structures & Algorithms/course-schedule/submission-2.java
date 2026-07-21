class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>(); // store prereqs to classes able to take after
        for (int[] temp : prerequisites) {
            int pre = temp[1];
            int post = temp[0];
            if (map.containsKey(pre)) {
                Set<Integer> set = map.get(pre);
                set.add(post);
                map.put(pre, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(post);
                map.put(pre, set);
            }
        }
        Set<Integer> tot = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(map, tot, path, i) == false) return false;
        }
        return true;
    }
    private boolean dfs(Map<Integer, Set<Integer>> map, Set<Integer> tot, Set<Integer> path, int course) {
        if (path.contains(course)) return false;
        if (tot.contains(course)) return true;
        path.add(course);
        for (int val : map.getOrDefault(course, new HashSet<>())) {
            if (dfs(map, tot, path, val) == false) return false;
        }
        path.remove(course);
        tot.add(course);
        return true;
    }

}
