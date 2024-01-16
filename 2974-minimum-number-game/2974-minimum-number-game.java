class Solution {
    public int[] numberGame(int[] nums) {
          int n=nums.length;
          int arr[]=new int[n];
         Arrays.sort(nums);
         for(int i=0;i<n;i+=2){
             arr[i]=nums[i+1];
             arr[i+1]=nums[i];
         }
    return arr;
    }
}