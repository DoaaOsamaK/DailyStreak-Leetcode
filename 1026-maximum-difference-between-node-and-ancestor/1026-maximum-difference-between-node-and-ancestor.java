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
class pair{
    int min;
    int max;
    pair(int a,int b){
        min=a;
        max=b;
    }
    pair(){
        min=(int)(1e9);
        max=(int)(-1e9);
    }
}
class Solution {
    int max;
    public pair helper(TreeNode root){
        pair temp=new pair(root.val,root.val);

        if(root.left!=null){
            pair left=helper(root.left);

            max=Math.max(max,Math.abs(root.val-left.min));
            max=Math.max(max,Math.abs(root.val-left.max));

            temp.min=Math.min(temp.min,Math.min(left.min,root.val));
            temp.max=Math.max(temp.max,Math.max(left.max,root.val));
        }
        if(root.right!=null){
            pair right=helper(root.right);

            max=Math.max(max,Math.abs(root.val-right.min));
            max=Math.max(max,Math.abs(root.val-right.max));

            temp.min=Math.min(temp.min,Math.min(right.min,root.val));
            temp.max=Math.max(temp.max,Math.max(right.max,root.val));
        }
        return temp;
    }
    public int maxAncestorDiff(TreeNode root) {
        max=(int)(-1e9);
        if(root==null)return 0;
        helper(root);
        return max;
    }
}