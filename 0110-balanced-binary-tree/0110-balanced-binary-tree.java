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
    boolean flag=false;
    public boolean isBalanced(TreeNode root) {
        checker(root);
        if(flag) return false;
        return true;
        
    }
    private int checker(TreeNode root){
        if(root==null)
        return 0;
        int l= checker(root.left);
        int r= checker(root.right);
        int differ = Math.abs(l-r);
        if(differ>1)
         flag=true;
        return Math.max(l,r)+1;
    }
}