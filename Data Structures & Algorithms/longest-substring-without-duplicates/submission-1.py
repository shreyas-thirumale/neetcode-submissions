class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        longest = 0
        left = 0
        for i in range(len(s)):
            char = s[i]
            while char in seen:
                seen.remove(s[left])
                left+=1
            seen.add(char)
            longest = max(longest, i - left + 1)
        return longest


        