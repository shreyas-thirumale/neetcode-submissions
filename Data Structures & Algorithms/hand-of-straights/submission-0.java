class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1); 
        }
        for (int num : hand) {
            if (!map.containsKey(num)) continue;
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) map.remove(num);
            for (int i = 1; i < groupSize; i++) {
                int next = num + i;
                if (!map.containsKey(next)) return false;
                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) map.remove(next);
            }
        }
        return true;
    }
}
