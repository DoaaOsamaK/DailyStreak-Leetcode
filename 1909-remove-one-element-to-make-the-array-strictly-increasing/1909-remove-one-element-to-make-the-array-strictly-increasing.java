class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int previous = nums[0];
        int temp = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] <= previous) {
                if (++temp == 2)
                    return false;
                if (i == 1 || nums[i] > nums[i - 2])
                    previous = nums[i];
            } else
                previous = nums[i];
        return true;
    }
}