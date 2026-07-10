class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int f = stack.pop();
                int s = stack.pop();
                int res = s + f;
                stack.push(res);

            }
            else if (tokens[i].equals("-")) {
                int f = stack.pop();
                int s = stack.pop();
                int res = s - f;
                stack.push(res);
                
            }
            else if (tokens[i].equals("/")) {
                int f = stack.pop();
                int s = stack.pop();
                int res = s / f;
                stack.push(res);
                
            }
            else if (tokens[i].equals("*")) {
                int f = stack.pop();
                int s = stack.pop();
                int res = s * f;
                stack.push(res);
                
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
