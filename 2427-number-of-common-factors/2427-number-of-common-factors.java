    class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;
        int n = Math.min(a,b);
        for(int i = 1; i<n+1;i++){
            if(a%i == 0 && b%i == 0) count++;
        }
        return count;
    }
}