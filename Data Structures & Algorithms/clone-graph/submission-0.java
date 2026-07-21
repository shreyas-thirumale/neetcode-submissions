/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(map, node);
    }
    private Node dfs(Map<Node, Node> map, Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node)) {
            Node temp = map.get(node);
            return temp;
        }
        
        Node n = new Node(node.val);
        map.put(node, n);
        for (Node neighbor : node.neighbors) {
            n.neighbors.add(dfs(map, neighbor));
        }
        return n;
    }
}