class Solution {
    public int getSum(int a, int b) {
        int res = 0;
        while (b != 0) {
            int rem = (a & b) << 1;
            a = a ^ b;
            b = rem;
        }
        return a;
    }
}
