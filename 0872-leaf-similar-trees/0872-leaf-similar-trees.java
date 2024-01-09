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
    public ArrayList<Integer> getLeafData(TreeNode node){
        ArrayList<Integer> arr= new ArrayList<Integer>();
        if(node.left==null && node.right==null){
            arr.add(node.val);
            return arr;
        }
        if(node.left!=null){
            arr.addAll(getLeafData(node.left));
        }
        if(node.right!=null){
            arr.addAll(getLeafData(node.right));
        }
        return arr;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList arr1=getLeafData(root1);
        ArrayList arr2=getLeafData(root2);
        if(arr1.size() != arr2.size()){
            return false;
        }
        for(int i=0;i<arr1.size();i++){
            if(arr1.get(i) != arr2.get(i)){
                return false;
            }
        }
        return true;
    }
}