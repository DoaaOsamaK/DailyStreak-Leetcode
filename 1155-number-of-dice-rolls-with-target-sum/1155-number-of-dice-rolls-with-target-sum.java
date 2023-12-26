class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        final int mod = 1000000007;

        // Initialize two arrays to store the current and previous rows of dynamic programming table
        int[] dp1 = new int[target + 1];  // Current row
        int[] dp2 = new int[target + 1];  // Previous row

        // Base case: there is one way to achieve a sum of 0 with 0 dice rolls
        dp1[0] = 1;

        // Dynamic programming loop for each die
        for (int i = 1; i <= d; ++i) {
            int prev = dp1[0];  // Initialize the previous value for the first element
            for (int j = 1; j <= target; ++j) {
                dp2[j] = prev;  // Update dp2 based on the previous value
                prev = (int) ((prev + dp1[j]) % mod);  // Update prev for the next iteration

                // If the current sum has more faces than the number of faces on the die, adjust prev
                if (j >= f) prev = (int) ((prev - dp1[j - f] + mod) % mod);
            }

            // Swap dp1 and dp2 for the next iteration
            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;

            // Reset the first element of dp2 for the next iteration
            dp2[0] = 0;
        }

        // The result is in dp1[target], representing the number of ways to achieve the target sum
        return dp1[target];
    }
}