class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;;
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = (l + r)/ 2;
            min = Math.min(nums[m], min);

            if (nums[l] < nums[r] && nums[l] < nums[m]) {
                r = m - 1;
            } else{ 
                l = l + 1;
            }
        }
        return min;
    }
}