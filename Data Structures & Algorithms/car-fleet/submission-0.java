class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] arr = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b) -> b[0] - a[0]);
        int fleets = 0;
        for (int i = 0; i < arr.length; i++) {
            double temp = (target - arr[i][0]) / (double) arr[i][1];
            if (stack.isEmpty() || temp > stack.peek()) {
                fleets++;
                stack.push(temp);
            }
            else {
                continue;
            }
        }
        return fleets;
    }
}