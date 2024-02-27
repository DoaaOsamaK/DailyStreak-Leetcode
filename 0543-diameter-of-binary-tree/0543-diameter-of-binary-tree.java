/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {  
        if(root==null)return 0;
        int lhs=diameterOfBinaryTree(root.left);
        int rhs=diameterOfBinaryTree(root.right);
        
        return Math.max(height(root.left)+height(root.right)+2, Math.max(lhs, rhs));
    }
    public int height(TreeNode root){
        if(root==null)return -1;
        
        int lhs=height(root.left);
        int rhs=height(root.right);
        
        return Math.max(lhs, rhs)+1;
    }
}