class Solution {

    double solve(double x,long n){

     double res=1;
   // 3^20-> (9)^10-> (81)^5->81*(81)^4
    //3^(-4)->(3^-2)^-2
     // 2^10-> (2^2)^5->4^5->4*4^4->4*8^2->4*16^1->
     
        while(n>0){
            if(n%2==0){  
              x*=x;
              n/=2;   
            }
            else{
                res*=x;
                n--;
            }
              
        }
        return res;
    }
    public double myPow(double x, int n) {
                //base
        long m=n;
                 if (m == 0) return 1;
        if (x == 1) return 1;
         
         
           // System.out.println(-n+" "+n);   
          return n<0?solve(1/x,-m):solve(x,m);
         
    } 
}