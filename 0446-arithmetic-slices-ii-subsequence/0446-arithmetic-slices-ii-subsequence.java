class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalCount = 0;
        Map<Integer, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;
                
                int d = (int) diff;
                int countJ = dp[j].getOrDefault(d, 0);
                int countI = dp[i].getOrDefault(d, 0);

                totalCount += countJ;
                dp[i].put(d, countI + countJ + 1);
            }
        }

        return totalCount;
    }
}