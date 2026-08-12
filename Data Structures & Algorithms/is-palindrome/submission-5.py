class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        arr = []
        for char in s:
            if char.isalnum():
                arr.append(char)
        
        left = 0
        right = len(arr) - 1
        while left < right:
            if arr[left] == arr[right]:
                left+=1
                right-=1
                continue
            return False
        return True        