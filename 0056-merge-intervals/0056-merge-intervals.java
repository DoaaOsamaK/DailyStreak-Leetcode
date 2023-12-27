class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer=new ArrayList<>();
        if(intervals.length != 0 || intervals!=null){
            Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

            int start=intervals[0][0];
            int end = intervals[0][1];
            for(int[] i: intervals){
                if(i[0] <= end){
                    end = Math.max(end, i[1]);
                } else {
                    answer.add(new int[]{start,end});
                    start = i[0];
                    end = i[1];
                }
            }
            answer.add(new int[]{start,end}); 
            
        }
        
        return answer.toArray(new int[0][]); 
    }
}