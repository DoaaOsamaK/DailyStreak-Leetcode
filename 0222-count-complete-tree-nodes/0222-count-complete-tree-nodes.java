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

   /*
    // method 1:: Using any recursive traversal technique
    // Time Complexity: O(N)

    public int countNodes(TreeNode root) {
        int[] count=new int[1];
        preOrderTraverse(root,count);
        return count[0];
    }
    public void preOrderTraverse(TreeNode root,int[] count){
        if(root ==null) return;

        count[0]++;
        if(root.left!=null) preOrderTraverse(root.left,count);
        if(root.right!=null) preOrderTraverse(root.right,count);
    }
   */
  
  // Method2: Time Complexity: O(log^2 N)

    public int countNodes(TreeNode root) {
       if(root == null) return 0; 
        
        int lh = findHeightLeft(root); 
        int rh = findHeightRight(root); 
        
        // // if leftHeight == rightHeight, then level at current root is completely filled
        // // in this case total nodes at the current level will be [power(2,l)-1];
        // if(lh == rh) return (1<<lh) - 1; 
        
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        
        return 1 + leftNodes + rightNodes; 
    }

    public int findHeightLeft(TreeNode cur) {
        int hght = 0; 
        while(cur!=null) {
            hght++; 
            cur = cur.left; 
        }
        return hght; 
    }

    public int findHeightRight(TreeNode cur) {
        int hght = 0; 
        while(cur!=null) {
            hght++; 
            cur = cur.right; 
        }
        return hght; 
    }
}