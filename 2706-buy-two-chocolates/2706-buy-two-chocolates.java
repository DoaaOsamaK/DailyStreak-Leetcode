class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i] + prices[i+1] <= money)
            {
                min = money - (prices[i] + prices[i+1]);
                break;
            }
        }
        if(min==Integer.MAX_VALUE) return money;
        return min;
    }
}