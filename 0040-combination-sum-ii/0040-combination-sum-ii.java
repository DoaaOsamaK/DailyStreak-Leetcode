class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> r = new ArrayList<>();
        
        int n = candidates.length;
        int[] seen = new int[51];        

        for (int i = 0; i < n; i++) {                        
            seen[candidates[i]]++;
        }

        recurse(seen, 1, target, new ArrayList<>(), r);

        return r;
    }

    //fromIndex is used to avoid duplicate solutions, we start from the lower element of the sum to the higher without going back
    void recurse(int[] seen, int fromIndex, int target, List<Integer> current, List<List<Integer>> r) {
        if (target == 0) {
            r.add(new ArrayList<>(current));
        }
        if (target < 0) {
            return;
        }
        for (int i = fromIndex; i < seen.length && i <= target; i++) {
            if (seen[i] > 0) {
                int diff = target - i;
                seen[i]--;
                current.add(i);

                recurse(seen, i, diff, current, r);
                
                seen[i]++;
                current.remove(current.size() - 1);
            }            
        }
    }
}