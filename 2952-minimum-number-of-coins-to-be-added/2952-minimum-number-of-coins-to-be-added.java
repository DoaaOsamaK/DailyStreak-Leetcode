class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0;
        long reach = 0;

        for(int c: coins){
            while(reach+1 < c){
                reach += reach+1;
                ans++;
            }
            reach += c;
        }
        while(reach < target){
            reach += reach +1;
            ans++;
        }

        return ans;
    }}