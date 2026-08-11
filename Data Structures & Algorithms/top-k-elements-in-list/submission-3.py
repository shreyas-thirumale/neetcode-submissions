class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        seen = Counter(nums)
        ret = []
        heap = []
        for num in seen.keys():
            heapq.heappush(heap, (-1 * seen[num], num))
        while k > 0:
            ret.append(heapq.heappop(heap)[1])
            k-=1
        return ret