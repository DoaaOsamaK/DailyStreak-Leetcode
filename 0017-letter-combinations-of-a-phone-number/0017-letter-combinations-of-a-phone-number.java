class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits.length() ==0) return result;
        HashMap<String, String> map = new HashMap();
        map.put("2","abc"); map.put("3","def"); map.put("4","ghi");
        map.put("5","jkl"); map.put("6","mno"); map.put("7","pqrs");
        map.put("8","tuv"); map.put("9","wxyz"); 

        Deque<String> deque = new ArrayDeque();
        deque.add("");
        for(int i=0; i<digits.length();i++){
            String d = digits.substring(i,i+1);
            String mapValues = map.get(d);      // get the value of first digi
            int n = deque.size();
            for(int j = 0; j<n; j++){
                String pull = deque.pollFirst();
                for(int k = 0; k<mapValues.length(); k++){
                    String temp = pull.concat(mapValues.charAt(k)+"");
                    deque.add(temp);
                }
            }
        }
        while(!deque.isEmpty()){
            result.add(deque.poll());
        }

        return result;
        
    }
}