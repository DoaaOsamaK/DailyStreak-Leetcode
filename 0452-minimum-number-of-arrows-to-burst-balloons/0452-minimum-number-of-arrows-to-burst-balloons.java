class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
        int arrows=0;
        for(int i=0;i<points.length;i++){
            arrows++;
            int leftLimit=points[i][0];
            int rightLimit=points[i][1];
            while(i<points.length && points[i][0]<=rightLimit  ){
                rightLimit=Math.min(points[i][1],rightLimit);
                leftLimit=Math.min(points[i][0],leftLimit);
                i++;
            }
            i--;
        }
        return arrows;
    }
}