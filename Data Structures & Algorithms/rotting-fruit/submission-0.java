class Solution {
    public int orangesRotting(int[][] grid) {
        int numOrangeCells = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
                if (grid[i][j] == 1|| grid[i][j] == 2) {
                    numOrangeCells++;
                }
            }
        }
        if (numOrangeCells == 0) return 0;
        int time = -1;
        int temp = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            temp += size;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                if (x - 1 >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    q.offer(new Pair(x-1, y));
                }
                if (x + 1 >= 0 && x+1 < grid.length && y >= 0 && y < grid[0].length && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    q.offer(new Pair(x+1, y));
                }
                if (x >= 0 && x < grid.length && y-1 >= 0 && y-1 < grid[0].length && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    q.offer(new Pair(x, y-1));
                }
                if (x >= 0 && x < grid.length && y+1 >= 0 && y+1 < grid[0].length && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    q.offer(new Pair(x, y+1));
                }
            }
            time++;
        }
        if (numOrangeCells != temp) return -1;
        return time;
    }
}

class Pair {
    int x;
    int y;
    public Pair(int i, int j) {
        x = i;
        y = j;
    }
}