class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int numElems = matrix.length * matrix[0].length;
        List<Integer> list = new ArrayList<>();
        while (list.size() < numElems && left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }   
                bottom--;
            }
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    list.add(matrix[j][left]);
                }
                left++;
            }
        }
        return list;
    }
}