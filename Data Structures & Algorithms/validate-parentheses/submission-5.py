class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pair = {'}': '{', ')':'(', ']':'['}
        for char in s:
            if char not in pair.keys():
                stack.append(char)
            else:
                if len(stack) == 0 or stack[-1] != pair[char]:
                    return False
                stack.pop()
        return len(stack) == 0