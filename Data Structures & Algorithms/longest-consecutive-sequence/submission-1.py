class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = set()
        for num in nums:
            seen.add(num)
        longest = 0
        for num in seen:
            if num - 1 in seen:
                continue
            temp = num
            count = 1
            while temp + 1 in seen:
                temp+=1
                count+=1
            longest = max(longest, count)
        return longest
        