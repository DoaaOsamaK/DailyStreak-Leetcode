class MyStack {
private LinkedList<Integer> stack;
    public MyStack() {
        stack = new LinkedList<>();
    }  
    public void push(int x) {
        stack.push(x);
    } 
    public int pop() {
      if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop();   
    }   
    public int top() {
       if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek(); 
    }  
    public boolean empty() {
       return stack.isEmpty();
    } 
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
