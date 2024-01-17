class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int len=words.length;
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<len;i++){
            int lent=words[i].length();
            for(int j=0;j<lent;j++){
                if((words[i]).charAt(j)==x){
                    list.add(i);
                    break;
                }
            }
        }
        return list;

    }
}