class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int n = nums.length;

        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(seen.containsKey(nums[i])){
                if(i - seen.get(nums[i]) <= k){
                    return true;
                }
            }

            seen.put(nums[i] , i);
        }

        return false;
    }
}