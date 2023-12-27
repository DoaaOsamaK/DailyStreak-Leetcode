class Solution {
    String s1, s2, s3;
    Boolean[][] dp;
    boolean helper(int ct1, int p1, int ct2, int p2, int ct3, int prev){
        if(ct1 == s1.length() && ct2 == s2.length() && ct3 == s3.length()){
            if(Math.abs(p1 - p2) <= 1)  return true;
            return false;
        }
        if(ct1 < s1.length() && ct2 < s2.length() && dp[ct1][ct2] != null)    return dp[ct1][ct2];
        boolean result = false;
        if(ct1 < s1.length() && s1.charAt(ct1) == s3.charAt(ct3)){
            result = helper(ct1 + 1, (prev == 1)? p1: p1 + 1, ct2, p2, ct3 + 1, 1) ? true: result;
        }
        if(ct2 < s2.length() && s2.charAt(ct2) == s3.charAt(ct3)){
            result = helper(ct1, p1, ct2 + 1, (prev == 2)? p2: p2 + 1, ct3 + 1, 2) ? true: result;
        }
        if(ct1 < s1.length() && ct2 < s2.length())  dp[ct1][ct2] = result;  
        return result;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())    return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        dp = new Boolean[s1.length()][s2.length()];
        return helper(0, 1, 0, 1, 0, -1);
    }
}