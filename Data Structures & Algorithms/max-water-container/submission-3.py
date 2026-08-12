class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left = 0
        right = len(heights) - 1
        largest = 0
        while left < right:
            if heights[left] < heights[right]:
                temp = heights[left] * (right - left)
                largest = max(largest, temp)
                left+=1
            else:
                temp = heights[right] * (right - left)
                largest = max(largest, temp)
                right-=1
        return largest