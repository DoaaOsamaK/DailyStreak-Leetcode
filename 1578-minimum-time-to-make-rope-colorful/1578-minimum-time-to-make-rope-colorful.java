class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int i = 0, result=0;
        while(i<=n-2) {
            if(colors.charAt(i)!=colors.charAt(i+1)) {
                i++;
                continue;
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            while(i<=n-2 && colors.charAt(i)==colors.charAt(i+1)) {
                sum = sum + neededTime[i];
                max = Math.max(max,neededTime[i]);
                i++;
            }
            sum = sum + neededTime[i];
            max = Math.max(max,neededTime[i]);
            result+=sum-max;
        }
        return result;
    }
}