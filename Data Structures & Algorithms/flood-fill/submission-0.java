class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void floodFill(int[][] image, int sr, int sc, int color, int starting) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color) return;
        if (starting == image[sr][sc]) image[sr][sc] = color;
        else return;
        floodFill(image, sr-1, sc, color, starting);
        floodFill(image, sr+1, sc, color, starting);
        floodFill(image, sr, sc+1, color, starting);
        floodFill(image, sr, sc-1, color, starting);
    }
}