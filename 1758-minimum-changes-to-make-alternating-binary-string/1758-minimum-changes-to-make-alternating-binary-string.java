class Solution {
    public int minOperations(String s) {
        if(s.length() == 1)
        return 0;
        int zeroOdd = 0,zeroEven = 0,oneOdd = 0,oneEven = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i%2 == 0){
                //for even index
                if(ch == '0') zeroEven++;
                else  oneEven++;
            }
            else{
                //for odd index
                if(ch == '0') zeroOdd++;
                else  oneOdd++;
            }
        }
        int first = zeroOdd + oneEven;
        int second = zeroEven + oneOdd;
        return Math.min(first,second);
    }
}