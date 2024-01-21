class Solution {
    public int sumSubarrayMins(int[] arr) {
	    Deque<Integer> stack = new ArrayDeque<>();
        
        // left bound we set of -1
        stack.push(-1);
        long res = 0;
        for(int i = 0; i < arr.length; i++) {
            while(stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                int currElemIndex = stack.pop();
           
                res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * ( i - currElemIndex)) % 1000000007;
                res = res % 1000000007;
            }
            stack.push(i);
        }
    
        // right bound we set to array length;
        int rightBoundary = arr.length;
    
        while(stack.size() > 1) {
            int currElemIndex = stack.pop();
            res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * (rightBoundary - currElemIndex)) % 1000000007;
            res = res % 1000000007;
        }
        
        return (int) res;
        
    }
}