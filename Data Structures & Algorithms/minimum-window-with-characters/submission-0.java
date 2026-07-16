class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int min = Integer.MAX_VALUE;
        String ret = "";
        int charMet = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map1.containsKey(c)) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
                if (map1.get(c) == map2.get(c)) charMet++;
            }
            if (!(charMet == map1.keySet().size())) continue;
            while (!map1.keySet().contains(s.charAt(left)) || map1.get(s.charAt(left)) < map2.get(s.charAt(left))) {
                if (map2.containsKey(s.charAt(left))) {
                    map2.put(s.charAt(left), map2.get(s.charAt(left)) - 1);
                    if (map2.get(s.charAt(left)) < map1.get(s.charAt(left))) charMet--;
                }
                left++;
            }
            if (right - left + 1 < min) {
                ret = s.substring(left, right+1);
                min = right - left + 1;
            }
        }
        return ret;
    }
}
