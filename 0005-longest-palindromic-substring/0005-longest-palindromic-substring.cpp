class Solution {
public:
    string longestPalindrome(string s) {
        if (s.length()==0){
            return "";
        }
        int longest=0;
        int index=0;
        for(int i=0;i<s.length();i++){
            for(int offset=0;offset<2;offset++){
                int curLen =0;
                int left=i-1,right=i+offset;
                while(left>=0 && right<s.length()){
                    if(s[left]==s[right]){
                        if((right-left+1)>longest){
                            longest=right-left+1;
                            index=left;
                        }
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
            }
        }
        if(s.length()>0&longest==0){
            return s.substr(0,1);
        }
        return s.substr(index,longest);
    }
};