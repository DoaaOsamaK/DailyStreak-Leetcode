class Solution {
    public String addBinary(String a, String b) {
        int n1=a.length()-1;
        int n2=b.length()-1;
        int c=0, base=2;
        StringBuilder res= new StringBuilder();
        while(n1>=0 || n2>=0){
            int t1=0,t2=0,sum=0;
            if(n1>=0){
                t1=a.charAt(n1--)-'0';
            }
            if(n2>=0){
                t2=b.charAt(n2--)-'0';
            }
            sum=t1+t2+c;
            if(sum>=base){
                c=1;
                sum=sum-base;
            }
            else{
                c=0;
            }
            res.append(sum);
        }
        if(c==1){
            res.append(c);
        }
        return res.reverse().toString();
    }
}