class Solution {
    public int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int positive=0, negative=1;    
    for(int i=0; i<n; i++){
        if(nums[i]>0){
            res[positive]=nums[i];
            positive += 2;
        }
        else{
            res[negative]=nums[i];
            negative += 2;
        }
    }    
    return res;
    }
}