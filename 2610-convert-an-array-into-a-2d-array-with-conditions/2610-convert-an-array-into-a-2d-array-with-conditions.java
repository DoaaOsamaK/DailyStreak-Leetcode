class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:nums){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
        
        List<List<Integer>> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val=entry.getValue();
            int noProb=Math.min(val,list.size());
            int prob=val>noProb?val-noProb:0;
            
            
            while(prob>0){
            List<Integer> list2=new ArrayList<>();
            list2.add(entry.getKey());
            list.add(list2);
            prob--;
            }
                int i=0;
            while(noProb>0){
            list.get(i).add(entry.getKey());
            i++;
            noProb--;
        
            }
        }
        return list;
    }
}