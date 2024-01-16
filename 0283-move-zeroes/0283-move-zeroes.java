class Solution {
    public void moveZeroes(int[] nums) {
        int right = 0;
    for ( int i = 0; i < nums.length; i++ ) {
        if ( nums[i] != 0 ) {
            nums[right++] = nums[i];
        }
    }

    while ( right < nums.length ) {
        nums[right++] = 0;
        
    }



    }
}