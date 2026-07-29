class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            char c = s.charAt(i);
            int ending = map.get(c);
            while (i < s.length() && i <= ending) {
                char temp = s.charAt(i);
                ending = Math.max(map.get(temp), ending);
                i++;
            }
            arr.add(ending - start + 1);
            i--;
        }
        return arr;
    }
}
