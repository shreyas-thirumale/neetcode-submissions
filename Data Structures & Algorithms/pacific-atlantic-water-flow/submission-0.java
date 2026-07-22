class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, pac, heights, i, 0);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(0, j, pac, heights, 0, j);
        }
        for (int i = 0; i < heights.length; i++) {
            dfs(i, heights[0].length - 1, atl, heights, i, heights[0].length - 1);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(heights.length - 1, j, atl, heights, heights.length - 1, j);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] == true && atl[i][j] == true) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }

    private void dfs(int i, int j, boolean[][] visited, int[][] heights, int from1, int from2) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || heights[i][j] < heights[from1][from2]) return;
        else if (visited[i][j] == true) return;
        if (heights[i][j] >= heights[from1][from2]) {
            visited[i][j] = true;
            dfs(i+1, j, visited, heights, i, j);
            dfs(i-1, j, visited, heights, i, j);
            dfs(i, j+1, visited, heights, i, j);
            dfs(i, j-1, visited, heights, i, j);
        }
        return;
    }
}
