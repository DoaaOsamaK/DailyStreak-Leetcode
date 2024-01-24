public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] digits = new int[10];
        return dfs(root, digits);
    }

    private int dfs(TreeNode root, int[] digits) {
        if (root == null) return 0;

        digits[root.val]++;
        if (root.left == null && root.right == null) {
            int cnt = countOdd(digits);
            digits[root.val]--;  // Backtrack
            return (cnt <= 1) ? 1 : 0;
        }

        int leftCount = dfs(root.left, digits);
        int rightCount = dfs(root.right, digits);

        digits[root.val]--;  // Backtrack

        return leftCount + rightCount;
    }

    private int countOdd(int[] digits) {
        int cnt = 0;
        for (int i = 1; i < 10; ++i) {
            if ((digits[i] & 1) == 1) cnt++;
        }
        return cnt;
    }
}