class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        arr = [0] * 3 
        for i in range(len(triplets)):
            first = triplets[i][0]
            second = triplets[i][1]
            third = triplets[i][2]
            if first <= target[0] and second <= target[1] and third <= target[2]:
                arr[0] = max(first, arr[0])
                arr[1] = max(second, arr[1])
                arr[2] = max(third, arr[2])
        for i in range(len(arr)):
            if target[i] != arr[i]:
                return False
        return True
        