class Solution:
    def trap(self, height: List[int]) -> int:
        maxLeft = 0
        maxRight = 0
        left = 0
        right = len(height) - 1
        total = 0
        while (left < right):
            currLeft = height[left]
            currRight = height[right]
            maxLeft = max(maxLeft, currLeft)
            maxRight = max(maxRight, currRight)
            if maxLeft < maxRight:
                total += maxLeft - currLeft
                left+=1
            else:
                total += maxRight - currRight
                right-=1
        return total
            

        