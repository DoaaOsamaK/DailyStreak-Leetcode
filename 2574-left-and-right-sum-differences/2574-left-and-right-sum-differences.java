class Solution {
    public int[] leftRightDifference(int[] nums) {
       int leftSum = 0, rightSum = 0;
       for(int n : nums) rightSum += n;
       for(int i = 0; i < nums.length; i ++) {
           leftSum += nums[i];
           rightSum -= nums[i];
           nums[i] = Math.abs((leftSum - nums[i]) - rightSum);
       } 
       return nums;
    }
}