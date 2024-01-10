class Solution {
    public boolean check(int nums[],int st,int end){
        boolean flag=true;
        ArrayList<Integer> al=new ArrayList<>();
        int i=0;
        int n=nums.length;
        while(i<st){
            al.add(nums[i]);
            i++;
        }
        int j=end+1;
        while(j<n){
            al.add(nums[j]);
            j++;
        }
        for( i=1;i<al.size();i++){
            if(al.get(i-1)>=al.get(i)){
                return false;
            }
        }
        return true;
    }
    public int incremovableSubarrayCount(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int st=i;
            for(int j=i;j<n;j++){
                int end=j;
                if(check(nums,st,end)){
                    count++;
                }
            }
        }
        return count;
    }
}