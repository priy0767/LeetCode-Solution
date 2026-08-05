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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode curr = new TreeNode(-1);
        TreeNode r = curr;
        maker(root,r);
        return curr.right;
    }
    private TreeNode maker(TreeNode root,TreeNode r){
        if(root==null)
        return r;
        r=maker(root.left,r);
       root.left=null;
       // r.left=null;
        r.right=root;
        r=root;
        return maker(root.right,r);
    }
}