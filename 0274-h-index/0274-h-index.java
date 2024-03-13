class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int []freq=new int[n+1]; //n+1 because maximum h index can be the length of citations 
        for(int i: citations){ //for updating the values in freq array for each possible citation
            if(i>n){
                // If the citation count is greater than the total number of papers,
                // count it towards the last index (n), as the H-Index cannot exceed n
                freq[n]++;
            }else{
                freq[i]++;
            }
        }
        int cnt=0;// Initialize a counter for accumulating the number of papers
        for(int i=n;i>=0;i--){
            cnt+=freq[i]; // Accumulate the number of papers with at least i citations

            // If the accumulated count is greater than or equal to i,
            // it satisfies the definition of H-Index, so return i
            if(cnt>=i){
                return i;
            }
        }
        return 0;
    }
}