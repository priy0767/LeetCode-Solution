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
    List<Integer> carrier=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        finder(root,targetSum,res,0);
        return res;
    }
    private void finder(TreeNode root,int target,List<List<Integer>> res,int sum){
        if(root==null) return ;
        sum += root.val;
        carrier.add(root.val);
        if(root.left==null && root.right==null && sum==target){
            res.add(new ArrayList<>(carrier));
        }
        // for left
       
        finder(root.left,target,res,sum);
        finder(root.right,target,res,sum);
        carrier.remove(carrier.size()-1);
    }
}