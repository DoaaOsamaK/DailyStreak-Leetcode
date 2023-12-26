class Solution {
    public int[] getConcatenation(int[] nums) {
        int l=nums.length;
        int[] ans=new int[2*l];
        int j=0;
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=nums[j];
             j++;
            if(i==l-1)
            {
                j=0;
            }
        } 
        return ans;       
    }
}