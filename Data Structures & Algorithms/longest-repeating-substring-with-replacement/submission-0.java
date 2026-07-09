class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
            while ((i - left + 1) - maxPerTime(map) > k) {
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
    private int maxPerTime(Map<Character, Integer> map) {
        int max = 0;
        for (char c : map.keySet()) {
            max = Math.max(map.get(c), max);
        }
        return max;
    }
}
