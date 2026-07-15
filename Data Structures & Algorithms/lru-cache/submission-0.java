class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            add(curr);
            return curr.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node alr = map.get(key);
            alr.val = value;
            remove(alr);
            add(alr);
            map.put(key, alr);
            return;
        } else if (map.keySet().size() == capacity) {
            Node toRemove = head.next;
            map.remove(toRemove.key);
            remove(toRemove);
        } 
        Node n = new Node(key, value);
        map.put(key, n);
        add(n);
    }

    ///////////////

    private void remove(Node node) {
        Node bef = node.prev;
        Node aft = node.next;
        bef.next = aft;
        aft.prev = bef;
        node.next = null;
        node.prev = null;
    }

    private void add(Node node) {
        Node bef = tail.prev;
        node.next = tail;
        node.prev = bef;
        bef.next = node;
        tail.prev = node;
    }
}