class Solution {
    public int minSteps(String s, String t) {
        byte[] sb = s.getBytes();
        byte[] tb = t.getBytes();
       
        int[] arr = new int[26];
        int count = 0;

        for (int i = 0; i < sb.length; i++) {
            arr[sb[i] - 'a']++;
            arr[tb[i] - 'a']--;
        }

        for (int num : arr) {
            if (num > 0 ) count += num;
        }
        return count;
    }
}