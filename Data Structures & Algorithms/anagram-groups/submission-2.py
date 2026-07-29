class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        seen = {}
        for temp in strs:
            new = tuple(sorted(temp))
            if new in seen:
                arr = seen[new]
                arr.append(temp)
                seen[new] = arr
            else:
                arr = [temp]
                seen[new] = arr
        ret = []
        for key in seen:
            ret.append(seen[key])
        return ret
