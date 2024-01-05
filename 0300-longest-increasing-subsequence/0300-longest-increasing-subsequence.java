class Solution {
    public int lengthOfLIS(int[] nums) {
        // Store the tails of the increasing subsequences
        int[] tails = new int[nums.length]; 
        // Initialize the length of the longest increasing subsequence
        int len = 0; 

        for (int n : nums) { // Iterate through each number in the given array
            int left = 0, right = len; // Initialize left and right pointers for binary search

            while (left < right) { // Perform binary search to find the insertion position for the current number
                int mid = left + (right - left) / 2; // Calculate mid index

                // If current tail value is less than the number, adjust the left pointer
                if (tails[mid] < n) {
                    left = mid + 1;
                } else { // If current tail value is greater or equal, adjust the right pointer
                    right = mid;
                }
            }

            tails[left] = n; // Insert the number at the determined position

            if (left == len) { // If the current position is at the end, increment the length of the LIS
                len++;
            }
        }
        return len; // Return the length of the longest increasing subsequence
    }
}