/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Pair {

}
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }
        Node front = null;
        Node iter = null;
        curr = head;
        while (curr != null) {
            Node temp = map.get(curr);
            temp.next = map.get(curr.next);
            temp.random = map.get(curr.random);
            iter = temp;
            if (front == null) front = iter;
            iter = iter.next;
            curr = curr.next;
        }
        return front;
    }
}
