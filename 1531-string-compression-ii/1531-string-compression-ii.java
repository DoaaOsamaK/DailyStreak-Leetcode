class Solution {
     private int comp(int n)
    {
        if(n==0) return 0;
        else if(n==1) return 1;
        else if(n<10) return 2;
        else if(n<100) return 3;
        else return 4;
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        int n=s.length();
        int[][] dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++)
         Arrays.fill(dp[i],Integer.MAX_VALUE);
        for(int i=1;i<=n;i++)
        {
            for (int j=0;j<=k;j++)
            {
                if (j>0) 
                   dp[i][j]=dp[i-1][j-1];
                int r=0,c=0,p;
                for (p=i;p>0;p--)
                {
                    if(s.charAt(p-1)==s.charAt(i-1))
                     c++;
                    else if(++r>j) 
                      break;
                    dp[i][j]=Math.min(dp[i][j],dp[p-1][j-r]+comp(c));
                }
            }
        }
        return dp[n][k];   
    }
}