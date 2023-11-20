class Solution {
    public void nextPermutation(int[] nums) {
        int Bindex = -1;
        int n = nums.length;
        for(int i=n-2; i>=0;i--){
            if(nums[i] < nums[i+1]){
                Bindex = i;
                break;
            }
        }

        if(Bindex == -1){
            reverse(0,n-1,nums);
            return;
        }

        for(int i=n-1;i>Bindex;i--){
            if(nums[i] > nums[Bindex]){
                swap(i,Bindex,nums);
                break;
            }
        }

        reverse(Bindex+1,n-1,nums);
      
    }

    public void reverse(int first,int last,int[] nums){
        while(first<last){
            swap(first,last,nums);
            first++;
            last--;
        }
    }

    public void swap(int i,int Bindex,int[] nums){
        int temp = nums[i];
        nums[i] = nums[Bindex];
        nums[Bindex] = temp;
    }
}