class Solution {
    public void setZeroes(int[][] matrix) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) stack.push(new Pair(i, j));
            }
        }
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[x][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}