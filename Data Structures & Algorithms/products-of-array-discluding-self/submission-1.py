class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        pref = [1] * len(nums)
        suff = [1] * len(nums)
        ret = [0] * len(nums)
        for i in range(1, len(nums)):
            pref[i] = nums[i-1] * pref[i-1]
        for i in range(len(nums) - 2, -1, -1):
            suff[i] = nums[i+1] * suff[i+1]
        for i in range(len(pref)):
            ret[i] = pref[i] * suff[i]
        return ret

        