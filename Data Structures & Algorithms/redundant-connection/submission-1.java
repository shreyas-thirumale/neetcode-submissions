class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int max = 0;
        for (int[] arr : edges) {
            int first = arr[0];
            int second = arr[1];
            max = Math.max(first, max);
            max = Math.max(max, second); 
        }
        parent = new int[max + 1];
        for (int i = 1; i < max+1; i++) {
            parent[i] = i;
        }
        for (int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];
            if (find(a) == find(b)) return arr;
            union(a, b);
        }
        return new int[]{};
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x, int y) {
        int parA = find(x);
        int parB = find(y);
        if (parA < parB) {
            parent[parB] = parA;
        } else {
            parent[parA] = parB;
        }
    }
}
