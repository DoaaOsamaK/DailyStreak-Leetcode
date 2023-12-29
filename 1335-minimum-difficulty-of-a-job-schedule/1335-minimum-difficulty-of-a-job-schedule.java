class Solution {
    private int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;
        memo = new int[jobDifficulty.length][d + 1];
        for (int i = 0; i < jobDifficulty.length; i++) {
            Arrays.fill(memo[i], -1); // Initialize memo table with -1
        }
        return combinations(0, jobDifficulty, d);
    }

    public int combinations(int curr, int[] jobDifficulty, int days) {
        if (days == 0 && curr != jobDifficulty.length) return Integer.MAX_VALUE;
        if (curr == jobDifficulty.length) return 0;
        if (memo[curr][days] != -1) return memo[curr][days]; // Check if result is already computed

        int jump = (jobDifficulty.length - curr + 1) - days;
        int min = Integer.MAX_VALUE;
        int temp = Integer.MIN_VALUE;
        for (int i = 1; i <= jump; i++) {
            temp = Math.max(temp, jobDifficulty[curr + i - 1]);
            int a = combinations(curr + i, jobDifficulty, days - 1);
            if (a != Integer.MAX_VALUE) {
                min = Math.min(min, temp + a);
            }
        }
        memo[curr][days] = min; // Store result in memo table
        return min;
    }
}