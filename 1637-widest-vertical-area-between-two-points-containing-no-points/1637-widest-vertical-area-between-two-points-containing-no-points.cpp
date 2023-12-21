class Solution {
public:
    int maxWidthOfVerticalArea(vector<vector<int>>& p) {
        int n = p.size();
        int a[n+1],d[n],w=0,m=0;
        for(int i =0;i<n;++i)a[w++]=p[i][0];
        sort(a,a+w);
        for(int i = 1; i < w; ++i) {
            d[i - 1] = a[i] - a[i - 1];
            m=max(m, d[i - 1]);
        }
        return m; 
    }
};