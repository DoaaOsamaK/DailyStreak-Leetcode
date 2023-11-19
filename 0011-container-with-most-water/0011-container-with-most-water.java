class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int Maxarea=0;
        while (left<right){
            int minht=Math.min(height[left],height[right]);
            Maxarea=Math.max(Maxarea,(minht*(right-left)));
            if (height[left]<height[right]) left++;
            else right--;
        }
        return Maxarea;
        
    }
}