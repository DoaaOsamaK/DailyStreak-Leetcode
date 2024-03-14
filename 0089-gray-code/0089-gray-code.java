class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < Math.pow(2,n); i++) 
            result.add(i ^ i/2);
        return result;
    }
}