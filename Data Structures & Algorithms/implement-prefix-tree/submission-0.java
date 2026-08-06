class Node {
    Map<Character, Node> map;
    boolean end = false;
    public Node() {
        map = new HashMap<>();
        end = false;
    }
    public Node(boolean end) {
        map = new HashMap<>();
        this.end = end;
    }
}

class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }
    
    public void insert(String word) {
        Map<Character, Node> map = root.map;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.map.containsKey(c)) {
                curr = curr.map.get(c);
            } else {
                if (i == word.length() - 1) {
                    curr.map.put(c, new Node(true));
                } else curr.map.put(c, new Node());
                curr = curr.map.get(c);
            }
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.map.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.map.get(word.charAt(i));
        }
        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.map.containsKey(c)) {
                curr = curr.map.get(c);
            } else return false;
        }
        return true;
    }
}

