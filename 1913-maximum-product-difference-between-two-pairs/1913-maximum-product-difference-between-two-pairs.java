class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int h=nums[0]*nums[1];
        int h1=nums[n-1]*nums[n-2];
        return h1-h; 
    }
}