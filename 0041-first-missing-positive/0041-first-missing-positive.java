class Solution {
    public int firstMissingPositive(int[] array) {
        int n = array.length;

        // Step 1: Perform cyclic sort to arrange positive integers in their correct positions
        for (int i = 0; i < n; i++) {
            while (array[i] > 0 && array[i] <= n && array[i] != array[array[i] - 1]) {
                swap(array, i, array[i] - 1);
            }
        }

        // Step 2: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers are present, return the next positive integer
        return n + 1;
    }

    static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    }