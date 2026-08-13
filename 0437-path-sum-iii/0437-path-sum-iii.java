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
    
   
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        counter(root,targetSum,0,map);
        return count;
    }
    private void counter(TreeNode root,int targetSum,long parentValue,Map<Long,Integer> map){
        if(root==null) return;
        int value = root.val;
        parentValue += value;
        
        
        long requiredValue = parentValue - targetSum;
        
        if(map.containsKey(requiredValue))
        count += map.get(requiredValue);

        map.put(parentValue, map.getOrDefault(parentValue,0)+1);

        counter(root.left,targetSum,parentValue,map);
        counter(root.right,targetSum,parentValue,map);

        map.put(parentValue,map.get(parentValue)-1);

    }
}