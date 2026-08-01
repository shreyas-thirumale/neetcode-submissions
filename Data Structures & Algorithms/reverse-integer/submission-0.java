class Solution {
    public int reverse(int x) {
        long ret = 0;
        int val = Math.abs(x);
        while (val > 0) {
            ret *= 10;
            int rem = val % 10;
            ret += rem;
            val /= 10;
        }
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return 0;
        if (x < 0) ret = ret * -1;
        return (int) ret;
    }
}
