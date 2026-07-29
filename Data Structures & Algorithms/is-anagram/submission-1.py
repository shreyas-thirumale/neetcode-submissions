class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_seen = {}
        t_seen = {}
        for c in s:
            if c in s_seen:
                s_seen[c] = s_seen[c] + 1
            else:
                s_seen[c] = 0
        for c in t:
            if c in t_seen:
                t_seen[c] = t_seen[c] + 1
            else:
                t_seen[c] = 0
        return s_seen == t_seen
        