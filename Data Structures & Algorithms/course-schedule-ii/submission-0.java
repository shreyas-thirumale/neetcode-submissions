class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : prerequisites) {
            int post = arr[0];
            int pre = arr[1];
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
        Set<Integer> path = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> tot = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(map, path, tot, i, list) == false) return new int[]{};
        }
        if (list.size() != numCourses) return new int[]{};
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    private boolean dfs(Map<Integer, Set<Integer>> map, Set<Integer> path, Set<Integer> tot, int course, List<Integer> list) {
        if (path.contains(course)) return false;
        if (tot.contains(course)) return true;
        path.add(course);
        if (map.containsKey(course)) {
            for (int num : map.get(course)) {
                if (dfs(map, path, tot, num, list) == false) return false;
            }
        }
        path.remove(course);
        list.add(0, course);
        tot.add(course);
        return true;
    }
}
