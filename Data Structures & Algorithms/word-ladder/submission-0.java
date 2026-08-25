class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if (diff(word1, word2)) {
                    if (map.containsKey(word1)) {
                        map.get(word1).add(word2);
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(word2);
                        map.put(word1, set);
                    }
                    if (map.containsKey(word2)) {
                        map.get(word2).add(word1);
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(word1);
                        map.put(word2, set);
                    }
                }
            }
        }
        if (!map.keySet().contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> set = new HashSet<>();
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                for (String str : map.get(q.poll())) {
                    if (!set.contains(str)) {
                        q.offer(str);
                        set.add(str);
                    }
                }
            }
            count++;
            if (set.contains(endWord)) return count;
        }
        return 0;
    }
    private boolean diff(String str1, String str2) {
        int diffs = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) diffs++;
        }
        return diffs == 1;
    }
}
