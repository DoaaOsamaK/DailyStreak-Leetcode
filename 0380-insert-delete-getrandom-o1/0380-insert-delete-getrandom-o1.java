class RandomizedSet {
    Random rand ;
    List<Integer> data ;

    public RandomizedSet() {
        data = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!data.contains(val)){
            data.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
       
            return data.remove(Integer.valueOf(val));
            
    }
    
    public int getRandom() {
        return data.get(rand.nextInt(data.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
