class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g = 0;
        int c = 0;
        for (int i = 0; i < gas.length; i++) {
            g += gas[i];
            c += cost[i];
        }
        if (c > g) return -1;
        int ret = 0;
        int curr = 0;
        int cos = 0;
        for (int i = 0; i < gas.length; i++) {
            curr += gas[i];
            cos += cost[i];
            if (curr < cos) {
                curr = 0;
                cos = 0;
                ret = i+1;
            }
        }
        return ret;
        
    }
}
