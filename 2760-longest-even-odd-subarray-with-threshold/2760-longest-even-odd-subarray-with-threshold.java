class Solution {
    public int longestAlternatingSubarray(int[] nums, int k) {
        int max = 0;

        for (int lo=0, hi=0, reminder = 0; hi<nums.length; hi++) {
            if (nums[hi] > k) {
                lo = hi + 1;
                reminder = 0;
                continue;
            }

            if (nums[hi] % 2 != reminder) {
                if (reminder == 1) { //nums[hi] % 2 == 0
                    lo = hi;
                    reminder = 1;
                } else {   
                    lo = hi + 1;
                    reminder = 0;
                }
                continue;
            }

            reminder = reminder == 0 ? 1 : 0;
            max = Math.max(max, hi - lo + 1);
        }
        return max;
    }
}