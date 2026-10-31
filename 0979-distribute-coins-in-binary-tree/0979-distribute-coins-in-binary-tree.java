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
    public int distributeCoins(TreeNode root) {
        helper(root);
        return global;

    }
    int global=0;
    int helper(TreeNode root){
            if(root==null)
            return 0;

            int l = helper(root.left);
            int r = helper(root.right);

            int val = l+r+root.val;
            int diff = val-1;
            if(diff!=0)
            global += Math.abs(diff);
            return diff;
    }
}