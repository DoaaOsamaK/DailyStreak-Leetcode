class Solution {
    public int majorityElement(int[] nums) {

          HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            }
            else{
                hm.put(num, 1);
            } 
        }

        // Set<Integer> keys=hm.keySet();

        for (Integer k : hm.keySet()) {
            if(hm.get(k)>nums.length/2){
                return k;
            }
            
        }

        return -1;
      
    }
}