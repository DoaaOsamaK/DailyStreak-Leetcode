class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int longest = 0;
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < n; i++){
            if(c[i] == '(') stack.push(i);
            else{
                if(!stack.empty()){
                    if(c[stack.peek()] == '(') stack.pop();
                    else stack.push(i);
                }
                else stack.push(i);
            }
        }

        if(stack.empty()) return n;
        else{
          int limit = n;
          while(!stack.empty()){
               //getting gap to the right
              int curr = stack.pop();
              longest = Math.max(longest , (limit-curr) -1);
              limit = curr;
          }
          //getting gap to the left of the last item  of stack
          longest = Math.max(longest, limit );
        }

        return longest;
    }
}