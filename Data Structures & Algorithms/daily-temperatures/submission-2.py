class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        arr = []
        ret = [0] * len(temperatures)
        for i in range(len(temperatures)):
            num = temperatures[i]
            while len(arr) > 0 and num > temperatures[arr[-1]]:
                ret[arr[-1]] = i - arr[-1]
                arr.pop()
            arr.append(i)
        return ret

        