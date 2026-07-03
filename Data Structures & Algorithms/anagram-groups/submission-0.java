class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = new String(c);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
                map.get(k).add(s);
            } else {
                map.get(k).add(s);
            }
        }
        return new ArrayList<>(map.values());
        
    }
}
