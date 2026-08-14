class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        left = 0
        right = len(matrix) * len(matrix[0]) - 1
        while left <= right:
            mid = int((left + right)/2)
            r = int(mid / len(matrix[0]))
            c = mid % len(matrix[0])
            if (matrix[r][c] == target):
                return True
            elif (matrix[r][c] > target):
                right = mid - 1
            else:
                left = mid + 1
        return False

        