class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i<word1.length(); i++){
            int v1 = map1.getOrDefault(word1.charAt(i), 0);
            map1.put(word1.charAt(i), v1 + 1);
        }
        for(int i = 0; i<word1.length(); i++){
            if(map1.containsKey(word2.charAt(i))){
                int v2 = map2.getOrDefault(word2.charAt(i), 0);
                map2.put(word2.charAt(i), v2 + 1);
            }else{
                return false;
            }
        }
        ArrayList<Integer> map1Values = new ArrayList(map1.values());
        ArrayList<Integer> map2Values = new ArrayList(map2.values());
        Collections.sort(map1Values);
        Collections.sort(map2Values);

        return map1Values.equals(map2Values);
    }
}