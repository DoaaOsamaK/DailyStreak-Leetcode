class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> st = new HashSet<>();
        int a=1;
        for(int i =1;i<arr.length ; i++){
            if(arr[i]==arr[i-1]) a++;
            else{
                if(st.contains(a)) return false;
                else st.add(a);
                a=1;
            }
        }
        if(st.contains(a)) return false;

        return true;
    }
}