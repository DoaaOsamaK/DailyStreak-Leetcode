class Solution {
    public boolean makeEqual(String[] words) {
        int[] ar = new int[26];

        for(String word : words) 
        {
            for(char c : word.toCharArray()) 
            {
                ar[c - 'a']++;
            }
        }

        int len = words.length;
        for(int i : ar) 
        {
            if(i % len != 0) 
            {
                return false;
            }
        }
        return true;
    }
}