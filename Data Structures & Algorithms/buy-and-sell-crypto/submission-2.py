class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        largest = 0
        smallest = prices[0]
        for num in prices:
            if num < smallest:
                smallest = num
                continue
            largest = max(largest, num - smallest)
        return largest
        