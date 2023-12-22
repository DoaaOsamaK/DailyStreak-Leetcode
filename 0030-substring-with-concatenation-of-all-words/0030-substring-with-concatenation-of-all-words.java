class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int words_len = words.length * words[0].length();
        List<Integer> res= new ArrayList<>();

        for(int i = 0; i <= s.length()-words_len; i++){
            if(isValid(s.substring(i,i+words_len),words)) res.add(i);
        }
        return res;
    }

    public boolean isValid(String s, String[] words){
        int wordlen = words[0].length();
        String[] arr = new String[words.length];

        Map<String,Integer> map = new HashMap<>();
            for(String word: words){
            if(!map.containsKey(word)){
                map.put(word,1);
            }else{
                map.put(word,map.get(word)+1);
            }
            }

        int i = 0;
        int cnt= 0;
        while(i < s.length()){
            arr[cnt] = s.substring(i,i+wordlen);
            if(map.containsKey(arr[cnt])){
                int val = map.get(arr[cnt]);
                if(val == 0) return false;
                map.put(arr[cnt],--val);
            }else return false;

            cnt++;
            i+= wordlen;
        }

        return true;
    }
}