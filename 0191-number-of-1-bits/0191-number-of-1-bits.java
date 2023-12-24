public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //System.out.println(n);
        int ans  = 0;
        for(int i = 0 ; i < 32 ; i++){
           ans += n & 1;
           n >>= 1;
        }
        return ans;
    }
}