class Solution {
    public String longestPalindrome(String s) {
        int mid = s.length() / 2;
        int max = 0;
        String maxLen = "";
        for (int i = 0; i < s.length(); i++) {
            Pair odd = bounds(s, i, i);
            Pair even = bounds(s, i, i+1);
            if (odd.r - odd.l > even.r - even.l) {
                if (odd.r - odd.l > max) {
                    max = odd.r - odd.l;
                    maxLen = s.substring(odd.l, odd.r);
                }
            } else {
                if (even.r - even.l > max) {
                    max = even.r - even.l;
                    maxLen = s.substring(even.l, even.r);
                }
            }
        }
        return maxLen;
        
    }
    private Pair bounds(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new Pair(l + 1, r);
    }

}


class Pair {
    int l;
    int r;
    public Pair(int left, int right) {
        l = left;
        r = right;
    }
}
