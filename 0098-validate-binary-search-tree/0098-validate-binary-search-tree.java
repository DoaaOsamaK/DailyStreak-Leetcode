class Solution {
     public static boolean isValidBST(TreeNode root) {
       return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long leftBoundary, long rightBoundary) {
        if(root == null) return true;
        if(root.val <= leftBoundary || root.val >= rightBoundary) return false;
        return validate(root.left, leftBoundary, root.val) && validate(root.right, root.val, rightBoundary);
    }
}