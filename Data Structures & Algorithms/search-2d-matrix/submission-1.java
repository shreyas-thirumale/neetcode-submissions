class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int r = mid / matrix[0].length;
            int c = mid % matrix[0].length;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
