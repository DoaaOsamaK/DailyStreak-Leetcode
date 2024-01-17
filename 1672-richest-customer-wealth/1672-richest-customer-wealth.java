class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum=0;
        for(int[] a:accounts){
            int s=0;
            for(int num:a){
                s+=num;
            }
            if(sum<s){
                sum=s;
            }
        }
        return sum;
    }
}