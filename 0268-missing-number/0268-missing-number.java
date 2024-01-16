import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        int sum =0;
        for(int i=0;i<=nums.length;i++){
            sum+=i;
            if(i<nums.length)
                sum=sum-nums[i];
        }
        return sum;
    }
}