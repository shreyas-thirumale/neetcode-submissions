class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        arr = []
        for char in tokens:
            if char == '+':
                first = arr.pop()
                second = arr.pop()
                arr.append(int(first) + int(second))
            elif char == '-':
                first = arr.pop()
                second = arr.pop()
                arr.append(int(second) - int(first))
            elif char == '*':
                first = arr.pop()
                second = arr.pop()
                arr.append(int(first) * int(second))
            elif char == '/':
                first = arr.pop()
                second = arr.pop()
                arr.append(int(int(second) / int(first)))
            else:
                arr.append(int(char))
        return arr.pop()

        