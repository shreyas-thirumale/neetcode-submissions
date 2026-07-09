class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        int left = 0;
        int right = s1.length();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (map1.equals(map2)) return true;
        while (right < s2.length()) {
            if (map2.get(s2.charAt(left)) == 1) {
                map2.remove(s2.charAt(left));
                left++;
            } else {
                map2.put(s2.charAt(left), map2.get(s2.charAt(left)) - 1);
                left++;
            }
            map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right), 0) + 1);
            if (map1.equals(map2)) return true;
            right++;
        }
        return false;
    }
}
