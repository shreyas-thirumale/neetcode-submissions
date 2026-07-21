class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Pair temp = new Pair(i, j);
                    queue.offer(temp);
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int i = p.i;
            int j = p.j;
            if (i - 1 >= 0) {
                if (grid[i-1][j] == Integer.MAX_VALUE) {
                    grid[i-1][j] = grid[i][j] + 1;
                    queue.offer(new Pair(i-1, j));
                }
            } if (i + 1 < grid.length) {
                if (grid[i+1][j] == Integer.MAX_VALUE) {
                    grid[i+1][j] = grid[i][j] + 1;
                    queue.offer(new Pair(i+1, j));
                }
            } if (j - 1 >= 0) {
                if (grid[i][j-1] == Integer.MAX_VALUE) {
                    grid[i][j-1] = grid[i][j] + 1;
                    queue.offer(new Pair(i, j-1));
                }
            } if (j + 1 < grid[0].length) {
                if (grid[i][j+1] == Integer.MAX_VALUE) {
                    grid[i][j+1] = grid[i][j] + 1;
                    queue.offer(new Pair(i, j+1));
                }
            }
        }
    }
}
class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
