class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> um = new HashMap<>();
        for (int x : nums) {
            um.put(x, um.getOrDefault(x, 0) + 1);
        }
        int maxi = 0;
        for (int value : um.values()) {
            maxi = Math.max(maxi, value);
        }
        int ans = 0;
        for (int value : um.values()) {
            if (value == maxi) {
                ans += value;
            }
        }
        return ans;
    }
}
