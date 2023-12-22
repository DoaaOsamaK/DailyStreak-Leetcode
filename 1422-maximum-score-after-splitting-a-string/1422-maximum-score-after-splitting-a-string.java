class Solution 
{
    public int maxScore(String s) 
    {
        int n=s.length();
        int zero[]=new int[n];
        int one[]=new int[n];
        int count=0;
        if(n==2 && ((s.charAt(0)=='0' && s.charAt(1)=='0')||(s.charAt(0)=='1' && s.charAt(1)=='1')))return 1;
        if(n==2 && ((s.charAt(0)=='0' && s.charAt(1)=='1')))return 2;

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='0')count++;
            zero[i]=count;
        }
        count=0;
        for(int i=n-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(ch=='1')count++;
            one[i]=count;
        }
        count=0;
        int curr=0;
        for(int i=1;i<n-1;i++)
        {
            curr=zero[i]+one[i];
            count=Math.max(count,curr);
        }
        return count;
    }
}