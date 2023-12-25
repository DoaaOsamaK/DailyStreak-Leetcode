class Solution {
    public int helper(String s, int i,HashMap<Integer,Integer> dp) {
        if(i>s.length()) {
            return 0;
        }
        if(i==s.length()) {
            return 1;
        }
        if(s.charAt(i)=='0') {
            return 0;
        }
        int sin = 0;
        int dou = 0;
        if(dp.containsKey(i)){
            sin = dp.get(i);
        } else {
        sin = helper(s,i+1,dp);
        dp.put(i,sin);
        }
        if(i+2<=s.length() && Integer.parseInt(s.substring(i,i+2))<=26) {
        if(dp.containsKey(i+1)) {
            dou = dp.get(i+1);
        } else {
            dou = helper(s,i+2,dp);
            dp.put(i+1,dou);
        }
        } 
        return sin + dou;
    }
    public int numDecodings(String s) {
          HashMap<Integer,Integer> dp = new HashMap<>();
          return helper(s,0,dp);
    }}