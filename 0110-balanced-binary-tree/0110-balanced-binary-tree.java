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

    public int height(TreeNode node){

        if(node == null){
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalancedUtil(TreeNode node){

        if(node == null){
            return true;
        }

        int leftHeight=0, rightHeight=0;
        if(node.left != null){
            leftHeight = height(node.left); 
        }

        if(node.right != null){
            rightHeight = height(node.right); 
        }

        if(Math.abs(leftHeight-rightHeight) > 1)
            return false;
        else
            return true;

    }

    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }

        if(root.left != null){
            if(!isBalanced(root.left)){
                return false;
            }
        }
        if(root.right != null){
            if(!isBalanced(root.right)){
                return false;
            }
        } 
       
        return isBalancedUtil(root);
        
    }
}