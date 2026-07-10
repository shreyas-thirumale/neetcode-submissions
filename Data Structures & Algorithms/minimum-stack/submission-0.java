class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> pq;
    public MinStack() {
        pq = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (pq.isEmpty() || val <= pq.peek()) {
            pq.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        int removed = stack.pop();
        if (removed == pq.peek()) {
            pq.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}
